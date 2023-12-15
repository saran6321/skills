package com.sample.demo.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.color.MaterialColors
import com.sample.demo.R
import com.sample.demo.adapter.ProductExpandableGroupItem
import com.sample.demo.adapter.ProductItem
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Category
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ActivityMainLayoutBinding
import com.sample.demo.utility.isInternetAvailable
import com.sample.demo.utility.launchWhenResumed
import com.sample.demo.utility.orDefaultInt
import com.sample.demo.viewmodels.MainViewModel
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IActivityCommunicator {
  private lateinit var binding: ActivityMainLayoutBinding
  private lateinit var viewModel: MainViewModel
  private var isDark: Boolean = false
  private val productSection by lazy {
    Section().apply {
      setHideWhenEmpty(true)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)
    window?.statusBarColor = MaterialColors.getColor(
      binding.root.context,
      com.example.design2.R.attr.Space,
      com.example.design2.R.color.white
    )
    viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    with(binding.rvProducts) {
      layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
      clipToPadding = false
      adapter = GroupAdapter<GroupieViewHolder>().apply {
        add(productSection)
      }
    }

    viewModel.productsData.observe(this) { productsData ->
      if (productsData?.status == true) {                 // loads the success data
        launchWhenResumed {
          val sectionList = mutableListOf<ExpandableGroup>()
          productsData.categories?.forEach {
            if (!it.items.isNullOrEmpty()){
              Log.d("saran", "section list creation")
              sectionList.add(produceExpandableGroup(it))
            }
          }
          if (sectionList.isNotEmpty()) {
            Log.d("saran", "section list not empty")
            productSection.clear()
            productSection.addAll(sectionList)
          } else {
            Log.d("saran", "section list empty")
          }
        }
      } else {                                  // Allows user to retry loading on api failure
        Toast.makeText(this,"Server Down !",Toast.LENGTH_SHORT).show()
      }
    }

    if (isInternetAvailable(this)) {      // checks for the internet availability
      viewModel.getProducts()
    } else {
      viewModel.getProducts()
      Toast.makeText(this, "Please check your network connection !", Toast.LENGTH_LONG).show()
    }
  }

  private fun produceExpandableGroup(category: Category): ExpandableGroup =
    ExpandableGroup(ProductExpandableGroupItem(category.name)).apply {
      isExpanded = true
      category.items?.forEach {
        add(ProductItem(it, this@MainActivity))
      }
    }

  override fun addToCart(item: Item) {
    if (isDark){
//      setTheme(com.example.design2.R.style.Design_Theme)
//      recreate()
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
      delegate.applyDayNight()
    }else{
//      setTheme(com.example.design2.R.style.Design_Theme)
//      recreate()
      AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
      delegate.applyDayNight()
    }
    isDark = !isDark
    viewModel.addToCart(item)
    Toast.makeText(this,"Added ${item.name}",Toast.LENGTH_SHORT).show()
  }

  override fun removeCartItem(item: Item) {
    viewModel.removeCartItem(item)
  }

  override fun addOrRemoveFavourite(item: Item) {
    viewModel.addOrRemoveFavourite(item)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_item, menu)
    val menuCartItem = menu?.findItem(R.id.menu_cart)?.setActionView(R.layout.layout_cart_icon)
    viewModel.getCartsCount().observe(this) {
      menuCartItem?.actionView?.findViewById<TextView>(R.id.tv_cart_count)?.text =
        it.orDefaultInt(0).toString()
    }
    menuCartItem?.actionView?.findViewById<ConstraintLayout>(R.id.cl_cart)?.setOnClickListener {
      startActivity(Intent(this@MainActivity, CartActivity::class.java))
    }
    return true
  }
}

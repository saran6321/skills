package com.sample.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.adapter.CartsAdapter
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ActivityCartsLayoutBinding
import com.sample.demo.utility.orDefaultDouble
import com.sample.demo.utility.setPriceOrHideView
import com.sample.demo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class CartActivity : AppCompatActivity(), IActivityCommunicator {
  private lateinit var binding: ActivityCartsLayoutBinding
  private lateinit var viewModel: MainViewModel

  private var cartsAdapter: CartsAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityCartsLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)
    viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    binding.ivBack.setOnClickListener {
      finish()
    }
    with(binding.rvCarts) {
      layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
      clipToPadding = false
      viewModel.getCartsData().observe(this@CartActivity){
        cartsAdapter = CartsAdapter( iActivityCommunicator = this@CartActivity)
        adapter = cartsAdapter
        cartsAdapter?.addItems(it)
      }
    }
    viewModel.getCartsTotal()?.observe(this){
      binding.tvTotalValue.setPriceOrHideView(it.orDefaultDouble(0.0).roundToInt().toDouble())
    }
  }

  override fun addToCart(item: Item) {
    viewModel.addToCart(item)
  }

  override fun removeCartItem(item: Item) {
    viewModel.removeCartItem(item)
  }

  override fun addOrRemoveFavourite(item: Item) {
    viewModel.addOrRemoveFavourite(item)
  }
}

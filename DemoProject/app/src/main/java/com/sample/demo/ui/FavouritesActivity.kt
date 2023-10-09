package com.sample.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.adapter.FavouritesAdapter
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ActivityFavouritesLayoutBinding
import com.sample.demo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesActivity : AppCompatActivity(), IActivityCommunicator {
  private lateinit var binding: ActivityFavouritesLayoutBinding
  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityFavouritesLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)
    viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    binding.ivBack.setOnClickListener {
      finish()
    }
    with(binding.rvFavourites) {
      layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
      clipToPadding = false
      viewModel.getFavourites().observe(this@FavouritesActivity){
        adapter = FavouritesAdapter(it.orEmpty(), this@FavouritesActivity)
      }
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

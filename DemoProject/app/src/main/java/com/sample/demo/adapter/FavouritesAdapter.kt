package com.sample.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.LayoutFavouriteItemBinding
import com.sample.demo.utility.setPriceOrHideView
import com.sample.demo.utility.setTextOrHideView

class FavouritesAdapter(
  private val items: List<Item>, private val iActivityCommunicator: IActivityCommunicator
) : RecyclerView.Adapter<FavouritesAdapter.FavouritesHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesHolder =
    FavouritesHolder(
      LayoutFavouriteItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      ).root
    )


  override fun getItemCount(): Int  = items.size

  inner class FavouritesHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val favouriteItemBinding:LayoutFavouriteItemBinding = LayoutFavouriteItemBinding.bind(itemView)

    fun bind(position: Int){
      with(favouriteItemBinding){
        val productItem = items[position]
        Glide.with(ivProduct.context).load(productItem.icon).into(ivProduct)
        tvProductTitle.setTextOrHideView(productItem.name.toString())
        tvCount.setTextOrHideView(productItem.count.toString())
        tvPrice.setPriceOrHideView(productItem.price)
        ivAddCart.setOnClickListener {
          iActivityCommunicator.addToCart(productItem)
        }
        ivFavourite.setOnClickListener {
          iActivityCommunicator.addOrRemoveFavourite(productItem)
        }
      }
    }
  }

  override fun onBindViewHolder(holder: FavouritesHolder, position: Int) {
    holder.bind(position)
  }
}

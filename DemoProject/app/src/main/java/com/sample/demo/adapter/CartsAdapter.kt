package com.sample.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.LayoutCartItemBinding
import com.sample.demo.utility.setPriceOrHideView
import com.sample.demo.utility.setTextOrHideView

class CartsAdapter(
  private val items: List<Item>, private val iActivityCommunicator: IActivityCommunicator
) : RecyclerView.Adapter<CartsAdapter.CartHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder =
    CartHolder(
      LayoutCartItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      ).root
    )


  override fun getItemCount(): Int  = items.size

  inner class CartHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val cartItemBinding:LayoutCartItemBinding = LayoutCartItemBinding.bind(itemView)

    fun bind(position: Int){
      with(cartItemBinding){
        val productItem = items[position]
        Glide.with(ivProduct.context).load(productItem.icon).into(ivProduct)
        tvProductTitle.setTextOrHideView(productItem.name.toString())
        tvCount.setTextOrHideView(productItem.count.toString())
        tvPrice.setPriceOrHideView(productItem.price)
        ivAddCart.setOnClickListener {
          iActivityCommunicator.addToCart(productItem)
        }
        ivRemoveCart.setOnClickListener{
          iActivityCommunicator.removeCartItem(productItem)
        }
      }
    }
  }

  override fun onBindViewHolder(holder: CartHolder, position: Int) {
    holder.bind(position)
  }
}

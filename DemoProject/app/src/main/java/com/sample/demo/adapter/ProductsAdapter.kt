package com.sample.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ProductItemBinding
import com.sample.demo.utility.setPriceOrHideView
import com.sample.demo.utility.setTextOrHideView

class ProductsAdapter(
  private val items: List<Item>, private val iActivityCommunicator: IActivityCommunicator
) : RecyclerView.Adapter<ProductsAdapter.ProductsHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder =
    ProductsHolder(
      ProductItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      ).root
    )


  override fun getItemCount(): Int  = items.size

  inner class ProductsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val productItemBinding:ProductItemBinding = ProductItemBinding.bind(itemView)

    fun bind(position: Int){
      with(productItemBinding){
        val productItem = items[position]
        Glide.with(ivProduct.context).load(productItem.icon).into(ivProduct)
        tvProductTitle.setTextOrHideView(productItem.name)
        tvPrice.setPriceOrHideView(productItem.price)
        ivAddCart.setOnClickListener {
          iActivityCommunicator.addToCart(productItem)
        }
      }
    }
  }

  override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
    holder.bind(position)
  }
}

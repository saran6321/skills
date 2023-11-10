package com.sample.demo.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.sample.demo.R
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ProductItemBinding
import com.sample.demo.utility.setPriceOrHideView
import com.sample.demo.utility.setTextOrHideView
import com.xwray.groupie.viewbinding.BindableItem

class ProductItem(
  private val item: Item, private val iActivityCommunicator: IActivityCommunicator
) : BindableItem<ProductItemBinding>() {
  override fun bind(viewBinding: ProductItemBinding, position: Int) {
    with(viewBinding){
      Glide.with(ivProduct.context).load(item.icon).into(ivProduct)
      tvProductTitle.setTextOrHideView(item.name)
      tvPrice.setPriceOrHideView(item.price)
      btAddCart.setOnClickListener {
        iActivityCommunicator.addToCart(item)
      }
      btAddCart.bringToFront()
    }
  }
  override fun getLayout(): Int = R.layout.product_item
  override fun initializeViewBinding(view: View): ProductItemBinding = ProductItemBinding.bind(view)
}

package com.sample.demo.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.demo.R
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.LayoutRvProductsBinding
import com.xwray.groupie.viewbinding.BindableItem

class ProductItem(
  private val items: List<Item>, private val iActivityCommunicator: IActivityCommunicator
) : BindableItem<LayoutRvProductsBinding>() {
  override fun bind(viewBinding: LayoutRvProductsBinding, position: Int) {
    with(viewBinding.root) {
      layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
      adapter = ProductsAdapter(items, iActivityCommunicator)
    }
  }
  override fun getLayout(): Int = R.layout.layout_rv_products
  override fun initializeViewBinding(view: View): LayoutRvProductsBinding = LayoutRvProductsBinding.bind(view)
}

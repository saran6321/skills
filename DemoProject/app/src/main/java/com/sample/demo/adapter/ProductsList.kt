package com.sample.demo.adapter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.demo.R
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ProductsListBinding
import com.xwray.groupie.viewbinding.BindableItem

class ProductsList(
  private val items: List<Item>, private val iActivityCommunicator: IActivityCommunicator
) : BindableItem<ProductsListBinding>() {
  override fun bind(viewBinding: ProductsListBinding, position: Int) {
    with(viewBinding.rvProducts) {
      layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
      adapter = ProductsAdapter(items, iActivityCommunicator)
    }
  }
  override fun getLayout(): Int = R.layout.products_list
  override fun initializeViewBinding(view: View): ProductsListBinding = ProductsListBinding.bind(view)
}

package com.sample.demo.adapter

import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sample.demo.R
import com.sample.demo.databinding.ProductListExpandableGroupBinding
import com.sample.demo.utility.setTextOrHideView
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.viewbinding.BindableItem

class ProductExpandableGroupItem(private val name: String?): BindableItem<ProductListExpandableGroupBinding>(),ExpandableItem {
  private lateinit var expandableGroup: ExpandableGroup
  private lateinit var viewBinding: ProductListExpandableGroupBinding
  override fun bind(viewBinding: ProductListExpandableGroupBinding, position: Int) {
    this.viewBinding = viewBinding
    with(viewBinding){
      (viewBinding.root.layoutParams as? StaggeredGridLayoutManager.LayoutParams)?.isFullSpan = true    // used to expand this particular item in the staggered grid layout
      tvGroupTitle.setTextOrHideView(name)
      ivExpand.setImageResource(R.drawable.arrow_down_rounded_gray)
      bindIcon()
      ivExpand.setOnClickListener{
        expandableGroup.onToggleExpanded()
        bindIcon()
      }
    }
  }

  private fun bindIcon() {
    if (::viewBinding.isInitialized) {
      viewBinding.ivExpand.animate().setDuration(200L)
        .rotation(if (expandableGroup.isExpanded) 180f else 0f)
    }
  }

  override fun getLayout(): Int = R.layout.product_list_expandable_group

  override fun initializeViewBinding(view: View): ProductListExpandableGroupBinding = ProductListExpandableGroupBinding.bind(view)

  override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
    this.expandableGroup = onToggleListener
  }

}

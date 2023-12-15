package com.sample.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.color.MaterialColors
import com.sample.demo.R
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.local.ColorData
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ColorItemBinding
import com.sample.demo.databinding.ProductItemBinding
import com.sample.demo.utility.setPriceOrHideView
import com.sample.demo.utility.setTextOrHideView

class ColorsAdapter(
  private val items: List<ColorData>, private val iActivityCommunicator: IActivityCommunicator
) : RecyclerView.Adapter<ColorsAdapter.ColorHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder =
    ColorHolder(
      ColorItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
      ).root
    )


  override fun getItemCount(): Int  = items.size

  inner class ColorHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val colorItemBinding:ColorItemBinding = ColorItemBinding.bind(itemView)

    fun bind(position: Int){
      with(colorItemBinding){
        val color = items[position]
        tvColor.setTextOrHideView(color.name)
        tvColor.setBackgroundColor(
          MaterialColors.getColor(
          tvColor.context,
          color.color,
          com.example.design2.R.color.white
        ))
        root.setOnClickListener{
          iActivityCommunicator.addToCart(Item())
        }
      }
    }
  }

  override fun onBindViewHolder(holder: ColorHolder, position: Int) {
    holder.bind(position)
  }
}

package com.sample.nasademo.utility

import android.view.View
import android.widget.TextView

fun View.showView() {
  this.visibility = View.VISIBLE
}

fun View.hideView(){
  this.visibility = View.GONE
}

fun TextView.setTextOrHideView(value: String?) {
  if (!value.isNullOrEmpty()) {
    this.text = value
    this.showView()
  } else {
    this.hideView()
  }
}
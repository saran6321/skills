package com.sample.demo.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
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

fun isInternetAvailable(context: Context): Boolean {
  val connectivityManager =
    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
  return networkInfo != null && networkInfo.isConnected
}
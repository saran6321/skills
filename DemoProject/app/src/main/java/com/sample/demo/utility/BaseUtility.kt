package com.sample.demo.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sample.demo.R
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

fun TextView.setPriceOrHideView(value: Double?) {
  if (value != null) {
    this.text = this.context.getString(R.string.price_per_kg,value.toString())
    this.showView()
  } else {
    this.text = this.context.getString(R.string.text_free)
  }
}

fun String?.orDefault(value: String): String {
  return this ?: value
}

fun Int?.orDefaultInt(value: Int): Int {
  return this ?: value
}

fun Double?.orDefaultDouble(value: Double): Double {
  return this ?: value
}

fun isInternetAvailable(context: Context): Boolean {
  val connectivityManager =
    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
  val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
  return networkInfo != null && networkInfo.isConnected
}

fun LifecycleOwner.launchWhenResumed(action: suspend () -> Unit) {
  val coroutineContext = Job()
  this.lifecycleScope.launch(coroutineContext) {
    repeatOnLifecycle(Lifecycle.State.RESUMED) {
      action()
      coroutineContext.cancel()
    }
  }
}
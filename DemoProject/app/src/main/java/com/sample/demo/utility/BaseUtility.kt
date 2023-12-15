package com.sample.demo.utility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.design2.R
import com.sample.demo.data.local.ColorData
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
    this.text = this.context.getString(com.sample.demo.R.string.price_per_kg,value.toString())
    this.showView()
  } else {
    this.text = this.context.getString(com.sample.demo.R.string.text_free)
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

fun getColorList(): List<ColorData> {
  return listOf(
    ColorData("Space", R.attr.Space),
    ColorData("Ocean", R.attr.Ocean),
    ColorData("Nature", R.attr.Nature),
    ColorData("Kesar", R.attr.Kesar),
    ColorData("Coral", R.attr.Coral),
    ColorData("Theme_Grey", R.attr.Theme_Grey),
    ColorData("Berry", R.attr.Berry),
    ColorData("Charcoal", R.attr.Charcoal),
    ColorData("Dark_sky", R.attr.Dark_sky),
    ColorData("Honey", R.attr.Honey),
    ColorData("Teal", R.attr.Teal),
    ColorData("Water", R.attr.Water),
    ColorData("Paper", R.attr.Paper),
    ColorData("Capsicum", R.attr.Capsicum),
    ColorData("Chillie", R.attr.Chillie),
    ColorData("Pumpkin", R.attr.Pumpkin),
    ColorData("Muskmelon", R.attr.Muskmelon),
    ColorData("Mango", R.attr.Mango),
    ColorData("Oyster", R.attr.Oyster),
    ColorData("White_1", R.attr.White_1),
    ColorData("Light_Grey", R.attr.Light_Grey),
    ColorData("White_2", R.attr.White_2),
    ColorData("White_3", R.attr.White_3),
    ColorData("Winter_Grey", R.attr.Winter_Grey),
    ColorData("White_4", R.attr.White_4),
    ColorData("Line_grey", R.attr.Line_grey),
    ColorData("Grey", R.attr.Grey),
    ColorData("Separator_grey", R.attr.Separator_grey),
    ColorData("Stale_Grey", R.attr.Stale_Grey)
  )
}

fun isLightMode() = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO
fun toggleThemeMode(){
  if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
  } else {
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
  }
}
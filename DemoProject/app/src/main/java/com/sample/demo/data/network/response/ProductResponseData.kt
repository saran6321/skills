package com.sample.demo.data.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ProductResponseData(
  @SerializedName("status") val status: Boolean = true,
  val message: String? = null,
  val error: String? = null,
  val categories: @RawValue List<Category>? = null
) : Parcelable
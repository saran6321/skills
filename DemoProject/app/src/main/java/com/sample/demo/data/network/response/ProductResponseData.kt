package com.sample.demo.data.network.response

data class ProductResponseData(
  val status: Boolean = true,
  val message: String? = null,
  val error: String? = null,
  val categories: List<Category>? = null
)
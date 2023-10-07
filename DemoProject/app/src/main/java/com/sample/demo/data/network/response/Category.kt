package com.sample.demo.data.network.response

data class Category(
  val id: Int? = null,
  val name: String? = null,
  val items: List<Item>? = null
)
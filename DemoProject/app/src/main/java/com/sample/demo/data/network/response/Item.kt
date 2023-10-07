package com.sample.demo.data.network.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class Item(
  @PrimaryKey val id: Int? = null,
  val name: String? = null,
  val icon: String? = null,
  val price: Double? = null,
  var count: Int? = 0,
  var total: Double? = 0.0
)
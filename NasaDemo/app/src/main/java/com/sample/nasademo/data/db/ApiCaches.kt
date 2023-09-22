package com.sample.nasademo.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "caches")
data class ApiCaches(
  @PrimaryKey var url: String,
  var response: String,
  var protocol: String,
  var message: String,
  var code: Int
)

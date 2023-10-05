package com.sample.demo.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskData(
  @PrimaryKey var id: Int? = null,
  var task: String
)

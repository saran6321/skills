package com.sample.demo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ApiCaches::class, TaskData::class], version = 1, exportSchema = true)
abstract class CacheDatabase : RoomDatabase() {
  abstract fun cachesDao(): ApiCacheDao
  abstract fun dataDao(): TaskDao
}
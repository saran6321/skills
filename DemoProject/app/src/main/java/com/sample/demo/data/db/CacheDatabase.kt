package com.sample.demo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.demo.data.network.response.Item

@Database(entities = [ApiCaches::class, Item::class], version = 1, exportSchema = true)
abstract class CacheDatabase : RoomDatabase() {
  abstract fun cachesDao(): ApiCacheDao
  abstract fun cartDao(): CartDao
}
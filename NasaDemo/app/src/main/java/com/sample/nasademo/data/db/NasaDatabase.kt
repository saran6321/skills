package com.sample.nasademo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ApiCaches::class], version = 1, exportSchema = false)
abstract class NasaDatabase : RoomDatabase() {
  abstract fun cachesDao(): ApiCacheDao
}
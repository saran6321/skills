package com.sample.nasademo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import javax.annotation.Nullable

@Dao
interface ApiCacheDao {
  @Nullable @Query("SELECT * FROM caches WHERE url = :url")
  fun getCacheResponse(url: String): ApiCaches?

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCacheResponse(apiCaches: ApiCaches): Long
}
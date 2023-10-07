package com.sample.demo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sample.demo.data.network.response.Item
import javax.annotation.Nullable

@Dao
interface CartDao {
  @Nullable @Query("SELECT * FROM carts WHERE id = :id")
  fun getCart(id: Int): Item?

  @Query("SELECT * FROM carts")
  fun getAllCarts(): LiveData<List<Item>?>

  @Query("SELECT SUM(count) FROM carts")
  fun getCartsCount(): LiveData<Int>

  @Nullable @Query("SELECT SUM(total) FROM carts")
  fun getCartsTotal(): LiveData<Double?>?

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCart(item: Item): Long

  @Delete
  fun deleteCart(item: Item): Int
}
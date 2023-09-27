package com.sample.nasademo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import javax.annotation.Nullable

@Dao
interface TaskDao {
  @Nullable @Query("SELECT * FROM tasks WHERE rowid = :id")
  fun getTaskWithId(id: Int): TaskData?

  @Query("SELECT * FROM tasks")
  fun getAllTasks(): List<TaskData>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertTask(task: TaskData): Long
}
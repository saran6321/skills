package com.sample.nasademo.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sample.nasademo.data.db.NasaDatabase
import com.sample.nasademo.data.db.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
  @Provides fun providesDataBase(@ApplicationContext context: Context): NasaDatabase =
    Room.databaseBuilder(context = context, NasaDatabase::class.java, DATABASE_NAME)
      .addMigrations(migration1to2)
      .fallbackToDestructiveMigration().build()

  @Provides fun providesTaskDao(nasaDatabase: NasaDatabase): TaskDao = nasaDatabase.dataDao()

  companion object {
    const val DATABASE_NAME = "nasa.db"

    val migration1to2 = object : Migration(1, 2) {
      override fun migrate(database: SupportSQLiteDatabase) {
        // Migration code from version 1 to 2
        // database.execSQL("ALTER TABLE tasks ADD COLUMN isFinished INTEGER")
      }
    }
  }
}
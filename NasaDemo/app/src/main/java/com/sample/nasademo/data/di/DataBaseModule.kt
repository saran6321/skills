package com.sample.nasademo.data.di

import android.content.Context
import androidx.room.Room
import com.sample.nasademo.data.db.NasaDatabase
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
      .fallbackToDestructiveMigration().build()

  companion object {
    const val DATABASE_NAME = "nasa.db"
  }
}
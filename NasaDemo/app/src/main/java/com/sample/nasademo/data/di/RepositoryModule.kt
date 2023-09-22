package com.sample.nasademo.data.di

import com.sample.nasademo.data.network.NasaApi
import com.sample.nasademo.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
  @Provides
  fun providesMainRepository(nasaApi: NasaApi) : MainRepository = MainRepository(nasaApi)
}
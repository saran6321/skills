package com.sample.demo.data.di

import com.sample.demo.data.network.ProductsApi
import com.sample.demo.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
  @Provides
  fun providesMainRepository(productsApi: ProductsApi) : MainRepository = MainRepository(productsApi)
}
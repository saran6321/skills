package com.sample.demo.data.di

import com.sample.demo.data.db.CacheDatabase
import com.sample.demo.data.network.ProductsApi
import com.sample.demo.data.network.ApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

  @Provides
  fun providesApiInterceptor(cacheDatabase: CacheDatabase): ApiInterceptor =
    ApiInterceptor(cacheDatabase)

  @Provides
  fun providesApiHttpClient(interceptor: ApiInterceptor): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(interceptor).build()

  @Provides
  fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()

  @Provides
  fun providesProductsApi(retrofit: Retrofit): ProductsApi = retrofit.create(ProductsApi::class.java)

  companion object {
    const val BASE_URL = "https://skarapp2.free.beeceptor.com/"
  }
}
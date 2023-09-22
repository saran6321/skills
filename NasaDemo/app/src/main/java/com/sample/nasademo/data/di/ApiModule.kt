package com.sample.nasademo.data.di

import com.sample.nasademo.data.db.NasaDatabase
import com.sample.nasademo.data.network.NasaApi
import com.sample.nasademo.data.network.NasaInterceptor
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
  fun providesNasaInterceptor(nasaDatabase: NasaDatabase): NasaInterceptor =
    NasaInterceptor(nasaDatabase)

  @Provides
  fun providesNasaHttpClient(interceptor: NasaInterceptor): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(interceptor).build()

  @Provides
  fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()

  @Provides
  fun providesNasaApi(retrofit: Retrofit): NasaApi = retrofit.create(NasaApi::class.java)

  companion object {
    const val BASE_URL = "https://api.nasa.gov/"
  }
}
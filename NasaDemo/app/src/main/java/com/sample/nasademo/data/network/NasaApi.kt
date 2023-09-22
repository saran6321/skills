package com.sample.nasademo.data.network

import com.sample.nasademo.data.network.response.NasaResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NasaApi {
  @Headers("Content-Type: application/json; charset=UTF-8", "Accept: application/json")
  @GET("planetary/apod")
  suspend fun getTodayImage(
    @Query("api_key") apiKey: String
  ): Response<NasaResponseData?>?
}
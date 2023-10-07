package com.sample.demo.data.network

import com.sample.demo.data.network.response.ProductResponseData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductsApi {
  @Headers("Content-Type: application/json; charset=UTF-8", "Accept: application/json")
  @GET("productlist")
  suspend fun getProducts(): Response<ProductResponseData?>?
}
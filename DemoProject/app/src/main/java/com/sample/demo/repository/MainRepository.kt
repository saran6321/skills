package com.sample.demo.repository

import com.sample.demo.data.network.ProductsApi

class MainRepository(private val productsApi: ProductsApi) {

  suspend fun getProducts() = productsApi.getProducts()

  suspend fun getDataList() = productsApi.getDataList()
}
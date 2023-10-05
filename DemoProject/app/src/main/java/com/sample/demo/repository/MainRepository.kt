package com.sample.demo.repository

import com.sample.demo.data.network.NasaApi

class MainRepository(private val nasaApi: NasaApi) {

  suspend fun getTodayImage(apiKey : String) = nasaApi.getTodayImage(apiKey)
}
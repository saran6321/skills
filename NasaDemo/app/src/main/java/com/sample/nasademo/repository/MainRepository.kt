package com.sample.nasademo.repository

import com.sample.nasademo.data.network.NasaApi

class MainRepository(private val nasaApi: NasaApi) {

  suspend fun getTodayImage(apiKey : String) = nasaApi.getTodayImage(apiKey)
}
package com.sample.nasademo.repository

import com.sample.nasademo.data.network.NasaApi
import javax.inject.Inject

class MainRepository(val nasaApi: NasaApi) {

  suspend fun getTodayImage(apiKey : String) = nasaApi.getTodayImage(apiKey)
}
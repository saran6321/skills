package com.sample.nasademo.data.network

import com.sample.nasademo.data.db.ApiCaches
import com.sample.nasademo.data.db.NasaDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class NasaInterceptor(val nasaDatabase: NasaDatabase) : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val response = chain.run {
      proceed(this.request())
    }

    return cacheResponse(response)
  }

  private fun saveResponse(response: Response): Response {
    CoroutineScope(Dispatchers.IO).launch {
      try {
        val body = response.peekBody(Long.MAX_VALUE).string()
        nasaDatabase.cachesDao().insertCacheResponse(
          ApiCaches(
            url = response.request.url.toUrl().toString(),
            response = body,
            protocol = response.protocol.toString(),
            message = response.message,
            code = response.code
          )
        )
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
    return response
  }

  private fun cacheResponse(response: Response): Response {
    return try {
      if (response.isSuccessful) {
        saveResponse(response)
      } else {
        fetchResponseFromDb(response)
      }
    } catch (e: Exception) {
      fetchResponseFromDb(response)
    }
  }

  private fun fetchResponseFromDb(response: Response): Response {
    var result: Response? = null
    val cache = nasaDatabase.cachesDao().getCacheResponse(response.request.url.toString())
    if (null != cache) {
      result =
        Response.Builder().request(Request.Builder().url(cache.url).build()).code(cache.code)
          .body(cache.response.toResponseBody()).protocol(Protocol.get(cache.protocol))
          .message(cache.message).build()
    }
    return result ?: response
  }
}
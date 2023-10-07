package com.sample.demo.data.network

import android.util.Log
import com.sample.demo.data.db.ApiCaches
import com.sample.demo.data.db.CacheDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class ApiInterceptor(private val cacheDatabase: CacheDatabase) : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val response = chain.run {
      proceed(this.request())
    }
    // intercepts the api response and does caching process
    return cacheResponse(response)
  }

  private fun saveResponse(response: Response): Response {
    CoroutineScope(Dispatchers.IO).launch {
      try {
        val body = response.peekBody(Long.MAX_VALUE).string()
        cacheDatabase.cachesDao().insertCacheResponse(
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
    // caches the successful response to local database from the api
    // Returns the cached response on api failure
    return try {
      if (response.isSuccessful && response.peekBody(Long.MAX_VALUE).string().isNotEmpty()) {
        Log.d("saran","success response $response")
        saveResponse(response)
      } else {
        Log.d("saran","response from cache")
        fetchResponseFromDb(response)
      }
    } catch (e: Exception) {
      fetchResponseFromDb(response)
    }
  }

  private fun fetchResponseFromDb(response: Response): Response {
    var result: Response? = null
    val cache = cacheDatabase.cachesDao().getCacheResponse(response.request.url.toString())
    if (null != cache) {
      result =
        Response.Builder().request(Request.Builder().url(cache.url).build()).code(cache.code)
          .body(cache.response.toResponseBody()).protocol(Protocol.get(cache.protocol))
          .message(cache.message).build()
    }
    return result ?: response
  }
}
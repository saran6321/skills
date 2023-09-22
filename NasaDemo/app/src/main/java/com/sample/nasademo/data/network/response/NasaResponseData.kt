package com.sample.nasademo.data.network.response

data class NasaResponseData(
  val isSuccess: Boolean = true,
  val date: String? = null,
  val explanation: String? = null,
  val hdUrl: String? = null,
  val url: String? = null,
  val mediaType: String? = null,
  val serviceVersion: String? = null,
  val title: String? = null
)
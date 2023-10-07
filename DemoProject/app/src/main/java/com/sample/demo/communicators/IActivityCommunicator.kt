package com.sample.demo.communicators

import com.sample.demo.data.network.response.Item

interface IActivityCommunicator {
  fun addToCart(item: Item)
  fun removeCartItem(item: Item)
}
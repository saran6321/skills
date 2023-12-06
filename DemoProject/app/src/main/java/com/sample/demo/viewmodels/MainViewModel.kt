package com.sample.demo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.demo.data.db.CacheDatabase
import com.sample.demo.data.db.CartDao
import com.sample.demo.data.network.response.Item
import com.sample.demo.data.network.response.ProductResponseData
import com.sample.demo.repository.MainRepository
import com.sample.demo.utility.orDefaultDouble
import com.sample.demo.utility.orDefaultInt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo : MainRepository): ViewModel() {
  @Inject lateinit var mCacheDatabase: CacheDatabase
  @Inject lateinit var cartDao: CartDao
  private val _productsData = MutableLiveData<ProductResponseData?>()
  val productsData: LiveData<ProductResponseData?> get() = _productsData

  private val _listData = MutableStateFlow(listOf<String>())
  val listData: StateFlow<List<String>> get() = _listData.asStateFlow()

  private val _uiState = MutableStateFlow(false)
  val uiState: StateFlow<Boolean>
    get() = _uiState.asStateFlow()

  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    throwable.printStackTrace()
  }

  fun getProducts() = viewModelScope.launch(Dispatchers.IO + SupervisorJob() + exceptionHandler) {
    try {
      val res = repo.getProducts()
      // Returns the response from api if its success
      // On api failure, returns cache if available else returns the failed response
      if (res?.isSuccessful == true) {
        _productsData.postValue(res.body())
      } else {
        _productsData.postValue(ProductResponseData(status = false))
      }
    } catch (e: Exception) {
      e.printStackTrace()
      _productsData.postValue(ProductResponseData(status = false))
    }
  }

  fun getDataList() = viewModelScope.launch(Dispatchers.IO + SupervisorJob() + exceptionHandler) {
    try {
      val res = repo.getDataList()
      // Returns the response from api if its success
      // On api failure, returns cache if available else returns the failed response
      if (res?.isSuccessful == true) {
        _listData.value = res.body().orEmpty()
      } else {
        _listData.value = listOf()
      }
    } catch (e: Exception) {
      e.printStackTrace()
      _listData.value = listOf()
    }
  }

  fun addToCart(item: Item) {
    viewModelScope.launch(Dispatchers.IO + SupervisorJob()){
      item.id?.let {
        var cart = cartDao.getCart(it)
        cart?.let { cartItem ->
          cartItem.count = cartItem.count?.plus(1).orDefaultInt(0)
        } ?: kotlin.run {
          item.count = 1
          cart = item
        }
        cart?.total = cart?.price.orDefaultDouble(0.0) * cart?.count.orDefaultInt(0)
        cart?.let { it1 -> cartDao.insertCart(it1) }
      }
    }
  }

  fun removeCartItem(item: Item) {
    viewModelScope.launch(Dispatchers.IO + SupervisorJob()){
      item.id?.let {
        val cart = cartDao.getCart(it)
        cart?.let { cartItem ->
          if (cartItem.count.orDefaultInt(0) > 0) {
            cartItem.count = cartItem.count?.minus(1).orDefaultInt(0)
            cartItem.total = cartItem.price.orDefaultDouble(0.0) * cartItem.count.orDefaultInt(0)
            cartItem.let { it1 -> cartDao.insertCart(it1) }
          } else {
            cartDao.deleteCart(cartItem)
          }
        }
      }
    }
  }

  fun getCartsData() = cartDao.getAllCarts()

  fun getCartsCount() = cartDao.getCartsCount()

  fun getCartsTotal() = cartDao.getCartsTotal()

  fun addOrRemoveFavourite(item: Item) {
    viewModelScope.launch(Dispatchers.IO + SupervisorJob()){
      item.id?.let {
        var cart = cartDao.getCart(it)
        cart?.let { cartItem ->
          cartItem.isFavourite = !cartItem.isFavourite
        } ?: kotlin.run {
          item.isFavourite = true
          cart = item
        }
        cart?.let { it1 -> cartDao.insertCart(it1) }
      }
    }
  }
  fun getFavourites() = cartDao.getFavouriteItems()
  fun getFavouritesCount() = cartDao.getFavouriteItemsCount()

  fun getCurrentTheme(): StateFlow<Boolean> = uiState

  fun updateTheme() {
    _uiState.value = !_uiState.value
  }
}
package com.sample.nasademo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.nasademo.data.network.response.NasaResponseData
import com.sample.nasademo.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo : MainRepository): ViewModel() {
  private var todayImage : Response<NasaResponseData?>? = null
  private val _nasaData = MutableLiveData<NasaResponseData>()
  val nasaData: LiveData<NasaResponseData> get() = _nasaData
  companion object{
    const val apiKey = "yhCGdc68BCIoWJ8xbgsTiVB0tb7jSABZm3UdSz2w"
    // differentiate and secure api keys during debug and release of the apk with .properties with buildfeatures
  }
  init {
    getTodayImage()
  }

  private fun getTodayImage() = viewModelScope.launch(Dispatchers.IO + SupervisorJob()) {
    todayImage = repo.getTodayImage(apiKey)
    if (todayImage?.isSuccessful == true) {
      _nasaData.postValue(todayImage?.body())
    } else {
      Log.i("Response_is", todayImage?.errorBody().toString())
    }
  }
}
package com.sample.nasademo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.nasademo.data.db.NasaDatabase
import com.sample.nasademo.data.db.TaskDao
import com.sample.nasademo.data.db.TaskData
import com.sample.nasademo.data.network.response.NasaResponseData
import com.sample.nasademo.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo : MainRepository): ViewModel() {
  @Inject lateinit var nasaDatabase: NasaDatabase
  @Inject lateinit var taskDao: TaskDao
  private val _nasaData = MutableLiveData<NasaResponseData>()
  val nasaData: LiveData<NasaResponseData> get() = _nasaData
  companion object{
    const val apiKey = "yhCGdc68BCIoWJ8xbgsTiVB0tb7jSABZm3UdSz2w"
    // differentiate and secure api keys during debug and release of the apk with .properties with build features
  }

  private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    throwable.printStackTrace()
  }

  fun getTodayImage() = viewModelScope.launch(Dispatchers.IO + SupervisorJob() + exceptionHandler) {
    try {
      val res = repo.getTodayImage(apiKey)
      // Returns the response from api if its success
      // On api failure, returns cache if available else returns the failed response
      if (res?.isSuccessful == true) {
        _nasaData.postValue(res.body())
      } else {
        _nasaData.postValue(NasaResponseData(isSuccess = false))
      }
    } catch (e: Exception) {
      e.printStackTrace()
      _nasaData.postValue(NasaResponseData(isSuccess = false))
    }
  }

  fun insertTask(task: String) {
    viewModelScope.launch(Dispatchers.IO + SupervisorJob()){
      taskDao.insertTask(TaskData(task = task))
    }
  }
}
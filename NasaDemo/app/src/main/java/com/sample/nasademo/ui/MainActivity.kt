package com.sample.nasademo.ui

import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.sample.nasademo.R
import com.sample.nasademo.data.db.NasaDatabase
import com.sample.nasademo.data.db.TaskData
import com.sample.nasademo.databinding.ActivityMainLayoutBinding
import com.sample.nasademo.utility.hideView
import com.sample.nasademo.utility.isInternetAvailable
import com.sample.nasademo.utility.setTextOrHideView
import com.sample.nasademo.utility.showView
import com.sample.nasademo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainLayoutBinding

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    lifecycleScope.launch {
      repeat(10){
        viewModel.insertTask("Task $it")
      }
    }

    viewModel.nasaData.observe(this) { nasaData ->
      with(binding) {
        if (nasaData.isSuccess) {                 // loads the success data
          Glide.with(ivNasaImage.context).load(nasaData?.url).into(ivNasaImage)
          ivNasaImage.showView()
          tvTitle.setTextOrHideView(nasaData?.title)
          tvDesc.setTextOrHideView(nasaData?.explanation)
          tvDate.setTextOrHideView(nasaData?.date)
          viewDivider.showView()
        } else {                                  // Allows user to retry loading on api failure
          tvTitle.setTextOrHideView(tvTitle.context.getString(R.string.loading_failed))
          tvTitle.setOnClickListener {
            viewModel.getTodayImage()
            tvTitle.setTextOrHideView(tvTitle.context.getString(R.string.text_loading))
            tvTitle.setOnClickListener(null)
          }
        }
      }
    }
    if (isInternetAvailable(this)) {      // checks for the internet availability
      viewModel.getTodayImage()
    } else {
      Toast.makeText(this, "Please check your network connection !", Toast.LENGTH_LONG).show()
      binding.tvTitle.setTextOrHideView(binding.tvTitle.context.getString(R.string.check_network))
      binding.tvVideoTitle.hideView()
      binding.vvVideo.hideView()
    }

    with(binding.vvVideo) {         // video player with controls
      val mediaController = MediaController(context)
      mediaController.setAnchorView(this)
      setMediaController(mediaController)
      setVideoURI(android.net.Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"))
      start()
    }
  }
}

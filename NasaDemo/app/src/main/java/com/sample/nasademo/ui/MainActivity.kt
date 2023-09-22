package com.sample.nasademo.ui

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.sample.nasademo.R
import com.sample.nasademo.databinding.ActivityMainLayoutBinding
import com.sample.nasademo.utility.setTextOrHideView
import com.sample.nasademo.utility.showView
import com.sample.nasademo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainLayoutBinding

  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainLayoutBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    viewModel.nasaData.observe(this) { nasaData ->
      with(binding) {
        if (nasaData.isSuccess) {
          Glide.with(ivNasaImage.context).load(nasaData?.url).into(ivNasaImage)
          ivNasaImage.showView()
          tvTitle.setTextOrHideView(nasaData?.title)
          tvDesc.setTextOrHideView(nasaData?.explanation)
          tvDate.setTextOrHideView(nasaData?.date)
        } else {
          tvTitle.setTextOrHideView(tvTitle.context.getString(R.string.loading_failed))
          tvTitle.setOnClickListener {
            viewModel.getTodayImage()
            tvTitle.setTextOrHideView(tvTitle.context.getString(R.string.text_loading))
            tvTitle.setOnClickListener(null)
          }
        }
      }
    }
    viewModel.getTodayImage()

    with(binding.vvVideo) {
      val mediaController = MediaController(context)
      mediaController.setAnchorView(this)
      setMediaController(mediaController)
      setVideoURI(android.net.Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"))
      start()
    }
  }
}

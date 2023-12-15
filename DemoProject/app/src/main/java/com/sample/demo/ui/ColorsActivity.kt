package com.sample.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.tabs.TabLayoutMediator
import com.sample.demo.adapter.ViewPagerAdapter
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.ActivityColorsBinding
import com.sample.demo.utility.toggleThemeMode

class ColorsActivity : AppCompatActivity(), IActivityCommunicator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityColorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityColorsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivDayNight.setOnClickListener {
            toggleThemeMode()
        }
        binding.vpColors.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tbLayoutType, binding.vpColors) { tab, position ->
            when (position) {
                0 -> tab.text = "Xml"
                else -> tab.text = "Compose"
            }
        }.attach()
    }

    override fun addToCart(item: Item) {
        toggleThemeMode()
    }

    override fun removeCartItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun addOrRemoveFavourite(item: Item) {
        TODO("Not yet implemented")
    }
}
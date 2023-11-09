package com.sample.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.snackbar.Snackbar
import com.sample.demo.R
import com.sample.demo.communicators.ICommunicator
import com.sample.demo.databinding.ActivityTemplateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TemplateActivity : AppCompatActivity(), ICommunicator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityTemplateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        //fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragment, TemplateFragment.newInstance("test"))
            .commit()
    }
}
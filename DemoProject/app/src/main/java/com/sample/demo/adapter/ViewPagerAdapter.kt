package com.sample.demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sample.demo.ui.ColorFragment
import com.sample.demo.ui.ComposeColorFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ColorFragment.newInstance()
            else -> ComposeColorFragment.newInstance()
        }
    }
}
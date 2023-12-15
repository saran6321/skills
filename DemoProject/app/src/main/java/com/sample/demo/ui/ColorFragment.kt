package com.sample.demo.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sample.demo.adapter.ColorsAdapter
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.FragmentColorBinding
import com.sample.demo.utility.getColorList

class ColorFragment : Fragment(),IActivityCommunicator {
    private var fragmentColorBinding: FragmentColorBinding? = null
    private val binding get() = fragmentColorBinding!!
    private var iActivityCommunicator: IActivityCommunicator? = null

    companion object {
        fun newInstance() = ColorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentColorBinding = FragmentColorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.rvColors) {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            clipToPadding = false
            adapter = ColorsAdapter(getColorList(), this@ColorFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        iActivityCommunicator = context as? IActivityCommunicator
    }

    override fun addToCart(item: Item) {
        iActivityCommunicator?.addToCart(Item())
    }

    override fun removeCartItem(item: Item) {
        TODO("Not yet implemented")
    }

    override fun addOrRemoveFavourite(item: Item) {
        TODO("Not yet implemented")
    }
}
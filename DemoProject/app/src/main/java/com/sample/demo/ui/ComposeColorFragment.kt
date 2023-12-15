package com.sample.demo.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.sample.demo.communicators.IActivityCommunicator
import com.sample.demo.compose.ui.GridLayoutSection
import com.sample.demo.data.network.response.Item
import com.sample.demo.databinding.FragmentColorBinding
import com.sample.demo.utility.getColorList

class ComposeColorFragment : Fragment(),IActivityCommunicator {
    private var fragmentColorBinding: FragmentColorBinding? = null
    private val binding get() = fragmentColorBinding!!
    private var iActivityCommunicator: IActivityCommunicator? = null

    companion object {
        fun newInstance() = ComposeColorFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GridLayoutSection(
                    modifier = Modifier
                        .fillMaxWidth(),
                    items = getColorList()
                )
            }
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
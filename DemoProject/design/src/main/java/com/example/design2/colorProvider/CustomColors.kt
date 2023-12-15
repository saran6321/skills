package com.example.design2.colorProvider

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.example.design2.R
import com.google.android.material.color.MaterialColors

class CustomColors {

    companion object {
        private var customColors: ColorData? = null
        fun getColor(context: Context): ColorData? {
            return if (customColors != null) {
                customColors
            } else {
                ColorData(
                    Space = getCustomColor(context, R.attr.Light_Grey)
                )
            }
        }

        fun reCreate(){
            customColors = null
        }

        fun getCustomColor(current: Context, colorInt: Int) =
            Color(MaterialColors.getColor(current, colorInt, R.color.white))
    }

    data class ColorData(
        var Space: Color? = null
    )
}
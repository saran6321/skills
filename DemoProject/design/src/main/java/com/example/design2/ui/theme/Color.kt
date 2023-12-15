package com.example.design2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.example.design2.R

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF4813DF)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

data class DesignCustomTheme(
    val Ocean: Int = R.attr.Ocean,
    val Theme_Grey: Int = R.attr.Theme_Grey,
    val Kesar: Int = R.attr.Kesar,
)

val MaterialTheme.customColorsPalette: DesignCustomTheme
    @Composable
    @ReadOnlyComposable
    get() = Design.current

val Design = staticCompositionLocalOf { DesignCustomTheme() }
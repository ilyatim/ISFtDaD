package com.example.isftdad.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val blue_accent_66A4ED = Color(0xFF66A4ED)
val gray_808080_30 = Color(0x4D808080)
val gray_808080 = Color(0xFF808080)
val gray_c9c9c9 = Color(0xFFC9C9C9)
val gray_b3b3b3 = Color(0xFFB3B3B3)


@get:Composable
val Colors.fabBackground: Color
    get() = if (isLight) blue_accent_66A4ED else dark_surface

@get:Composable
val Colors.fabOnBackground: Color
    get() = if (isLight) Color.White else dark_onSurface
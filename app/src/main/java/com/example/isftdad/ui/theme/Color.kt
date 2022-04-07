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
val dark_bottom_sheet_background = Color(0xFF244166)


@get:Composable
val Colors.fabBackground: Color
    get() = if (isLight) blue_accent_66A4ED else dark_surface

@get:Composable
val Colors.fabOnBackground: Color
    get() = if (isLight) Color.White else dark_onSurface

@get:Composable
val Colors.dividerOnBackground: Color
    get() = if (isLight) gray_808080_30 else gray_808080

@get:Composable
val Colors.scrimColor: Color
    get() = if (isLight) gray_808080_30.copy(alpha = 0.30f) else Color.Black.copy(alpha = 0.30f)

@get:Composable
val Colors.bottomSheetBackground: Color
    get() = if (isLight) Color.White else dark_bottom_sheet_background

@get:Composable
val Colors.bottomSheetBottomAppBarBackground: Color
    get() = if (isLight) Color.White else dark_surface


package com.example.isftdad.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = dark_primary,
    onPrimary = Color.White,
    secondary = blue_accent_66A4ED,
    onSecondary = Color.White,
    background = dark_background,
    onBackground = dark_onBackground,
    surface = dark_surface,
    onSurface = dark_onSurface,
    error = dark_error,
    onError = dark_onError
)

private val LightColorPalette = lightColors(
    primary = light_primary,
    onPrimary = gray_808080,
    secondary = blue_accent_66A4ED,
    onSecondary = Color.White,
    background = light_background,
    onBackground = light_onBackground,
    surface = light_surface,
    onSurface = light_onSurface,
    error = light_error,
    onError = light_onError
)

@Composable
fun MainTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()

    if (darkTheme) {
        systemUiController.setSystemBarsColor(color = dark_background)
    } else {
        systemUiController.setSystemBarsColor(color = light_background)
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
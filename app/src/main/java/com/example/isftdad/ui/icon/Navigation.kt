package com.example.isftdad.ui.icon

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun CancelIcon(
    onClick: () -> Unit,
    tint: Color = MaterialTheme.colors.onBackground
) {
    IconButton(onClick = { onClick.invoke() }) {
        Icon(Icons.Filled.Clear, "CancelIcon", tint = tint)
    }
}

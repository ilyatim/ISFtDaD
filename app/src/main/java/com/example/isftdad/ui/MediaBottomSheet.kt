package com.example.isftdad.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.isftdad.R
import com.example.isftdad.data.model.attachment.Attachment
import com.example.isftdad.ui.basic.ModalBottomSheet
import com.example.isftdad.ui.basic.ModalBottomSheetWithBottomBar
import com.example.isftdad.ui.theme.bottomSheetBackground
import com.example.isftdad.ui.theme.scrimColor
import com.example.isftdad.utils.MediaBottomViewModel


@Composable
private fun MediaBottomSheetContent(viewModel: MediaBottomViewModel) {
    MediaImagesList(
        listOf(),
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MediaImagesList(
    list: List<Attachment.Image>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier,
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(9.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        items(18) {
            val elevation = 4.dp
            val shape = RectangleShape
            Image(
                painter = rememberVectorPainter(image = Icons.Filled.Call),
                contentDescription = stringResource(id = R.string.attachment),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .shadow(elevation = elevation, shape = shape, clip = false)
                    .clip(shape)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = shape
                    )
                    .zIndex(elevation.value)
                    .clickable { }
                ,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                contentScale = ContentScale.Inside
            )
        }
    }
}

@Composable
fun ShowMediaBottomSheet(
    onSheetClosed: () -> Unit,
) {

    val bottomAppBar: @Composable () -> Unit = {
        Image(
            painter = rememberVectorPainter(image = Icons.Filled.Call),
            contentDescription = stringResource(id = R.string.attachment),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .shadow(elevation = 4.dp, shape = RectangleShape, clip = false)
                .clip(RectangleShape)
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RectangleShape
                )
                .zIndex(4.dp.value)
                .clickable { }
            ,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            contentScale = ContentScale.Inside
        )
    }

    ModalBottomSheetWithBottomBar(
        onSheetClosed = onSheetClosed,
        sheetShape = RectangleShape,
        sheetBackgroundColor = MaterialTheme.colors.bottomSheetBackground,
        scrimColor = MaterialTheme.colors.scrimColor,
        bottomAppBar = bottomAppBar
    ) {
        MediaBottomSheetContent(hiltViewModel())
    }
}


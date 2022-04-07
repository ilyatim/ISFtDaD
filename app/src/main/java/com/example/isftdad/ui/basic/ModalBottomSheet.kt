package com.example.isftdad.ui.basic

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.isftdad.ui.theme.bottomSheetBackground
import com.example.isftdad.ui.theme.bottomSheetBottomAppBarBackground
import com.unfixedBo1t.ui.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheet(
    onSheetClosed: () -> Unit,
    isHalfExpanded: Boolean = true,
    sheetShape: Shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    sheetElevation: Dp = ModalBottomSheetDefaults.Elevation,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    scrimColor: Color = ModalBottomSheetDefaults.scrimColor,
    backgroundContent: @Composable (() -> Unit)? = null,
    sheetContent: @Composable (() -> Unit),
) {
    val bottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
    ) {
        if (it == ModalBottomSheetValue.Hidden) {
            onSheetClosed.invoke()
        }
        true
    }

    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        /*if (isHalfExpanded) {
            bottomSheetState.animateTo(ModalBottomSheetValue.HalfExpanded)
        } else {*/
            bottomSheetState.show()
        //}
    }

    ModalBottomSheetLayout(
        sheetContent = {
            sheetContent()
        },
        sheetState = bottomSheetState,
        sheetShape = sheetShape,
        scrimColor = scrimColor,
        sheetBackgroundColor = sheetBackgroundColor,
        sheetElevation = sheetElevation,
        content = backgroundContent ?: {}
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModalBottomSheetWithBottomBar(
    onSheetClosed: () -> Unit,
    isHalfExpanded: Boolean = true,
    sheetShape: Shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    sheetElevation: Dp = ModalBottomSheetDefaults.Elevation,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    scrimColor: Color = ModalBottomSheetDefaults.scrimColor,
    backgroundContent: @Composable (() -> Unit)? = null,
    bottomAppBarBackgroundColor: Color = MaterialTheme.colors.bottomSheetBottomAppBarBackground,
    bottomAppBar: @Composable () -> Unit,
    sheetContent: @Composable (() -> Unit),
) {
    val bottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
    ) {
        if (it == ModalBottomSheetValue.Hidden) {
            onSheetClosed.invoke()
        }
        true
    }

    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch {
        /*if (isHalfExpanded) {
            bottomSheetState.animateTo(ModalBottomSheetValue.HalfExpanded)
        } else {*/
        bottomSheetState.show()
        //}
    }

    ModalBottomSheetLayoutWithBottomAppBar(
        sheetContent = {
            sheetContent()
        },
        sheetState = bottomSheetState,
        sheetShape = sheetShape,
        scrimColor = scrimColor,
        sheetBackgroundColor = sheetBackgroundColor,
        sheetElevation = sheetElevation,
        bottomAppBarBackgroundColor = bottomAppBarBackgroundColor,
        bottomAppBar = bottomAppBar,
        content = backgroundContent ?: {},
    )
}
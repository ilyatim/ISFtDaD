package com.example.isftdad.ui.basic

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MediaBottomSheetDialog(
    onSheetClosed: () -> Unit,
    isHalfExpanded: Boolean = true,
    sheetShape: Shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    sheetElevation: Dp = ModalBottomSheetDefaults.Elevation,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    scrimColor: Color = ModalBottomSheetDefaults.scrimColor,
    backgroundContent: @Composable (() -> Unit)? = null,
    sheetContent: @Composable (() -> Unit),
) {
    val bottomSheetState = rememberBottomSheetScaffoldState()

    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        bottomSheetState.bottomSheetState.expand()
    }

    BottomSheetScaffold(
        sheetContent = {
            sheetContent()
        },
        scaffoldState = bottomSheetState,
        sheetShape = sheetShape,
        drawerScrimColor = scrimColor,
        sheetBackgroundColor = sheetBackgroundColor,
        sheetElevation = sheetElevation
    ) {}
}

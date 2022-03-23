package com.example.isftdad.ui.screen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.isftdad.utils.SendEmailViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@Composable
fun SendEmail(
    viewModel: SendEmailViewModel
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            SendEmailFloatingActionButton(viewModel, scaffoldState)
        }
    ) {

    }
}

@Composable
fun SendEmailFloatingActionButton(viewModel: SendEmailViewModel, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(onClick = { viewModel.addAttachment() }) {

    }
}

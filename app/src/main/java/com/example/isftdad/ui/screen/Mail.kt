package com.example.isftdad.ui.screen

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.example.isftdad.data.model.sendEmail.UiEvent
import com.example.isftdad.ui.SubscribeOnEvents
import com.example.isftdad.ui.icon.CancelIcon
import com.example.isftdad.ui.theme.*
import com.example.isftdad.utils.SendEmailViewModel
import com.example.isftdad.utils.extensions.makeShortToast

@Composable
fun SendEmail(
    viewModel: SendEmailViewModel
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val context = LocalContext.current

    SubscribeOnEvents(viewModel = viewModel) { event ->
        when (event) {
            is UiEvent.Toast -> context.makeShortToast(event.string)
        }
    }

    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            SendEmailFloatingActionButton(viewModel, scaffoldState)
        },
        topBar = {
            SendEmailTopBar(viewModel = viewModel)
        }
    ) {

    }
}

@Composable
fun SendEmailFloatingActionButton(
    viewModel: SendEmailViewModel,
    scaffoldState: ScaffoldState
) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(
        onClick = { viewModel.addAttachment() },
        backgroundColor = MaterialTheme.colors.fabBackground,
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "add attachment",
            tint = MaterialTheme.colors.fabOnBackground
        )
    }
}

@Composable
fun SendEmailTopBar(
    viewModel: SendEmailViewModel,
) {
    TopAppBar(
        title = {},
        navigationIcon = {
            CancelIcon({
                viewModel.onCancelClicked()
            })
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        actions = {
            SendButton {
                viewModel.send()
            }
        },
        elevation = 0.dp
    )
}

@Composable
fun SendButton(onClick: () -> Unit) {
    IconButton(onClick = { onClick.invoke() }) {
        Icon(
            Icons.Filled.Send,
            "Send Button",
            tint = MaterialTheme.colors.onBackground
        )
    }
}

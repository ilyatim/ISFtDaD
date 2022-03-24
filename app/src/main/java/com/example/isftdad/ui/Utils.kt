package com.example.isftdad.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.isftdad.utils.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch


@Composable
fun <T> SubscribeOnEvents(viewModel: BaseViewModel<*, *, T>, collect: (T) -> Unit) {
    val uiEvents = remember { viewModel.subscribeOnEvents() }.consumeAsFlow()
    CoroutineScope(Dispatchers.Main).launch {
        uiEvents.collect(collect)
    }
}

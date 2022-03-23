package com.example.isftdad.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow

abstract class BaseViewModel<Action, UiState, UiEvent> (

) : ViewModel(),
    CoroutineScope by MainScope() + Job(),
    ActionBehaviour<Action>,
    UiBehaviour<UiState>,
    UiEvents<UiEvent>
{
    protected abstract val uiState: MutableStateFlow<UiState>
    private val actionChannel: Channel<Action> = Channel(Channel.UNLIMITED)
    private val uiChannel: Channel<UiEvent> = Channel(Channel.UNLIMITED)

    init {
        launch {
            launchChannel()
        }
    }

    protected fun sendUiEvent(event: UiEvent) {
        launch {
            uiChannel.send(event)
        }
    }

    override fun subscribeOnEvents(): Channel<UiEvent> = uiChannel

    protected fun setNewUiState(state: UiState) {
        uiState.value = state
    }

    private suspend fun launchChannel() {
        actionChannel.consumeAsFlow().collect(this::sendAction)
    }

    override fun sendAction(action: Action) {
        launch {
            actionChannel.send(action)
        }
    }
}

interface ActionBehaviour<Action> {
    fun collectAction(action: Action)
    fun sendAction(action: Action)
}

interface UiEvents<UiEvent> {
    fun subscribeOnEvents(): Channel<UiEvent>
}

interface UiBehaviour<UiState> {
    fun getUiState(): StateFlow<UiState>
}

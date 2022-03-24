package com.example.isftdad.utils

import com.example.isftdad.data.model.sendEmail.Action
import com.example.isftdad.data.model.sendEmail.UiEvent
import com.example.isftdad.data.model.sendEmail.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SendEmailViewModel @Inject constructor(

) : BaseViewModel<Action, UiState, UiEvent>() {
    override val uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Idle)

    override fun collectAction(action: Action) {
        when (action) {
            Action.AddAttachment -> {
                sendUiEvent(UiEvent.Toast("add"))
            }
            Action.Cancel -> {
                sendUiEvent(UiEvent.Toast("cancel"))
            }
            Action.Send -> {
                sendUiEvent(UiEvent.Toast("send"))
            }
        }
    }

    fun send() {
        sendAction(Action.Send)
    }

    fun addAttachment() {
        sendAction(Action.AddAttachment)
    }

    fun onCancelClicked() {
        sendAction(Action.Cancel)
    }

    override fun getUiState(): StateFlow<UiState> = uiState.asStateFlow()
}
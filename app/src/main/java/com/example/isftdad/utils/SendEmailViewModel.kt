package com.example.isftdad.utils

import com.example.isftdad.data.model.sendEmail.Action
import com.example.isftdad.data.model.sendEmail.Attachment
import com.example.isftdad.data.model.sendEmail.UiEvent
import com.example.isftdad.data.model.sendEmail.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun getAttachmentList(): List<Attachment> {
        return List(5) { Attachment("") }//(getUiState().value as? UiState.Content)?.attachments ?: listOf()
    }

    fun removeAttachment(index: Int) {
        sendAction(Action.RemoveAttachment(index))
    }

    fun onAttachmentClicked(index: Int) {
        sendAction(Action.OnAttachmentClick(index))
    }

    override fun getUiState(): StateFlow<UiState> = uiState.asStateFlow()
}
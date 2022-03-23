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

        }
    }

    fun addAttachment() {
        //sendUiEvent()
        //uiState.value =
    }

    override fun getUiState(): StateFlow<UiState> = uiState.asStateFlow()
}
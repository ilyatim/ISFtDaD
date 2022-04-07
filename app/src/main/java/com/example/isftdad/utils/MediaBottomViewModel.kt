package com.example.isftdad.utils

import com.example.isftdad.data.model.attachment.Action
import com.example.isftdad.data.model.attachment.UiEvent
import com.example.isftdad.data.model.attachment.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MediaBottomViewModel @Inject constructor(

) : BaseViewModel<Action, UiState, UiEvent>() {

    override val uiState: MutableStateFlow<UiState>
        get() = MutableStateFlow(UiState.Loading)

    override fun collectAction(action: Action) {
        when (action) {

        }
    }

    override fun getUiState(): StateFlow<UiState> = uiState.asStateFlow()

}

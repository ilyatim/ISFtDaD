package com.example.isftdad.data.model.attachment

sealed class UiState {
    object Loading : UiState()
}

sealed class Action {

}

sealed class UiEvent {
    data class Toast(val message: String) : UiEvent()
}
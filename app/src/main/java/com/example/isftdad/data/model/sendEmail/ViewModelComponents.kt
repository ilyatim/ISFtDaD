package com.example.isftdad.data.model.sendEmail

sealed class UiState {
    object Idle : UiState()

    data class Content(
        val isAttach: Boolean
    )
}

sealed class Action {

}

sealed class UiEvent {

}
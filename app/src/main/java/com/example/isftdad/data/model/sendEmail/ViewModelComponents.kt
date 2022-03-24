package com.example.isftdad.data.model.sendEmail

sealed class UiState {
    object Idle : UiState()

    data class Content(
        val isAttach: Boolean
    )

    object Finish : UiState()
}

sealed class Action {
    object Cancel : Action()
    object AddAttachment : Action()
    object Send : Action()
}

sealed class UiEvent {
    data class Toast(val string: String) : UiEvent()
}
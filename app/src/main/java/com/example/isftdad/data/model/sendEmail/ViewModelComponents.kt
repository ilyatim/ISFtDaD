package com.example.isftdad.data.model.sendEmail

import com.example.isftdad.data.model.attachment.Attachment

sealed class UiState {
    object Idle : UiState()

    data class Content(
        val attachments: List<Attachment>,
    ) : UiState()

    object Finish : UiState()
}

sealed class Action {
    data class RemoveAttachment(val index: Int) : Action()
    data class OnAttachmentClick(val index: Int) : Action()

    object Cancel : Action()
    object AddAttachment : Action()
    object Send : Action()
}

sealed class UiEvent {
    data class Toast(val string: String) : UiEvent()

    object BottomSheet : UiEvent()
}
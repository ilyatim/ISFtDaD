package com.example.isftdad.data.model.attachment

/*data class Attachment(
    open val fileName: String
)*/

sealed class Attachment(open val fileName: String) {
    data class Image(override val fileName: String) : Attachment(fileName)
}
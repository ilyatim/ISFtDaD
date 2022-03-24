package com.example.isftdad.utils.extensions

import android.content.Context
import android.widget.Toast

fun Context.makeShortToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.makeLongToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}
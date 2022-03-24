package com.example.isftdad.ui.screen.mail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.isftdad.R
import com.example.isftdad.ui.theme.gray_808080
import com.example.isftdad.utils.SendEmailViewModel


@Composable
fun MailTextInput(
    viewModel: SendEmailViewModel
) {

}

@Composable
fun AttachmentList(
    viewModel: SendEmailViewModel
) {

}

@Composable
fun SubjectTextInput(
    viewModel: SendEmailViewModel
) {
    var inputText by rememberSaveable {
        mutableStateOf("")
    }
    BaseTextInput(
        titleText = stringResource(id = R.string.subject_text_input_title),
        inputText = inputText
    ) {
        inputText = it
    }
}

@Composable
fun RecipientTextInput(
    viewModel: SendEmailViewModel
) {
    var inputText by rememberSaveable {
        mutableStateOf("")
    }
    BaseTextInput(
        stringResource(id = R.string.recipient_text_input_title),
        inputText
    ) {
        inputText = it
    }
}

@Composable
private fun BaseTextInput(
    titleText: String,
    inputText: String,
    onTextChange: (String) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = titleText,
                modifier = Modifier.wrapContentHeight()
            )
            BasicTextField(
                value = inputText,
                onValueChange = {
                    onTextChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.background)
                    .padding(16.dp),
                textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colors.onBackground),
                singleLine = true,
                maxLines = 1,
                cursorBrush = SolidColor(MaterialTheme.colors.onBackground),
            )
        }
        Divider(color = gray_808080)
    }
}
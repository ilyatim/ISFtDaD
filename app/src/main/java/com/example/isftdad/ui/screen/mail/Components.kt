package com.example.isftdad.ui.screen.mail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.isftdad.R
import com.example.isftdad.data.model.attachment.Attachment
import com.example.isftdad.ui.theme.dividerOnBackground
import com.example.isftdad.utils.SendEmailViewModel


@Composable
fun MailTextInput(
    viewModel: SendEmailViewModel
) {
    val inputText = remember {
        mutableStateOf("")
    }

    HintTextField(
        value = inputText.value,
        onValueChange = {
            inputText.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colors.onBackground),
    ) {
        Text(text = stringResource(id = R.string.email_hint))
    }
}

@Composable
fun HintTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    cursorBrush: Brush = SolidColor(MaterialTheme.colors.onBackground),
    placeholder: @Composable (() -> Unit)? = null
) {
    Box(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            textStyle = textStyle,
            cursorBrush = cursorBrush,
        )
        if (value.isEmpty()) {
            placeholder?.invoke()
        }
    }
}

@Composable
fun AttachmentList(
    viewModel: SendEmailViewModel
) {
    val list = remember {
        viewModel.getAttachmentList()
    }

    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, top = 30.dp, bottom = 16.dp)
    ) {
        itemsIndexed(list) { index, item ->
            val onAttachmentClicked = {
                viewModel.onAttachmentClicked(index)
            }
            val onClearClicked = {
                viewModel.removeAttachment(index)
            }
            EmailAttachment(item, onAttachmentClicked, onClearClicked)
        }
    }
}

@Composable
fun EmailAttachment(
    item: Attachment,
    onAttachmentClicked: () -> Unit,
    onClearClicked: () -> Unit
) {
    ConstraintLayout{
        val (clearButton, image) = createRefs()
        val elevation: Dp = 4.dp
        AttachmentSurface(
            modifier = Modifier.constrainAs(image) {
                top.linkTo(parent.top, margin = 5.dp)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            onAttachmentClicked = onAttachmentClicked,
            elevation = elevation
        )

        IconButton(
            onClick = onClearClicked,
            modifier = Modifier
                .constrainAs(clearButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end, margin = 10.dp)
                }
                .background(
                    MaterialTheme.colors.error,
                    RoundedCornerShape(20.dp)
                )
                .size(30.dp)
                .zIndex(elevation.value)
        ) {
            Icon(
                imageVector = Icons.Filled.Clear,
                contentDescription = stringResource(id = R.string.cancel_button),
                tint = MaterialTheme.colors.onError
            )
        }
    }
}

@Composable
fun AttachmentSurface(
    modifier: Modifier = Modifier,
    onAttachmentClicked: () -> Unit,
    elevation: Dp = 4.dp,
    shape: Shape = RoundedCornerShape(4.dp)
) {
    Image(
        painter = rememberVectorPainter(image = Icons.Filled.Call),
        contentDescription = stringResource(id = R.string.attachment),
        modifier = modifier
            .defaultMinSize(150.dp, 90.dp)
            .padding(end = 20.dp)
            .shadow(elevation = elevation, shape = shape, clip = false)
            .clip(shape)
            .background(
                color = MaterialTheme.colors.surface,
                shape = shape
            )
            .zIndex(elevation.value)
            //.background(color = MaterialTheme.colors.surface, shape)
            .clickable { onAttachmentClicked.invoke() }

        ,
        colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
        contentScale = ContentScale.Inside
    )
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
        Divider(color = MaterialTheme.colors.dividerOnBackground)
    }
}
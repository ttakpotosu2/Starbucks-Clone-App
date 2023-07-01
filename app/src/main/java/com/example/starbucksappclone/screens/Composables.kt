package com.example.starbucksappclone.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.toSize

@Composable
fun LoginTextFieldWithIcon(
    label: String,
    placeholder: String,
//    trailingIcon: ImageVector? = null,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Composable
fun LoginTextFieldWithDropDown(
    label: String,
    placeholder: String
) {
    var isExpanded by remember { mutableStateOf(false) }
    val salutations = listOf(
        "Mr",
        "Mrs",
        "Dr",
        "Ing"
    )
    var isSelectedText by remember { mutableStateOf("") }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (isExpanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown

    // var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = isSelectedText,
        onValueChange = {isSelectedText = it},
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                mTextFieldSize = it.size.toSize()
            },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        ),
        trailingIcon = {
            IconButton(onClick = {}) {
                Icon(
                    icon,
                    contentDescription = null,
                    Modifier.clickable { isExpanded = !isExpanded }
                )
            }
        }
    )
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { isExpanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current) { mTextFieldSize.width.toDp()})
    ) {
        salutations.forEach {label ->
            DropdownMenuItem(
                onClick = {
                    isSelectedText = label
                    isExpanded = false
                }
            ) {
                Text(text = label)
            }
        }
    }
}

@Composable
fun FloatingButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        text = { Text(text = text)},
        onClick = { onClick()},
        contentColor = Color.White,
        backgroundColor = Color(0xFF4CA569),
        modifier = modifier
    )
}
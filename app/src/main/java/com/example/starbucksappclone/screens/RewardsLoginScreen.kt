package com.example.starbucksappclone.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.starbucksappclone.navigation.Screens

@Composable
fun RewardsLoginScreen(
    navHostController: NavHostController
) {

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = {
            FloatingButton(text = "Sign in", onClick = {
                navHostController.navigate(
                    Screens.PagerScreen.route
                )
            })
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

            val isCheckBoxChecked = remember { mutableStateOf(false) }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Starbucks Rewards",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            LoginTextFieldWithIcon(
                label = "Email*",
                placeholder = "Enter your email here",
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )
            LoginTextFieldWithIcon(
                label = "Password*",
                placeholder = "Enter your password here",
                keyboardType = KeyboardType.Password,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Checkbox(
                    checked = isCheckBoxChecked.value,
                    onCheckedChange = { },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.Gray,
                        checkedColor = Color.Green
                    )
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Keep me logged in",
                    style = TextStyle(
                        fontSize = 22.sp,
                        textAlign = TextAlign.Start
                    )
                )
            }
            Text(
                text = "Forgot password?",
                style = TextStyle(
                    fontSize = 22.sp,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Join now")
    }
}
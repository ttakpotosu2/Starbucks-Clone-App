package com.example.starbucksappclone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.starbucksappclone.onboarding.BottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val balance = 0.00

    Scaffold(
        topBar = { HomeScreenTopBar() },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton = { HomeScreenFAB(balance = balance) }
    ) {
        Column {
            Text(
                text = "Good afternoon, John!",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                ),
                modifier = Modifier.padding(16.dp)
            )
            Row(
                modifier = Modifier
                    .background(Color(0xff1f1f1f))
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xff3b8551)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Column {
                    Text(
                        text = "Welcome to Starbucks Rewards",
                        color = Color.White,
                        fontSize = 30.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "You've got one reward available.\nTap here to redeem.",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row {
                Column(
                    modifier = Modifier
                        .weight(.6f)
                        //   .padding(16.dp)
                        .background(Color(0xff1f1f1f))
                ) {
                    Text(text = "Balance (as of 12.08 pm)")
                    Text(text = "$$balance")
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Add money")
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier
                        .weight(.4f)
                        //   .padding(16.dp)
                        .background(Color(0xff1f1f1f))
                ) {
                    Text(text = "STARS", style = TextStyle(color = Color(0xff3b8551)))
                    Row {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xff3b8551)
                        )
                    }
                    Text(text = "1 Reward available")
                }
            }
        }
    }
}

@Composable
fun HomeScreenTopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
        Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null)
    }
}

@Composable
fun HomeScreenFAB(
    balance: Double
) {
    ExtendedFloatingActionButton(
        text = { Text(text = "$balance on card") },
        onClick = { },
        shape = RoundedCornerShape(1f),
        backgroundColor = Color(0xff3b8551),
        contentColor = Color.White
    )
}
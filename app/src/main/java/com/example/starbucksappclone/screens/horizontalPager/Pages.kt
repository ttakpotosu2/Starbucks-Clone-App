package com.example.starbucksappclone.screens.horizontalPager

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.starbucksappclone.R
import com.example.starbucksappclone.navigation.Screens
import com.example.starbucksappclone.screens.FloatingButton

@Composable
fun PageOne() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff233831))
            .padding(26.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = R.drawable.hp_one),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Welcome to the Starbucks\nmobile app!",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Getting and redeeming Rewards have never been easier. You can now earn and track " +
                    "Stars, and redeem Rewards om your app.",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        )
    }
}

@Composable
fun PageTwo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff233831))
            .padding(26.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = R.drawable.hp_two),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "New ways to order on our app",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Order your Starbucks favorites on the app and choose the pickup method that " +
                    "best suits you.",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 26.sp
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Click on Order to start",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        )
    }
}

@Composable
fun PageThree() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff233831))
            .padding(26.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = R.drawable.hp_three),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = "Set up Auto-Reload",
            style = TextStyle(
                fontSize = 26.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Never have to manually reload your Card again when you set up auto-reload." +
                    "Set up Auto-Reload using your credit or debit card as your payment method.",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 26.sp
            )
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Click on your Card in the Cards tab to start.",
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PageFour(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingButton(
                text = "Let's go",
                onClick = {navController.navigate(Screens.HomeScreen.route)}
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff233831))
                .padding(26.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(
                id = R.drawable.hp_four),
                contentDescription = null,
                modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = "Send an eGift",
                style = TextStyle(
                    fontSize = 26.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Send a digital Starbucks Card to your loved ones for them to enjoy their " +
                        "Starbucks favorites anytime, anywhere",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp
                )
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Click on eGift to start.",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 26.sp
                )
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
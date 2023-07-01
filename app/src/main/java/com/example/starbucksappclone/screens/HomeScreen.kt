package com.example.starbucksappclone.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.starbucksappclone.R
import com.example.starbucksappclone.onboarding.BottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val balance = 0.00

    Scaffold(topBar = { HomeScreenTopBar() },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton = { HomeScreenFAB(balance = balance) }) {
        Column {
            Text(
                text = "Good afternoon, John!", style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                ), modifier = Modifier.padding(16.dp)
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
                        text = "Welcome to Starbucks Rewards", color = Color.White, fontSize = 30.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "You've got one reward available.\nTap here to redeem.",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Column(
                    modifier = Modifier
                        .weight(.65f)
                        .height(150.dp)
                        .background(Color(0xff1f1f1f))
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Balance (as of 12.08 pm)",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "$$balance", style = TextStyle(
                            fontSize = 32.sp, color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    TextButton(
                        onClick = { },
                        shape = RoundedCornerShape(100.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xff3b8551),
                            contentColor = Color.White
                        ),
                    ) {
                        Text(text = "Add money", modifier = Modifier.padding(horizontal = 6.dp))
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(.35f)
                        .height(150.dp)
                        .background(Color(0xff1f1f1f))
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "STARS", style = TextStyle(color = Color(0xff3b8551)))
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xff3b8551)
                        )
                        Text(
                            text = "0",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color(0xff3b8551)
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "1 Reward available",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }

            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    HomeScreenCardContent(
                        image = painterResource(id = R.drawable.coffee_three),
                        heading = "Cozy Comfort",
                        description = "Unwind and recharge with our comforting new drinks."
                    )
                }
                item {
                    HomeScreenCardContent(
                        image = painterResource(id = R.drawable.coffee_two),
                        heading = "Lunar New Year Treats",
                        description = "Treats to gift and share this Lunar New Year"
                    )
                }
                item {
                    HomeScreenCardContent(
                        image = painterResource(id = R.drawable.coffee_four),
                        heading = "All-new Starbucks Rewards!",
                        description = "Enjoy more rewards with your Stars with our new Starbucks" +
                                " Rewards"
                    )
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
        text = { Text(text = "$$balance on card", fontSize = 26.sp) },
        onClick = { },
        shape = RoundedCornerShape(100.dp),
        backgroundColor = Color(0xff3b8551),
        contentColor = Color.White,
        modifier = Modifier.padding(6.dp)
    )
}

@Composable
fun HomeScreenCardContent(
    image: Painter,
    heading: String,
    description: String,
) {
    Card(
        modifier = Modifier
            .height(350.dp)
            .width(300.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 2.dp,
    ) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = heading,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Text(
                text = description,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            )
            Text(
                text = "Find out more",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }


}
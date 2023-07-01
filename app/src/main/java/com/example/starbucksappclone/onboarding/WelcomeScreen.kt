package com.example.starbucksappclone.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.starbucksappclone.R
import com.example.starbucksappclone.data.BottomBarScreen
import com.example.starbucksappclone.navigation.Screens
import com.example.starbucksappclone.screens.FloatingButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WelcomeScreen(
    navHostController: NavHostController

) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
        topBar = { TopAppBarWelcomeScreen() },
        floatingActionButton = { FloatingButton(
            "Join now",
            onClick =  {
                navHostController.navigate(
                    Screens.LoginScreen.route
                )
            }
        )
        }
    ) {
        WelcomeScreenContent(paddingValues = it)
    }
}

@Composable
fun TopAppBarWelcomeScreen() {
    Column {
       Text(
           text = "Its a great day for coffee",
           style = TextStyle(
               fontWeight = FontWeight.Bold,
               fontSize = 24.sp
           ),
           modifier = Modifier.padding(horizontal = 16.dp)
       )
       Row {
            Button(
                onClick = { /*TODO*/ },
                colors = buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Done,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.size(18.dp)
                )
                Text(text = "Sign in")
            }
           Button(
               onClick = { /*TODO*/ },
               colors = buttonColors(
                   backgroundColor = Color.Transparent,
                   contentColor = Color.Black
               ),
               elevation = ButtonDefaults.elevation(0.dp)
           ) {
               Icon(
                   imageVector = Icons.Outlined.Email,
                   contentDescription = "",
                   tint = Color.Black,
                   modifier = Modifier.size(18.dp)
               )
               Text(text = "Sign in")
           }
           Spacer(modifier = Modifier.weight(1f))
           IconButton(
                   onClick = { /*TODO*/ }
           ) {
               Icon(
                   imageVector = Icons.Outlined.AccountCircle,
                   contentDescription = "",
                   tint = Color.Black,
                   modifier = Modifier.size(18.dp)
               )
           }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Cards,
        BottomBarScreen.Order,
        BottomBarScreen.EGift,
        BottomBarScreen.Store
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.label)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = Color.Gray,
        selectedContentColor = Color.Green,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        modifier = Modifier.background(Color.White)
    )
}

@Composable
fun WelcomeScreenContent(paddingValues: PaddingValues) {
    Column (
        modifier = Modifier
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState(0))
            ){
        WelcomeScreenCardOne()

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(bottom = paddingValues.calculateBottomPadding())
                .padding(16.dp)
        ) {

           // Spacer(modifier = Modifier.height(1.dp))
            WelcomeScreenCardTwo(R.drawable.coffee_one,
                "Crazy Smooth\nGoodness",
                "Comforting drinks to\nstart the year with")
            WelcomeScreenCardTwo(R.drawable.coffee_four,
                "Say Good Morning\nTo a Great Breakfast",
                "Complete your meal with a tall sized\nFreshly Brewed Coffee Starting "+
                        "from\n$7.90. Available until 11:30am daily.")
            WelcomeScreenCardTwo(
                R.drawable.coffee_three,
                "Crazy Smooth\nGoodness",
                "Comforting drinks to\nstart the year with"
            )
        }
    }
}

@Composable
fun WelcomeScreenCardOne() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.coffee_two),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun WelcomeScreenCardTwo(
    backgroundImage: Int,
    textOnCard: String,
    subtextOnCard: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(6.dp))
    ) {
        Image(
            painter = painterResource(backgroundImage),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = textOnCard,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = subtextOnCard,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                shape = RoundedCornerShape(24.dp),
                colors = buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Find out more")
            }
        }
    }
}

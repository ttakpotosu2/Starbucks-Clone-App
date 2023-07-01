package com.example.starbucksappclone.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.starbucksappclone.onboarding.LoginScreen
import com.example.starbucksappclone.onboarding.WelcomeScreen
import com.example.starbucksappclone.screens.HomeScreen
import com.example.starbucksappclone.screens.horizontalPager.PagerScreen
import com.example.starbucksappclone.screens.RewardsLoginScreen
import com.example.starbucksappclone.screens.RewardsScreen

@ExperimentalFoundationApi
@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.WelcomeScreen.route
    ) {
        composable(route = Screens.WelcomeScreen.route) {
            WelcomeScreen(navHostController = navController)
        }
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(route = Screens.RewardsScreen.route) {
            RewardsScreen(navController)
        }
        composable(route = Screens.RewardsLoginScreen.route) {
            RewardsLoginScreen(navController)
        }
        composable(route = Screens.PagerScreen.route) {
            PagerScreen(navController)
        }
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController)
        }
    }
}



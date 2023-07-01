package com.example.starbucksappclone.navigation

sealed class Screens(val route: String){
    object PagerScreen: Screens("pager_screen")
    object LoginScreen: Screens("login_screen")
    object WelcomeScreen: Screens("welcome_screen")
    object RewardsLoginScreen: Screens("rewards_login_screen")
    object RewardsScreen: Screens("rewards_screen")
    object HomeScreen: Screens("home_screen")
}

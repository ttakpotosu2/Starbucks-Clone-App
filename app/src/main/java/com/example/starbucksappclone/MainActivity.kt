package com.example.starbucksappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.compose.rememberNavController
import com.example.starbucksappclone.navigation.NavGraph
import com.example.starbucksappclone.ui.theme.StarbucksAppCloneTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarbucksAppCloneTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
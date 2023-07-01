package com.example.starbucksappclone.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route:String,
)

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        label = "Home",
        icon = Icons.Default.Star
    )

    object Cards : BottomBarScreen(
        route = "cards",
        label = "Cards",
        icon = Icons.Default.Favorite
    )

    object Order : BottomBarScreen(
        route = "order",
        label = "Order",
        icon = Icons.Default.Refresh
    )

    object EGift : BottomBarScreen(
        route = "egift",
        label = "eGift",
        icon = Icons.Default.Settings
    )

    object Store : BottomBarScreen(
        route = "store",
        label = "Store",
        icon = Icons.Default.Settings
    )
}
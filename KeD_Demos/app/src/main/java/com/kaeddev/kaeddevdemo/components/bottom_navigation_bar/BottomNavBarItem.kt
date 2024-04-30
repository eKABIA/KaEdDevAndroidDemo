package com.kaeddev.kaeddevdemo.components.bottom_navigation_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItem(
    val title : String,
    val route : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val iconContentDescription : String,
    val badgeAmount : Int? = null
)

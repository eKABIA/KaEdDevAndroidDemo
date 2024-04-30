package com.kaeddev.kaeddevdemo.main_container

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kaeddev.kaeddevdemo.components.bottom_navigation_bar.StandardScaffold
import com.kaeddev.kaeddevdemo.navigation.main.MainNavHost
import com.kaeddev.kaeddevdemo.navigation.main.activity.ActivityLeafScreen
import com.kaeddev.kaeddevdemo.navigation.main.chat.ChatLeafScreen
import com.kaeddev.kaeddevdemo.navigation.main.home.HomeLeafScreen
import com.kaeddev.kaeddevdemo.navigation.main.profile.ProfileLeafScreen
import com.kaeddev.kaeddevdemo.navigation.navigateSingleTopTo

@Composable
fun  MainContainer() {
    val navController  = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    StandardScaffold(
        showBottomBar = navBackStackEntry?.destination?.route in listOf(
            HomeLeafScreen.HomeScreen.route,
            ChatLeafScreen.ChatScreen.route,
            ActivityLeafScreen.ActivityScreen.route,
            ProfileLeafScreen.ProfileScreen.route,
        ),
        navigate = { navController.navigateSingleTopTo(it) }
    ) {
        Box(modifier = it) {
            MainNavHost(
                navController = navController
            )
        }
    }
}

@Preview
@Composable
fun MainContainerPreview(){
    MainContainer()
}
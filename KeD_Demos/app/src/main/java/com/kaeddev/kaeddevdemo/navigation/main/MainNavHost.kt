package com.kaeddev.kaeddevdemo.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kaeddev.kaeddevdemo.navigation.NavGraphRoutes
import com.kaeddev.kaeddevdemo.navigation.main.activity.addActivityRoute
import com.kaeddev.kaeddevdemo.navigation.main.chat.addChatRoute
import com.kaeddev.kaeddevdemo.navigation.main.home.addHomeRoute
import com.kaeddev.kaeddevdemo.navigation.main.profile.addProfileRoute

@Composable
fun MainNavHost(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        route = NavGraphRoutes.Main.route,
        startDestination = RootScreen.Home.route
    ){

        addHomeRoute(navController = navController)

        addChatRoute(navController)

        addActivityRoute(navController)

        addProfileRoute(navController)
    }
}

sealed class RootScreen(val route: String){
    data object Home : RootScreen("home_root")
    data object Chat : RootScreen("chat_root")
    data object Activity : RootScreen("activity_root")
    data object Profile : RootScreen("profile_root")
}
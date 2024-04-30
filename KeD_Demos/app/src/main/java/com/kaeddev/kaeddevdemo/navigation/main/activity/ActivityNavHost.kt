package com.kaeddev.kaeddevdemo.navigation.main.activity

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kaeddev.kaeddevdemo.activity.ActivityScreen
import com.kaeddev.kaeddevdemo.navigation.main.RootScreen

fun NavGraphBuilder.addActivityRoute(navController: NavController){
    navigation(
        route = RootScreen.Activity.route,
        startDestination = ActivityLeafScreen.ActivityScreen.route
    ){
        showActivity(navController)
    }
}

private fun NavGraphBuilder.showActivity(navController: NavController){
    composable(route = ActivityLeafScreen.ActivityScreen.route){
        ActivityScreen()
    }
}

sealed class ActivityLeafScreen(val route: String){
    data object ActivityScreen : ActivityLeafScreen(route = "activity_leaf_screen" )
}

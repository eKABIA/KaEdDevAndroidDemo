package com.kaeddev.kaeddevdemo.navigation.main.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kaeddev.kaeddevdemo.add_element.AddElementScreen
import com.kaeddev.kaeddevdemo.home.HomeScreen
import com.kaeddev.kaeddevdemo.home_element_detail.ElementDetailScreen
import com.kaeddev.kaeddevdemo.navigation.main.RootScreen

//region $Home Navigation
fun NavGraphBuilder.addHomeRoute(navController: NavController){
    navigation(
        route = RootScreen.Home.route,
        startDestination = HomeLeafScreen.HomeScreen.route
    ){
        showHome(navController)
        showDetail(navController)
        addPost(navController)
    }
}
private fun NavGraphBuilder.showHome(navController: NavController){
    composable(route = HomeLeafScreen.HomeScreen.route){
        HomeScreen(
            showElementDetail = {
                navController.navigate(HomeLeafScreen.ElementDetailScreen.route)
            }
        )
    }
}
private fun NavGraphBuilder.showDetail(navController: NavController){
    composable(route = HomeLeafScreen.ElementDetailScreen.route){
        ElementDetailScreen(
            onBack = {
                navController.navigateUp()
            },
            elementTitle = "Zoro Story"
        )
    }
}
private fun NavGraphBuilder.addPost(navController: NavController) {
    composable(route = HomeLeafScreen.CreateElementScreen.route){
        AddElementScreen(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}
//endregion

sealed class HomeLeafScreen(val route : String){
    data object HomeScreen : HomeLeafScreen(route = "home_leaf_screen")
    data object CreateElementScreen : HomeLeafScreen(route = "home_leaf_screen_create_elem")
    data object ElementDetailScreen : HomeLeafScreen(route = "home_leaf_screen_element_detail")
}
package com.kaeddev.kaeddevdemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kaeddev.kaeddevdemo.main_container.MainContainer
import com.kaeddev.kaeddevdemo.navigation.auth.authNavHost

@Composable
fun RootNavHost(
    navController: NavHostController
){
    //
    NavHost(
        navController = navController, 
        startDestination =   NavGraphRoutes.Auth.route
    ){
        //
        authNavHost(navController = navController)
        //
        composable(route = NavGraphRoutes.Main.route){
            MainContainer()
        }
    }
}

sealed class NavGraphRoutes(val route: String){
    data object Auth : NavGraphRoutes(route = NavGraphsNavigationRoutes.AUTH_ROUTE)
    data object Main : NavGraphRoutes(route = NavGraphsNavigationRoutes.MAIN_ROUTE)
}

object NavGraphsNavigationRoutes{
    const val AUTH_ROUTE = "AUTH_NAV_GRAPH"
    const val MAIN_ROUTE = "HOME_NAV_GRAPH"
}
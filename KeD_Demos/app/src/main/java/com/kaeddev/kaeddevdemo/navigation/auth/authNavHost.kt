package com.kaeddev.kaeddevdemo.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kaeddev.kaeddevdemo.login.presentation.LoginScreen
import com.kaeddev.kaeddevdemo.navigation.NavGraphRoutes
import com.kaeddev.kaeddevdemo.register.presentation.RegisterScreen

fun NavGraphBuilder.authNavHost(
    navController: NavHostController
){
    navigation(
        startDestination = AuthNavScreen.LoginScreen.route,
        route = NavGraphRoutes.Auth.route
    ){
        composable(route = AuthNavScreen.LoginScreen.route){
            LoginScreen(
                navigate = { navigateToRegister->
                    if(navigateToRegister) navController.navigate(AuthNavScreen.RegisterScreen.route)
                    else navController.navigate(NavGraphRoutes.Main.route)
                }
            )
        }

        composable(route = AuthNavScreen.RegisterScreen.route){
            RegisterScreen(navigate = { navigateAsRegistered ->
                if(navigateAsRegistered) navController.navigate(NavGraphRoutes.Main.route)
                else navController.navigateUp()
            })
        }
    }
}

sealed class AuthNavScreen(val route: String) {
    data object LoginScreen : AuthNavScreen(route = AuthNavigationRoutes.LOGIN_SCREEN)
    data object RegisterScreen : AuthNavScreen(route = AuthNavigationRoutes.REGISTER_SCREEN)
}

object AuthNavigationRoutes{
    const val LOGIN_SCREEN =  "login_screen"
    const val REGISTER_SCREEN =  "register_screen"
}
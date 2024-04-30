package com.kaeddev.kaeddevdemo.navigation.main.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kaeddev.kaeddevdemo.edit_profile.EditProfileScreen
import com.kaeddev.kaeddevdemo.navigation.main.RootScreen
import com.kaeddev.kaeddevdemo.profile.ProfileScreen


fun NavGraphBuilder.addProfileRoute(navController: NavController){
    navigation(
        route = RootScreen.Profile.route,
        startDestination = ProfileLeafScreen.ProfileScreen.route
    ){
        showProfile(navController)
        editProfile(navController)
    }
}

private fun NavGraphBuilder.showProfile(navController: NavController){
    composable(route = ProfileLeafScreen.ProfileScreen.route){
        ProfileScreen(
            onEditProfile =  {
                navController.navigate(route = ProfileLeafScreen.EditProfileScreen.route)
            }
        )
    }
}

private fun NavGraphBuilder.editProfile(navController: NavController){
    composable(route = ProfileLeafScreen.EditProfileScreen.route ){
        EditProfileScreen(
            onBack = {navController.navigateUp()}
        )
    }
}

sealed class ProfileLeafScreen(val route: String){
    data object ProfileScreen : ProfileLeafScreen(route = "profile_leaf_screen")
    data object EditProfileScreen : ProfileLeafScreen(route = "profile_leaf_edit_screen")

}

package com.kaeddev.kaeddevdemo.navigation.main.chat

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kaeddev.kaeddevdemo.chat.ChatScreen
import com.kaeddev.kaeddevdemo.navigation.main.RootScreen


fun NavGraphBuilder.addChatRoute(navController: NavController){
    navigation(
        route = RootScreen.Chat.route,
        startDestination = ChatLeafScreen.ChatScreen.route
    ){
        showChats(navController)
    }
}

private fun NavGraphBuilder.showChats(navController: NavController){
    composable(route = ChatLeafScreen.ChatScreen.route){
        ChatScreen()
    }
}

sealed class ChatLeafScreen(val route: String){
    data object ChatScreen : ChatLeafScreen(route = "chat_leaf_screen")
}
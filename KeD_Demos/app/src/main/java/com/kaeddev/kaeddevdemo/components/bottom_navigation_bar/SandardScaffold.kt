package com.kaeddev.kaeddevdemo.components.bottom_navigation_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Person4
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Person4
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.navigation.main.RootScreen
import com.kaeddev.kaeddevdemo.navigation.main.home.HomeLeafScreen

@Composable
fun StandardScaffold(
    bottomNavBarItems: List<BottomNavBarItem> = listOf(
        BottomNavBarItem(
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            iconContentDescription = stringResource(id = R.string.home_icon_content_description),
            title = stringResource(id = R.string.home),
            route = RootScreen.Home.route
        ),
        BottomNavBarItem(
            selectedIcon = Icons.Filled.ChatBubble,
            unselectedIcon = Icons.Outlined.ChatBubbleOutline,
            iconContentDescription = stringResource(id = R.string.chat_icon_content_description),
            title = stringResource(id = R.string.chat),
            route = RootScreen.Chat.route
        ),
        BottomNavBarItem(
            selectedIcon = Icons.Filled.Notifications,
            unselectedIcon = Icons.Outlined.Notifications,
            iconContentDescription = stringResource(id = R.string.activity_icon_content_description),
            title = stringResource(id = R.string.activity),
            route = RootScreen.Activity.route
        ),
        BottomNavBarItem(
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            iconContentDescription = stringResource(id = R.string.profile_icon_content_description),
            title = stringResource(id = R.string.profile),
            route = RootScreen.Profile.route
        )
    ),
    navigate: ((String) -> Unit?)? = null,
    showBottomBar: Boolean = true,
    content: @Composable (Modifier) -> Unit
){
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            if (showBottomBar){
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    NavigationBar(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        bottomNavBarItems.forEachIndexed { index, bottomNavBarItem ->
                            StandardBottomNavItem(
                                isSelected = index == selectedTabIndex,
                                selectedIcon = bottomNavBarItem.selectedIcon,
                                unSelectedIcon = bottomNavBarItem.unselectedIcon,
                                iconContentDescription = bottomNavBarItem.iconContentDescription,
                                title = bottomNavBarItem.title,
                                onClick = {
                                    selectedTabIndex = index
                                    navigate?.let { it(bottomNavBarItem.route)}
                                }
                            )
                        }
                    }
                }
            }
        },
        floatingActionButton =  {
            if (showBottomBar){
                FloatingActionButton(
                    onClick = { navigate?.let{it(HomeLeafScreen.CreateElementScreen.route)} },
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.make_post)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        content(Modifier.padding(it))
    }
}

@Preview
@Composable
fun StandardScaffoldPreview(){
    StandardScaffold(
        bottomNavBarItems =  listOf(
            BottomNavBarItem(
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                iconContentDescription = stringResource(id = R.string.home_icon_content_description),
                title = stringResource(id = R.string.home),
                route = RootScreen.Home.route
            ),
            BottomNavBarItem(
                selectedIcon = Icons.Filled.ChatBubble,
                unselectedIcon = Icons.Outlined.ChatBubbleOutline,
                iconContentDescription = stringResource(id = R.string.chat_icon_content_description),
                title = stringResource(id = R.string.chat),
                route = RootScreen.Chat.route
            ),
            BottomNavBarItem(
                selectedIcon = Icons.Filled.Notifications,
                unselectedIcon = Icons.Outlined.Notifications,
                iconContentDescription = stringResource(id = R.string.activity_icon_content_description),
                title = stringResource(id = R.string.activity),
                route = RootScreen.Activity.route
            ),
            BottomNavBarItem(
                selectedIcon = Icons.Filled.Person4,
                unselectedIcon = Icons.Outlined.Person4,
                iconContentDescription = stringResource(id = R.string.profile_icon_content_description),
                title = stringResource(id = R.string.profile),
                route = RootScreen.Profile.route
            )
        ),
        navigate = {}
    ) {
        Text(text = "Text")
    }
}
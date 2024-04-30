package com.kaeddev.kaeddevdemo.components.bottom_navigation_bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.R

@Composable
fun RowScope.StandardBottomNavItem(
    isSelected : Boolean,
    selectedIcon : ImageVector,
    unSelectedIcon : ImageVector,
    title : String,
    iconContentDescription : String,
    alertCount : Int?  = null,
    showBadge : Boolean = false,
    enabled : Boolean = true,
    onClick : () -> Unit
){
    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        enabled = enabled,
        icon = {
            NavBarItemView(
                isSelected = isSelected,
                selectedIcon = selectedIcon,
                unselectedIcon = unSelectedIcon ,
                badgeAmount = alertCount,
                showBadge = showBadge,
                imageDescription = iconContentDescription
            )
        },
        label = { Text( text = title )}
    )

}

@Preview
@Composable
fun StandardBottomNavItemPreview(){
    NavigationBar {
        StandardBottomNavItem(
            isSelected  = true,
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
            showBadge = true,
            title = stringResource(id = R.string.home),
            iconContentDescription = "Preview Description") { }

        StandardBottomNavItem(
            isSelected = false,
            selectedIcon = Icons.Filled.ChatBubble,
            unSelectedIcon = Icons.Outlined.ChatBubbleOutline,
            alertCount = 25,
            title = stringResource(id = R.string.chat),
            iconContentDescription = "Preview Description") { }
        StandardBottomNavItem(
            isSelected = false,
            selectedIcon = Icons.Filled.Notifications,
            unSelectedIcon = Icons.Outlined.Notifications,
            title = stringResource(id = R.string.activity),
            iconContentDescription = "Preview Description") {

        }
        StandardBottomNavItem(
            isSelected = false,
            selectedIcon = Icons.Filled.Person,
            unSelectedIcon = Icons.Outlined.Person,
            title = stringResource(id = R.string.profile),
            iconContentDescription = "Preview Description") {

        }
    }
}
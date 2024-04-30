package com.kaeddev.kaeddevdemo.components.bottom_navigation_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.outlined.House
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NavBarItemView(
    isSelected : Boolean,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    imageDescription: String,
    badgeAmount: Int? = null,
    showBadge : Boolean = false
) {
    if (showBadge || (badgeAmount != null && badgeAmount > 0 )){
        BadgedBox(
            badge = {
                Badge(
                    content = {
                        if (badgeAmount != null)
                            Text(text = "$badgeAmount" )
                    }
                )
            }
        ) {
            Icon(
                imageVector = if (isSelected) {selectedIcon} else {unselectedIcon},
                contentDescription = imageDescription,
                modifier = Modifier
                    .padding(
                        top = 3.dp,
                        end = 3.dp)
            )
        }
    }else{
        Icon(
            imageVector = if (isSelected) {selectedIcon} else {unselectedIcon},
            contentDescription = imageDescription
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun NavBarItemViewPreview(){
    NavigationBar {
        NavigationBarItem(
            icon = {
                NavBarItemView(
                    isSelected = true,
                    selectedIcon = Icons.Filled.House,
                    unselectedIcon = Icons.Outlined.House ,
                    badgeAmount = 325,
                    imageDescription = "Home"
                )
            },
            onClick = {},
            selected = true
        )
    }

}
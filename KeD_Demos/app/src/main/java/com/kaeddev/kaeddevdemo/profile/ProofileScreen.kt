package com.kaeddev.kaeddevdemo.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.components.collapsing_toolbar.CollapsingToolbar
import com.kaeddev.kaeddevdemo.ui.theme.Spacing

@Composable
fun ProfileScreen(
    onEditProfile : () -> Unit
) {
    CollapsingToolbar(
        onEditProfileClick = onEditProfile,
        content = {
            repeat(15){
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                            "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
                            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                            "voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
                            "anim id est laborum",
                    modifier = Modifier
                        .padding(
                            vertical = Spacing.SpacingMedium,
                            horizontal = Spacing.SpacingLarge
                        )
                )
            }

        }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen {}
}
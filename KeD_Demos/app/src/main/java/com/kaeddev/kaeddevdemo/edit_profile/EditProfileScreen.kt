package com.kaeddev.kaeddevdemo.edit_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.components.toolbar.StandardToolBar

@Composable
fun EditProfileScreen(
    onBack : ()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StandardToolBar(
            title = {
                Text(
                    text = stringResource(R.string.edit_profile_title)
                )
            },
            showToolbarBackArrow = true,
            onBackPressed = onBack
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Update Your profile",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun EditProfileScreenPreview() {
    EditProfileScreen {}
}
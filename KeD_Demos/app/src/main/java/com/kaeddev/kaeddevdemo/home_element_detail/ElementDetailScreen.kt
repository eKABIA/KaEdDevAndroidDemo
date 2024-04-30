package com.kaeddev.kaeddevdemo.home_element_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kaeddev.kaeddevdemo.components.toolbar.StandardToolBar

@Composable
fun ElementDetailScreen(
    onBack : () -> Unit,
    elementTitle : String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StandardToolBar(
            title = {
                Text(
                    text = elementTitle
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
                text = "Add Your awesome detail",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun ElementDetailScreenPreview() {
    ElementDetailScreen({},"Zoro Story")
}
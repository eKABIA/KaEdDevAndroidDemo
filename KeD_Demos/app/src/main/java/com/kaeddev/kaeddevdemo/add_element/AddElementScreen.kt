package com.kaeddev.kaeddevdemo.add_element

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.components.toolbar.StandardToolBar

@Composable
fun AddElementScreen(
    onBack : () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolBar(
            title = {
                Text(
                    text = stringResource(id = R.string.create_new_hero),
                    fontWeight = FontWeight.Bold
                )
            },
            showToolbarBackArrow = true,
            onBackPressed = onBack
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun AddElementScreenPreview() {
    AddElementScreen {}
}
package com.kaeddev.kaeddevdemo.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.components.toolbar.StandardToolBar

@Composable
fun ActivityScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StandardToolBar(
            title = {
                Text(
                    text = stringResource(R.string.activity)
                )
            },
            showToolbarBackArrow = false
        )
    }
}

@Preview
@Composable
private fun ActivityScreenPreview() {
    ActivityScreen()
}
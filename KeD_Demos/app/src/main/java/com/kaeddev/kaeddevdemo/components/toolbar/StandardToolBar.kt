package com.kaeddev.kaeddevdemo.components.toolbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  StandardToolBar(
    showToolbarBackArrow: Boolean = true,
    navActions: @Composable  (RowScope.() -> Unit) = {},
    title : @Composable () -> Unit = {},
    onBackPressed : () -> Unit = {}
) {

    TopAppBar(
        title = title,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            if (showToolbarBackArrow){
                IconButton(
                    onClick = onBackPressed
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.toolbar_back_arrow_content_description)
                    )
                }
            }
        },
        actions = navActions
    )
}

@Preview
@Composable
fun StandardToolBarPreview(){
    StandardToolBar(title = { Text(text = "Title")}){}
}
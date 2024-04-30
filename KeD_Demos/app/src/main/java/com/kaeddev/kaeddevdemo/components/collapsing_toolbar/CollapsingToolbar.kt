package com.kaeddev.kaeddevdemo.components.collapsing_toolbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.ui.theme.Spacing
import com.kaeddev.kaeddevdemo.utils.toPx

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingToolbar(
    modifier : Modifier = Modifier,
    content: @Composable () -> Unit,
    isOwnProfile : Boolean = true,
    onEditProfileClick : () -> Unit = {},
    onLinkedInClick : ()-> Unit = {},
    onLinkClick : ()-> Unit = {},
    onGithubInClick : ()-> Unit = {}
    ) {
    // Config init with our screen size cause many of next things will depend on screen Size
    val toolbarConfiguration = ToolbarConfiguration(
        screenWidthDP = LocalConfiguration.current.screenWidthDp.dp
    )
    // need to apply padding for better centering
    if(!isOwnProfile) toolbarConfiguration.titleConfigs.paddingToReduceIconButtonSpace = 0.dp
    //
    val scroll = rememberScrollState()
    // when our content scroll reach our toolbar bottom
    val toolbarBottomOffset by remember {
        mutableFloatStateOf(
            toolbarConfiguration.titleConfigs.collapseRange
        )
    }
    // start to show toolbar with animation and change horizontal arrangement of our row container too
    val showToolbar by remember {
        derivedStateOf { scroll.value >= toolbarBottomOffset  }
    }

    Box(modifier = modifier) {
        Body(
            scroll = scroll,
            content = content,
            startContentPadding = toolbarConfiguration.titleConfigs.totalBannerHeightAfterTitle
        )
        //
        AnimatedVisibility(
            modifier = modifier,
            visible = showToolbar,
            enter = fadeIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300))
        ) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {}
            )
        }
        //
        Header(
            scroll = scroll,
            toolbarConfiguration = toolbarConfiguration,
            onEditProfileClick  = onEditProfileClick,
            isOwnProfile = isOwnProfile,
            onGithubInClick = onGithubInClick,
            onLinkClick = onLinkClick,
            titleStart = showToolbar,
            onLinkedInClick = onLinkedInClick
        )
    }
}

@Composable
fun Header(
    scroll : ScrollState,
    toolbarConfiguration : ToolbarConfiguration,
    titleStart : Boolean ,
    modifier : Modifier = Modifier,
    isOwnProfile : Boolean = true,
    onEditProfileClick : ()-> Unit,
    onLinkedInClick : ()-> Unit,
    onLinkClick : ()-> Unit,
    onGithubInClick : ()-> Unit
){

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(toolbarConfiguration.profileImageConfigs.bannerHeight)
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = stringResource(id = R.string.banner_image),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .bannerAnimation(
                    scroll.value.toFloat(),
                    toolbarConfiguration.titleConfigs.totalBannerHeightAfterTitle.toPx()
                )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .bannerAnimation(
                    scroll.value.toFloat(),
                    toolbarConfiguration.titleConfigs.totalBannerHeightAfterTitle.toPx()
                )
                .align(Alignment.BottomStart)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                ) ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.kotlin),
                    contentDescription ="",
                    alignment = Alignment.Center
                )

                Image(
                    painter = painterResource(id = R.drawable.swift),
                    contentDescription =""
                )

                Image(
                    painter = painterResource(id = R.drawable.csharp),
                    contentDescription =""
                )
            }

            Row (
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                IconButton(
                    onClick = onGithubInClick,
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription ="",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = onLinkClick ,
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_language_24),
                        contentDescription ="",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = onLinkedInClick ,
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription ="",
                        tint = Color.White
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = toolbarConfiguration.profileImageConfigs.imageSize / 2f)
                .profileImageAnimation(
                    scroll.value,
                    toolbarConfiguration.profileImageConfigs,
                    collapseRange = toolbarConfiguration.titleConfigs.collapseRange
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.portrait),
                contentDescription = stringResource(id = R.string.profile_image_content_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(toolbarConfiguration.profileImageConfigs.imageSize)
                    .clip(CircleShape)
                    .border(
                        width = 1.5.dp,
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    )

            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(toolbarConfiguration.titleConfigs.titleWidth)
                .height(toolbarConfiguration.titleConfigs.rowTitleContainerHeight)
                .padding(
                    start = toolbarConfiguration.titleConfigs.paddingToReduceIconButtonSpace
                )
                .offset(y = toolbarConfiguration.titleConfigs.offsetAfterImage)
                .titleAnimation(
                    scrollValue = scroll.value,
                    collapseRange = toolbarConfiguration.titleConfigs.collapseRange,
                    titleConfigs =  toolbarConfiguration.titleConfigs
                ),
            horizontalArrangement = if(titleStart) Arrangement.Start else Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "Monkey D. Luffy",
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold
            )
            if (isOwnProfile){
                IconButton(
                    onClick = onEditProfileClick
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                }
            }

        }

    }
}

@Composable
fun Body(
    modifier : Modifier = Modifier,
    scroll : ScrollState,
    startContentPadding : Dp,
    content: @Composable () -> Unit

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(scroll)
    ) {
        Spacer(
            modifier  = Modifier
                .height(startContentPadding)
        )
        content()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun CollapsingToolbarPreview(){
    val ispro = true
    CollapsingToolbar(
        modifier = Modifier,
        isOwnProfile = ispro,
        onLinkedInClick = {},
        onLinkClick = {},
        onGithubInClick = {},
        onEditProfileClick = {},
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
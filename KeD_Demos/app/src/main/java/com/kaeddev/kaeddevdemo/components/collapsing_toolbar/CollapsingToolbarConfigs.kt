package com.kaeddev.kaeddevdemo.components.collapsing_toolbar

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kaeddev.kaeddevdemo.utils.toPx

data class ToolbarConfiguration(
    val screenWidthDP : Dp,
    // default toolbar height in material 3
    var toolbarHeight : Dp = 64.dp
){
    //
    private val bannerHeight = (screenWidthDP / 2f)
    // default padding of back button in toolbar
    private val defaultToolbarPaddingStart = 16.dp
    // image size on the end of our scroll when we reach our toolbar
    private val destinationImageSize = 40.dp

    val profileImageConfigs = ProfileImageConfigs(
        screenWidthDP = screenWidthDP,
        bannerHeight = bannerHeight,
        toolbarHeight = toolbarHeight,
        defaultToolbarPaddingStart = defaultToolbarPaddingStart,
        destinationImageSize = destinationImageSize
    )

    val titleConfigs = TitleConfigs(
        screenWidthDP = screenWidthDP,
        bannerHeight = bannerHeight,
        toolbarHeight = toolbarHeight,
        imageSize = profileImageConfigs.imageSize,
        defaultToolbarPaddingStart = defaultToolbarPaddingStart,
        destinationImageSize = destinationImageSize
    )
}

data class ProfileImageConfigs(
    val screenWidthDP : Dp,
    val bannerHeight : Dp,
    val toolbarHeight : Dp,
    val defaultToolbarPaddingStart : Dp,
    val destinationImageSize : Dp
){
    // point to reach during translation and our en scale from 1 to 0...f depending or our image sizes
    val imageSize = (screenWidthDP / 3.4f)
    val lastXEnd =  (-screenWidthDP / 2.dp).dp + (destinationImageSize/2) + defaultToolbarPaddingStart
    val firstXEnd =  - lastXEnd + (lastXEnd / 3.5f)
    val firstY = - ( bannerHeight - imageSize / 2) / 2
    val lastY = - ( bannerHeight ) + (destinationImageSize / 2) + ( ( toolbarHeight - destinationImageSize ) / 2 )
    val endScale = (destinationImageSize / imageSize)
}

data class TitleConfigs(
    val screenWidthDP : Dp,
    val bannerHeight : Dp,
    val toolbarHeight : Dp,
    val imageSize : Dp,
    val defaultToolbarPaddingStart :Dp,
    val destinationImageSize : Dp
){
    private val paddingAfterImageAndAfterText = 8.dp
    // need fixed size to place it gracefully at the end 
    val titleWidth = (screenWidthDP / 1.5f)
    val rowTitleContainerHeight = 40.dp
    // icon button take to much space and it will look like not centered without this ^^
    var paddingToReduceIconButtonSpace = 20.dp
    val offsetAfterImage = rowTitleContainerHeight + (imageSize / 2 ) + paddingAfterImageAndAfterText
    // place to make padding to the content top start
    val totalBannerHeightAfterTitle = bannerHeight + (imageSize / 2) + paddingAfterImageAndAfterText + rowTitleContainerHeight
    // Space between
    val collapseRange = (totalBannerHeightAfterTitle - toolbarHeight).toPx()
    val firstXEnd = screenWidthDP / 2f
    val secondXEnd = - ((screenWidthDP / 2) - ((titleWidth / 2) - paddingToReduceIconButtonSpace) ) + destinationImageSize + ( defaultToolbarPaddingStart * 2 )
    val firstYEnd = - totalBannerHeightAfterTitle / 2
    val secondYEnd = - (totalBannerHeightAfterTitle) + rowTitleContainerHeight + ((toolbarHeight - rowTitleContainerHeight)/2)
}


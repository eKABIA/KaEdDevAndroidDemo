package com.kaeddev.kaeddevdemo.components.collapsing_toolbar

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp

// Linéar interpolation and quadratic Bézier curve
// based on screen size in CollapsingToolbarConfigs.kt
fun Modifier.profileImageAnimation(
    scrollValue : Int,
    profileImageConfigs : ProfileImageConfigs,
    collapseRange : Float ) = graphicsLayer {

    val collapseFraction: Float = (scrollValue / collapseRange).coerceIn(0f, 1f)
    // Linear Conversion
    val newScale : Float = ((( collapseFraction - 0f) * (profileImageConfigs.endScale - 1f)) / (1f-0f)) + 1f

    //region $X-Axis
    val xFirstInterpolatedPoint = lerp(
        start = 0.dp,
        stop =  - profileImageConfigs.firstXEnd ,
        fraction = collapseFraction
    )
    val xSecondInterpolatedPoint = lerp(
        start = - profileImageConfigs.firstXEnd ,
        stop = profileImageConfigs.lastXEnd,
        fraction = collapseFraction
    )

    val xPoint = lerp(
        start = xFirstInterpolatedPoint,
        stop = xSecondInterpolatedPoint,
        fraction = collapseFraction
    )
    //endregion

    //region $Y-Axis
    val yFirstInterpolatedPoint = lerp(
        start = 0.dp,
        stop = profileImageConfigs.firstY,
        fraction = collapseFraction
    )
    val ySecondInterpolatedPoint = lerp(
        start = profileImageConfigs.firstY,
        stop = profileImageConfigs.lastY ,
        fraction = collapseFraction
    )

    val yPoint = lerp(
        start = yFirstInterpolatedPoint,
        stop = ySecondInterpolatedPoint,
        fraction = collapseFraction
    )
    //endregion

    translationY = yPoint.toPx()
    translationX = xPoint.toPx()

    scaleX = newScale
    scaleY = newScale
}

fun Modifier.bannerAnimation(scrollValue : Float, totalBannerHeight : Float ) = graphicsLayer {
    // y translation depending on our scroll, parallax effect
    translationY = -scrollValue / 1.7f
    // alpha based on simple affine function
    alpha = (-1f / totalBannerHeight) * scrollValue + 1
}

fun Modifier.titleAnimation(scrollValue: Int, collapseRange : Float, titleConfigs: TitleConfigs) = graphicsLayer {

    val collapseFraction = (scrollValue / collapseRange).coerceIn(0f, 1f)
    //region $X-Axis
    val xFirstInterpolatedPoint = lerp(
        start = 0.dp,
        stop = titleConfigs.firstXEnd,
        fraction = collapseFraction
    )
    val xSecondInterpolatedPoint = lerp(
        start = titleConfigs.firstXEnd,
        stop = titleConfigs.secondXEnd,
        fraction = collapseFraction
    )

    val xPoint = lerp(
        start = xFirstInterpolatedPoint,
        stop = xSecondInterpolatedPoint,
        fraction = collapseFraction
    )
    //endregion

    //region $Y-Axis
    val yFirstInterpolatedPoint = lerp(
        start = 0.dp,
        stop = titleConfigs.secondYEnd,
        fraction = collapseFraction
    )
    val ySecondInterpolatedPoint = lerp(
        start = titleConfigs.firstYEnd,
        stop =  titleConfigs.secondYEnd,
        fraction = collapseFraction
    )

    val yPoint = lerp(
        start = yFirstInterpolatedPoint,
        stop = ySecondInterpolatedPoint,
        fraction = collapseFraction
    )
    //endregion
    translationY = yPoint.toPx()
    translationX = xPoint.toPx()
}
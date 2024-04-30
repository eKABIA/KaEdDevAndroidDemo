package com.kaeddev.kaeddevdemo.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.components.toolbar.StandardToolBar
import com.kaeddev.kaeddevdemo.ui.theme.Spacing

@Composable
fun HomeScreen(
    showElementDetail : () ->Unit
) {
    var zoroFavorite by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        StandardToolBar(
            title = {Text(
                text = stringResource(R.string.home)
            )},
            showToolbarBackArrow = false
        )
        Column(
            modifier = Modifier
                .padding(horizontal = Spacing.SpacingMedium)
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                    .clickable {
                        showElementDetail()
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Spacing.SpacingMedium)
                        .padding(top = Spacing.SpacingSmall)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.zoro),
                        contentDescription = "Profile picture ",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape)
                            .align(Alignment.TopCenter)
                    )
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        tint = if(zoroFavorite) Color.Red else Color.Gray,
                        contentDescription = "Profile picture ",
                        modifier = Modifier
                            .clip(CircleShape)
                            .align(Alignment.TopEnd)
                            .clickable { zoroFavorite = !zoroFavorite }
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = Spacing.SpacingMedium,
                            vertical = Spacing.SpacingSmall
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Zoro",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding( vertical = 8.dp),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = stringResource(id = R.string.zoro_story),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }

    }

}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
private fun HomeScreenPreview() {
    HomeScreen {}
}
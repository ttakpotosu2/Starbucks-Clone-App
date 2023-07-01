package com.example.starbucksappclone.screens.horizontalPager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@ExperimentalFoundationApi
@Composable
fun PagerScreen(
    navController: NavHostController
) {
    val pagerState = rememberPagerState()

    Box {
        HorizontalPager(
            pageCount = 4,
            state = pagerState
        ) { page ->
            when (page) {
                0 -> { PageOne() }
                1 -> { PageTwo() }
                2 -> { PageThree() }
                3 -> { PageFour(navController) }
            }
        }
        Row(
            modifier = Modifier
                .height(40.dp)
                .align(Alignment.BottomStart)
        ) {
            repeat(4) {
                val color =
                    if (pagerState.currentPage == it) Color.White else Color.White.copy(.35f)
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 2.dp, bottom = 5.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}
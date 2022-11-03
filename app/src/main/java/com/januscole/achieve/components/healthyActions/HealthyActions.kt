package com.januscole.achieve.components.healthyActions

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.januscole.achieve.components.PointsHeader

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HealthyActions () {
    val pagerState = rememberPagerState(initialPage = 0)
    val list = listOf(
        HealthyActionScreen.ActiveTab(title = "Active", screen = {ActiveHealthyActions()}),
        HealthyActionScreen.CompletedTab(title = "Completed", screen = {CompletedHealthyActions()}))

    Box(
        modifier = Modifier.fillMaxSize().padding(10.dp, 0.dp),
        contentAlignment = Alignment.Center
    ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(Alignment.CenterHorizontally)) {
                PointsHeader(screenName = "Healthy Actions")
                Text(
                    text = "Healthy Actions",
                    style = TextStyle(
                       fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(0.dp, 5.dp)
                )
                HealthyActionsTabsHeader(list, pagerState)
                HealthyActionTabsContent(list, pagerState)
            }
    }
}
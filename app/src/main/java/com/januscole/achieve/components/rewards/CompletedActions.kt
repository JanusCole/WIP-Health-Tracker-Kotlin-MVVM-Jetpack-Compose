package com.januscole.achieve.components.rewards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.januscole.achieve.components.PointsHeader

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CompletedActions () {
    val pagerState = rememberPagerState(initialPage = 0)
    val list = listOf(
        CompletedActionScreen.AllTab(title = "All", screen = {AllCompletedActions()}),
        CompletedActionScreen.CalorieActivitiesTab(title = "Activity", screen = {CompletedCalorieActions()}),
        CompletedActionScreen.HealthyActivitiesTab(title = "Healthy", screen = {CompletedHealthyActions()})
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(Alignment.CenterHorizontally)) {
                PointsHeader(screenName = "Rewards")
                Text(
                    text = "Rewards",
                    style = TextStyle(
                       fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                CompletedActionsTabsHeader(list, pagerState)
                CompletedActionTabsContent(list, pagerState)
            }
    }
}
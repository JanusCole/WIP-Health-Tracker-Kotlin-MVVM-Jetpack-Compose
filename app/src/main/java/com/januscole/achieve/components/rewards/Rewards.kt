package com.januscole.achieve.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.januscole.achieve.R
import com.januscole.achieve.components.rewards.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Rewards () {
    val pagerState = rememberPagerState(initialPage = 0)
    val list = listOf(
        CompletedActionScreen.AllTab(title = "All", screen = {AllCompletedActions()}),
        CompletedActionScreen.CalorieActivitiesTab(title = "Activity", screen = {CompletedCalorieActions()}),
        CompletedActionScreen.HealthyActivitiesTab(title = "Healthy", screen = {CompletedHealthyActions()})
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Column(
                modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(Alignment.CenterHorizontally)) {
                // PointsHeader(screenName = "Rewards")
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp, 15.dp)
                ) {
                    Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    colorFilter = ColorFilter.tint(colorResource(R.color.cvs_brand_red)),
                    contentDescription = "Weekly Points"
                )
                    Text(
                        text = "Points history",
                        modifier = Modifier
                            .padding(5.dp, 0.dp),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                CompletedActionsTabsHeader(list, pagerState)
                CompletedActionTabsContent(list, pagerState)
            }
    }
}
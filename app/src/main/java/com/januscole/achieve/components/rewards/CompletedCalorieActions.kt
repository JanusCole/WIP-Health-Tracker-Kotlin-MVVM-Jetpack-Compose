package com.januscole.achieve.components.rewards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.januscole.achieve.data.model.ActivityStatus
import com.januscole.achieve.data.model.ActivityType
import com.januscole.achieve.ui.HealthyActionsViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CompletedCalorieActions () {

    val viewModel: HealthyActionsViewModel = viewModel()
    val healthyActivities by remember { viewModel.getHealthyActivitiesList() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 5.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            modifier = Modifier
                .background(Color.White)
                .padding(5.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            LazyColumn(
            ) {
                items(healthyActivities.filter {
                    (it.type.equals(ActivityType.CALORIE_GOAL)) && (it.status.equals(
                        ActivityStatus.COMPLETED))
                }) { activity ->
                    CompletedActivityCard(healthyActivity = activity, viewModel)
                }
            }
/*            healthyActivities.forEach {
                if ((it.type.equals(ActivityType.HEALTHY_ACTIVITY)) && (it.status.equals(
                        ActivityStatus.ACTIVE
                    ))
                ) {
                    HealthyActivityCard(healthyActivity = it, viewModel)
                }
            }*/
        }
    }
}
package com.januscole.achieve.components.healthyActions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ActiveHealthyActions () {

    val viewModel: HealthyActionsViewModel = viewModel()
    val healthyActivities by remember { viewModel.getActiveHealthyActivitiesList() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 5.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            modifier = Modifier
                .background(Color.White)
                .padding(0.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        )
        {
            LazyColumn(
            ) {
                items(healthyActivities.filter {
                    (it.type.equals(ActivityType.HEALTHY_ACTIVITY)) && (it.status.equals(ActivityStatus.ACTIVE))
                }) { activity ->
                    HealthyActivityCard(healthyActivity = activity, viewModel)
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


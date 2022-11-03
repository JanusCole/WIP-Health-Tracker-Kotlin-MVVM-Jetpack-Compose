package com.januscole.achieve.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.januscole.achieve.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.januscole.achieve.ui.HealthyActionsViewModel
import com.januscole.achieve.ui.HealthyActivitiesViewModel
import com.januscole.achieve.ui.PointsViewModel

@Preview
@Composable
fun PointsHeader (screenName: String = "Screen Name") {

    val viewModel: PointsViewModel = viewModel()
    val activitiesViewModel: HealthyActionsViewModel = viewModel()

    val points by remember { activitiesViewModel.getCompletedPoints() }
    val amountOwed by remember { viewModel.getAmountOwed() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
        ) {
            Row(
            ) {
                Text(
                    text = String
                        .format("%,d", points),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.light_points_text),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Text(
                    text = " POINTS",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
        Column (
        ) {
            Row(
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_watch_24),
                    contentDescription = screenName
                )
                Text(
                    text = String
                        .format("$%.2f OWED", amountOwed),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}
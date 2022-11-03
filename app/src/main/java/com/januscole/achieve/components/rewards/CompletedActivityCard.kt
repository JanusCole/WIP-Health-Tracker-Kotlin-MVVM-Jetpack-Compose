package com.januscole.achieve.components.rewards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.januscole.achieve.R
import com.januscole.achieve.data.model.HealthyActivity
import com.januscole.achieve.ui.HealthyActionsViewModel

@Composable
fun CompletedActivityCard(healthyActivity: HealthyActivity, healthyActivitiesViewModel: HealthyActionsViewModel) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
            )
            {
                Text(
                    text = healthyActivity.dateCompleted.toString().substringBefore(' '),
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
                Text(
                    text = healthyActivity.title,
                    modifier = Modifier.padding(5.dp, 0.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterVertically)
            )
            {
                Text(
                    text = "+" + healthyActivity.points.toString() + " pts.",
                    color = colorResource(R.color.light_points_text),
                    modifier = Modifier
                        .padding(5.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
}
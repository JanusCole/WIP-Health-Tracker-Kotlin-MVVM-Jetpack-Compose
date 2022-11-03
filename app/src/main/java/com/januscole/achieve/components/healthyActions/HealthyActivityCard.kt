package com.januscole.achieve.components.healthyActions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.januscole.achieve.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.januscole.achieve.data.model.ActivityStatus
import com.januscole.achieve.data.model.HealthyActivity
import com.januscole.achieve.ui.HealthyActionsViewModel

@Composable
fun HealthyActivityCard(healthyActivity: HealthyActivity, healthyActivitiesViewModel: HealthyActionsViewModel) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 15.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.light_gray_background))
                .padding(5.dp)
        )
        {
            Text(
                text = healthyActivity.title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = healthyActivity.description,
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )
            if (healthyActivity.status.equals(ActivityStatus.ACTIVE)) {
                Text(
                    text = "Complete Activity",
                    color = colorResource(id = R.color.cvs_brand_red),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .clickable(
                            onClickLabel = "Complete Activity"
                        ) {
                            healthyActivitiesViewModel.completeActivity(healthyActivity.activityId)
                        }
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (healthyActivity.status.equals(ActivityStatus.ACTIVE)) {
                    Text(
                        text = "Expires on " + healthyActivity.expirationDate.dayOfWeek.name,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(5.dp)
                    )
                } else {
                    Text(
                        text = "Completed " + healthyActivity.dateCompleted.toString().substringBefore(' '),
                        color = Color.DarkGray,
                        modifier = Modifier.padding(5.dp)
                    )
                }
                Row () {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_stars_24),
                        colorFilter = ColorFilter.tint(colorResource(R.color.light_points_text)),
                        contentDescription = "Weekly Points"
                    )
                    Text(
                        text = healthyActivity.points.toString() + " PTS",
                        color = colorResource(id = R.color.light_points_text),
                        modifier = Modifier.padding(5.dp).align(Alignment.Top)
                    )
                }
            }
        }
    }
}
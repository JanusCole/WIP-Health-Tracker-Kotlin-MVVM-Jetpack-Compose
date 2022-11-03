package com.januscole.achieve.components

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.januscole.achieve.DAILY_CALORIE_GOAL
import com.januscole.achieve.R
import com.januscole.achieve.ui.CaloriesViewModel
import java.time.LocalDate

var tempCalories = 600
@Composable
fun Activity () {

    val viewModel: CaloriesViewModel = viewModel()

    val currentDailyCalories by remember {viewModel.getCurrentDailyCalories()}
    val weeklyCalories by remember {viewModel.getWeeklyCalories()}

    var boxHeight by remember { mutableStateOf(currentDailyCalories.dp) }

    var accumulator = 0
    weeklyCalories.forEach {
        accumulator = accumulator + it.calories
    }
    var weeklyPointTotal = accumulator

    val animatedHeight by animateDpAsState(
        targetValue = boxHeight,
        tween (
            durationMillis = 2000
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            PointsHeader(screenName = "Activity")
            Text(text = "Activity",
                    fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(colorResource(id = R.color.light_purple))
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(animatedHeight)
                        //.background(colorResource(id = R.color.start_purple_gradient))
                        .align(Alignment.BottomCenter)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.start_purple_gradient),
                                    colorResource(id = R.color.end_purple_gradient)
                                )
                            )
                        )
                ) {

                }
                Column (
                    modifier = Modifier
                        .padding(25.dp)
                        .align(Alignment.CenterStart)
                        .fillMaxWidth()
                ) {
                    Row(
                    ) {
                        Text(
                            text = currentDailyCalories.toString(),
                            fontSize = 100.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.Bottom)
                        )
                        Text(
                            text = "CAL",
                            fontSize = 60.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.Bottom)
                                .padding(5.dp)
                        )
                    }
                    Text(
                        text = stringResource(R.string.daily_calorie_label, DAILY_CALORIE_GOAL),
                        textAlign = TextAlign.Start,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = stringResource(
                            R.string.daily_calorie_goal_description,
                            (DAILY_CALORIE_GOAL - currentDailyCalories)
                        ),
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

            }
            Button(
                onClick = {
                    boxHeight += 75.dp
                    viewModel.updateCalories(LocalDate.now(), currentDailyCalories + 100)
                },
                //colors = ButtonDefaults.buttonColors(colorResource(id = R.color.start_purple_gradient)),
                colors = ButtonDefaults.buttonColors(Color.Transparent, Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    //.background(colorResource(id = R.color.start_purple_gradient))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(id = R.color.start_purple_gradient),
                                colorResource(id = R.color.end_purple_gradient)
                            )
                        )
                    )
            ) {
                Text (text = "+100 Calories", color = Color.White)
            }
            Column (
                modifier = Modifier.fillMaxWidth()
                    .background(colorResource(id = R.color.light_purple))
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp, 0.dp, 0.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(R.string.this_week_label),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(10.dp, 0.dp)
                    )
                    Text(
                        text = stringResource(R.string.activity_history),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = colorResource(id = R.color.cvs_brand_red),
                        modifier = Modifier.padding(10.dp, 0.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.goals_achieved_text),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(10.dp, 0.dp)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 5.dp)

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.85F),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val circleColor = colorResource(R.color.cvs_brand_red)
                    weeklyCalories.forEach {
                        Column(
                            modifier = Modifier.padding(5.dp, 15.dp)
                        ) {
                            Column (
                                modifier = Modifier
                                    .padding(2.dp, 0.dp)

                            ) {
                                Canvas(
                                    modifier = Modifier
                                        .size(20.dp, 20.dp)
                                ) {
                                    val canvasWidth = 20F
                                    val canvasHeight = 20F

                                    drawCircle(
                                        color = circleColor,
                                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                                        radius = size.minDimension / 2,
                                        style = Stroke(4F)
                                    )
                                    drawArc(
                                        color = circleColor,
                                        startAngle = 0f,
                                        sweepAngle = 180f,
                                        useCenter = true,
/*                                    size = Size(
                                        (calculateWidth(
                                            size.width,
                                            tempCalories,
                                            DAILY_CALORIE_GOAL
                                        )),
                                        calculateHeight(
                                            size.height,
                                            tempCalories,
                                            DAILY_CALORIE_GOAL
                                        )
                                    ),*/
                                        //size = Size((size.width * 1.0f), size.height * 0.5f),
                                        size = Size((size.width * 1.0f), size.height * 0.5f),
                                        topLeft = Offset(
                                            x = -canvasWidth + 2.0F,
                                            y = -canvasHeight + (size.height * 0.5f)
                                        )
/*                                    topLeft = Offset(
                                        x = -canvasWidth + 2.0F,
                                        y = getHeight(
                                            -canvasHeight,
                                            size.height,
                                            tempCalories,
                                            DAILY_CALORIE_GOAL,
                                            it.date.dayOfWeek.name
                                        )*/
                                    )
                                }
                            }
                            Text(
                                text = it.date.dayOfWeek.name.substring(0, 1),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Start)
                            )
                        }
                    }
                }
                    Column (
                        //modifier = Modifier.align(Alignment.CenterVertically)
                            ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_stars_24),
                            colorFilter = ColorFilter.tint(Color.DarkGray),
                            contentDescription = "Weekly Points",
                            modifier = Modifier.fillMaxWidth().padding(0.dp, 7.dp, 0.dp, 0.dp)
                        )
                        Text(
                            text = weeklyPointTotal.toString() + " PTS",
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            modifier = Modifier.fillMaxWidth().padding(0.dp, 7.dp, 0.dp, 0.dp)
                        )
                    }
                }
            }
            }
        }
}

fun getHeight(canvasHeight: Float, sizeHeight: Float, currentCalories: Int, dailyCalories: Int, name: String): Float {
    Log.d("XXXXX", "Return Height1 " + sizeHeight + " " + currentCalories + " " + dailyCalories + " " + canvasHeight + " = " + sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat()))
    val thing = canvasHeight + ((sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat())))
    Log.d("XXXXX", "Return Height2 " + canvasHeight + " = " + thing + " " + name)
    Log.d("XXXXX", "Return Height2 " + 0.5F * ((sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat()))) + " " + name)

    tempCalories = tempCalories - 100
    if (tempCalories == 0) tempCalories = 600
    Log.d("XXXXXX", "TEMP " + tempCalories )
    return 0.5F * ((sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat())))
    //return canvasHeight + ((sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat())))
}

fun calculateWidth(sizeHeight: Float, currentCalories: Int, dailyCalories: Int): Float {
    Log.d("XXXXX", "Width " + sizeHeight + " " + currentCalories + " " + dailyCalories + " = " + sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat()))
    return sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat())
}

fun calculateHeight(sizeHeight: Float, currentCalories: Int, dailyCalories: Int): Float {
    Log.d("XXXXX", "Height " + sizeHeight + " " + currentCalories + " " + dailyCalories + " = " + sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat()))
    return sizeHeight * (currentCalories.toFloat() / dailyCalories.toFloat())
}
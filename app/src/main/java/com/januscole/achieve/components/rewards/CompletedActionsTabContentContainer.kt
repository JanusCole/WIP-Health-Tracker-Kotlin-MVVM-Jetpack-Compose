package com.januscole.achieve.components.rewards

import androidx.compose.runtime.Composable

sealed class CompletedActionScreen (val title: String, val screen: @Composable ()->Unit) {
    class AllTab constructor(title: String, screen: @Composable () -> Unit) : CompletedActionScreen(title,
        screen
    )
    class HealthyActivitiesTab constructor(title: String, screen: @Composable () -> Unit) : CompletedActionScreen(title,
        screen
    )
    class CalorieActivitiesTab constructor(title: String, screen: @Composable () -> Unit) : CompletedActionScreen(title,
        screen
    )
}
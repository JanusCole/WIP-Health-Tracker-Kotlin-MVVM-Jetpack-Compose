package com.januscole.achieve.components.healthyActions

import androidx.compose.runtime.Composable

sealed class HealthyActionScreen (val title: String, val screen: @Composable ()->Unit) {
    class ActiveTab constructor(title: String, screen: @Composable () -> Unit) : HealthyActionScreen(title,
        screen
    )
    class CompletedTab constructor(title: String, screen: @Composable () -> Unit) : HealthyActionScreen(title,
        screen
    )
}
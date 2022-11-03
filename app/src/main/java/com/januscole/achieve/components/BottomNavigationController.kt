package com.januscole.achieve.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.januscole.achieve.components.healthyActions.HealthyActions

@Composable
fun TabsNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "activities") {
        composable("activities") {
            Activity()
        }
        composable("healthyActions") {
            HealthyActions()
        }
        composable("rewards") {
            Rewards()
        }
    }
}
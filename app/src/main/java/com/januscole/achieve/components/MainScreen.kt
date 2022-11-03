package com.januscole.achieve.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.januscole.achieve.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun BottomNavigationScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavigationButton(
                        name = "Activities",
                        route = "activities",
                        icon = R.drawable.ic_baseline_directions_run_24
                    ),
                    BottomNavigationButton(
                        name = "Healthy Actions",
                        route = "healthyActions",
                        icon = R.drawable.ic_baseline_check_circle_24
                    ),
                    BottomNavigationButton(
                        name = "Rewards",
                        route = "rewards",
                        icon = R.drawable.ic_baseline_card_giftcard_24
                    ),
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        TabsNavigation(navController = navController)
    }
}
package com.example.booker

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booker.screens.*

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen.route
    ) {
        composable(
            route = Screen.FirstScreen.route
        ) {
            FirstScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.MainScreen.route
        ) {
            MainScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.DaySelectorScreen.route
        ) {
            DaySelectorScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.TurnSelectorScreen.route
        ) {
            TurnSelectorScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.ConfirmationScreen.route
        ) {
            ConfirmationScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.ReservationScreen.route
        ) {
            ReservationScreen(navController)
        }
        composable(
            route = com.example.booker.Screen.RecapScreen.route
        ) {
            RecapScreen(navController)
        }

    }

}
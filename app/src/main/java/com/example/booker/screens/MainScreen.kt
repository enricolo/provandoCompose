package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.Screen


@Composable
fun MainScreen(navController: NavController){

    Column(

        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.ReservationScreen.route)
            },
            fontSize = MaterialTheme.typography.h3.fontSize,
            text = "ReservationScreen ")
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.DaySelectorScreen.route)
            },
            fontSize = MaterialTheme.typography.h3.fontSize,
            text = "DaySelectorScreen ")

    }


}
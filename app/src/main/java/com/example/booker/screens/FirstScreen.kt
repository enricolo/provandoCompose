package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.Screen


@Composable
fun FirstScreen(navController: NavController){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.LoginScreen.route)
            },
            fontSize = MaterialTheme.typography.h3.fontSize,
            text = "FirstScreen ")

        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.RegistrationScreen.route)
            },
            fontSize = MaterialTheme.typography.h3.fontSize,
            text = "FirstScreen ")

    }

}
package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.Screen

@Composable
fun TurnSelectorScreen(navController: NavController){

    Box(

        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.ConfirmationScreen.route)
            },
            fontSize = MaterialTheme.typography.h3.fontSize,
            text = "TurnSelectorScreen ")

    }

}
package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.CustomItem
import com.example.booker.Screen
import com.example.booker.model.repository.ReservationRepository

@Composable
fun ReservationScreen(navController: NavController){

    val reservationRepository = ReservationRepository()
    val getAllData = reservationRepository.getAllData()

    Column() {
        Box(

            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter

        ){
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(route = Screen.LoginScreen.route)
                },
                fontSize = MaterialTheme.typography.h3.fontSize,
                text = "ReservationScreen ")

        }

        LazyColumn(){
            items(items = getAllData){reservation ->
                CustomItem(reservation = reservation)
            }
        }
    }


}
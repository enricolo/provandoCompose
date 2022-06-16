package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.ReservationItem
import com.example.booker.Screen
import com.example.booker.repository.ReservationRepository

@Composable
fun ReservationScreen(navController: NavController){

    val reservationRepository = ReservationRepository()
    val getAllData = reservationRepository.getAllData()

    var count by remember{
        mutableStateOf(1)
    }

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
                ReservationItem(reservation = reservation)
            }
        }
    }


}
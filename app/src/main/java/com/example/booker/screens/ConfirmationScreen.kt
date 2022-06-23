package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.ReservationItem
import com.example.booker.Screen
import com.example.booker.data.User
import com.example.booker.data.UserReservation
import com.example.booker.repository.ReservationRepository
import com.example.booker.viewModel.LoginScreenViewModel

@Composable
fun ConfirmationScreen(navController: NavController){

    val viewModel = LoginScreenViewModel()

    val reservationRepository = ReservationRepository()
    val getAllData = reservationRepository.getAllData()
    Column(
        Modifier
            .fillMaxSize(1f)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                fontSize = MaterialTheme.typography.h4.fontSize,
                text = User.email)
            Text(
                fontSize = MaterialTheme.typography.h4.fontSize,
                text = UserReservation.day)
            Text(
                fontSize = MaterialTheme.typography.h4.fontSize,
                text = UserReservation.turn)



        }

//        Text(
//            fontSize = MaterialTheme.typography.h5.fontSize,
//            text = "hanno già prenotato:")
        LazyColumn(
            Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
        ){
            items(items = getAllData){reservation ->
                ReservationItem(reservation = reservation)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ){
            Button(
                onClick = {
                    navController.navigate(route = Screen.RecapScreen.route)
                }) {
                Text(text = "conferma")
            }
        }




    }


}
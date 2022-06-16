package com.example.booker.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.ReservationItem
import com.example.booker.Screen
import com.example.booker.repository.ReservationRepository

//@OptIn(ExperimentalFoundationApi::class)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReservationScreen(navController: NavController){

    val reservationRepository = ReservationRepository()
    val getAllData = reservationRepository.getAllData()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
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

//        LazyColumn(
//            contentPadding = PaddingValues(all = 12.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ){
//            getAllData.forEach{
//                stickyHeader {
//                    Text(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.LightGray)
//                            .padding(12.dp),
//                        text = it.giorno
//                    )
//                }
//                items(getAllData.size-1) {
//                    Text(text = getAllData[it].nome)
//                }
//
//            }
    }


        }
    }
}
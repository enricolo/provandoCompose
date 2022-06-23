package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.Screen
import com.example.booker.data.UserReservation
import com.example.booker.model.Day
import com.example.booker.viewModel.DaySelectorScreenViewModel

@Composable
fun DaySelectorScreen(navController: NavController){

    val viewModel = DaySelectorScreenViewModel()

    viewModel.getDays()
    val days: List<Day> by viewModel.days.observeAsState(listOf(Day("", "")))



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
                modifier = Modifier
                    .clickable {

                        navController.navigate(route = Screen.TurnSelectorScreen.route)
                    },
                fontSize = MaterialTheme.typography.h3.fontSize,
                text = "DaySelectorScreen ")

        }

        LazyColumn(){
            items(items = days){
                Text(
                    modifier = Modifier.clickable {
                        UserReservation.day = it.day
                        navController.navigate(route = Screen.TurnSelectorScreen.route)
                    },
                    text = it.weekDay + " " + it.day,
                    fontSize = MaterialTheme.typography.h4.fontSize
                )
            }
        }
    }

}


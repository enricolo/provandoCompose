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
import com.example.booker.viewModel.DaySelectorScreenViewModel
import com.example.booker.viewModel.LoginScreenViewModel
import java.util.*

@Composable
fun DaySelectorScreen(navController: NavController){

    val viewModel = DaySelectorScreenViewModel()
//    val days = listOf<String>("lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7")
    viewModel.setDays()
    val days: List<String> by viewModel.days.observeAsState(listOf(""))

    val cal: Calendar = Calendar.getInstance()
    cal.add(Calendar.MONTH, 1) //add a month
    cal.set(Calendar.HOUR_OF_DAY, 23) //set hour to last hour
    cal.set(Calendar.MINUTE, 59) //set minutes to last minute
    cal.set(Calendar.SECOND, 59) //set seconds to last second
    cal.set(Calendar.MILLISECOND, 999) //set milliseconds to last millisecond


    val millis: Long = cal.timeInMillis



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
                        navController.navigate(route = Screen.TurnSelectorScreen.route)
                    },
                    text = it,
                    fontSize = MaterialTheme.typography.h4.fontSize
                )
            }
        }
    }

}


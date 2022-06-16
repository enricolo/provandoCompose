package com.example.booker.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.Screen

@Composable
fun DaySelectorScreen(navController: NavController){

    Column() {


        Box(

            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ){
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(route = Screen.TurnSelectorScreen.route)
                },
                fontSize = MaterialTheme.typography.h3.fontSize,
                text = "DaySelectorScreen ")

        }

        LazyColumn(){
            items(items = listOf<String>("lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7")){
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


package com.example.booker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.Screen
import kotlin.math.round

@Composable
fun TurnSelectorScreen(navController: NavController){

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Box(

            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                fontSize = MaterialTheme.typography.h3.fontSize,
                text = "TurnSelectorScreen ")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ,
            verticalArrangement = Arrangement.Center){
            items(items = listOf<String>("turno mattina", "turno pomeriggio", "turno notte")){turn ->
                Text(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(route = Screen.ConfirmationScreen.route)
                        }
                        .padding(15.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.Green),
                    text = turn,
                    fontSize = MaterialTheme.typography.h4.fontSize
                )
            }
        }
    }


}
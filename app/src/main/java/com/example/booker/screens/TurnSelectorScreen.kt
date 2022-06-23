package com.example.booker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.Screen
import com.example.booker.data.UserReservation
import com.example.booker.viewModel.TurnSelectorScreenViewModel

@Composable
fun TurnSelectorScreen(navController: NavController){

    val viewModel = TurnSelectorScreenViewModel()
    viewModel.getTurns()
    val turns: List<String> by viewModel.turns.observeAsState(listOf(""))

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
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
            items(items = turns){turn ->
                Text(
                    modifier = Modifier
                        .clickable {
                            UserReservation.turn = turn
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
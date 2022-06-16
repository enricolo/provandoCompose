package com.example.booker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.Screen


@Composable
fun LoginScreen(navController: NavController){

    var userTextFieldState by remember {
        mutableStateOf("")
    }
    var passwordTextFieldState by remember {
        mutableStateOf("")
    }

    var avviso by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        TextField(
            value = userTextFieldState,
            label = {
                Text("username")
            },
            onValueChange = {
                userTextFieldState = it
                avviso = ""
            },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = passwordTextFieldState,
            label = {
                Text("password")
            },
            onValueChange = {
                passwordTextFieldState = it
            },
            singleLine = true
        )

        Button(
            onClick = {
                if(userTextFieldState != ""){
                    navController.navigate(Screen.MainScreen.route)
                }
                avviso = "compila campi"
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "login")

        }
        if (avviso!= ""){
            Text(text = avviso)
        }

    }
}

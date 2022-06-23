package com.example.booker.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.booker.Password
import com.example.booker.Screen
import com.example.booker.UserName
import com.example.booker.data.User


@Composable
fun RegistrationScreen(navController: NavController){


    var userTextFieldState by remember {
        mutableStateOf("")
    }
    var passwordTextFieldState by remember {
        mutableStateOf("")
    }

    var nameTextFieldState by remember {
        mutableStateOf("")
    }
    var surnameTextFieldState by remember {
        mutableStateOf("")
    }
    var distanceTextFieldState by remember {
        mutableStateOf("")
    }

    var avviso by remember {
        mutableStateOf("")
    }


    Column(
        Modifier.fillMaxHeight()
            .fillMaxWidth(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        UserName(userName = userTextFieldState, label = "username", onUserNameChange = {userTextFieldState = it})

        Password(password = passwordTextFieldState, onPasswordChange = {passwordTextFieldState = it})

        UserName(userName = nameTextFieldState, label = "name", onUserNameChange = {nameTextFieldState = it})

        UserName(userName = surnameTextFieldState, label = "surname", onUserNameChange = {surnameTextFieldState = it})

        UserName(userName = distanceTextFieldState, label = "distanza", onUserNameChange = {distanceTextFieldState = it})


        Button(
            onClick = {
//                if(userTextFieldState == ""){
//                    avviso = "compila username"
//
//                }else if(passwordTextFieldState == ""){
//                    avviso += "compila password"
//                }
//                else {
                User.email = userTextFieldState
                navController.navigate(Screen.MainScreen.route)
//                }
            },
            modifier = Modifier

                .align(Alignment.End)
        ) {
            Text(text = "login")

        }
        if (avviso!= ""){
            Text(text = avviso)
        }
    }

}

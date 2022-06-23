package com.example.booker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.Password
import com.example.booker.Screen
import com.example.booker.UserName
import com.example.booker.data.User
import com.example.booker.model.Reservation
import com.example.booker.model.loginResponse
import com.example.booker.viewModel.LoginScreenViewModel


@Composable
fun LoginScreen(navController: NavController){



    val viewModel = LoginScreenViewModel()

    var userTextFieldState by remember {
        mutableStateOf("")
    }
    var passwordTextFieldState by remember {
        mutableStateOf("")
    }

    var loginstato by remember {
        mutableStateOf(false)
    }

    var loginStato by remember {
        mutableStateOf(false)
    }

    val loginState: Boolean by viewModel.loginResponse.observeAsState(false)

    var avviso by remember {
        mutableStateOf("")
    }

    Column() {

    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        UserName(userName = userTextFieldState,label = "username", onUserNameChange = {userTextFieldState = it})

        Spacer(modifier = Modifier.height(20.dp))

        Password(password = passwordTextFieldState, onPasswordChange = {passwordTextFieldState = it})

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
//                if(userTextFieldState == ""){
//                    avviso = "compila username"
//
//                }else if(passwordTextFieldState == ""){
//                    avviso += "compila password"
//                }
//                else {

                viewModel.login(userTextFieldState, passwordTextFieldState)


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

        if(loginState && ! loginStato){ //TODO guarda come fare sta cosa senza il check
            Text(text = "trasferisco")

            navController.navigate(Screen.MainScreen.route)
            loginStato = true

        }

    }

}


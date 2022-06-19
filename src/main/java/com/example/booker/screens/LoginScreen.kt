package com.example.booker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.booker.Screen
import com.example.booker.data.User
import com.example.booker.viewModel.LoginScreenViewModel


@Composable
fun LoginScreen(navController: NavController){

    val viewModel = LoginScreenViewModel()

//    val userName: String by viewModel.name.observeAsState("")

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
            .padding(30.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        UserName(userName = userTextFieldState, onUserNameChange = {userTextFieldState = it})

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
                User.username = userTextFieldState
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


@Composable
fun UserName(userName : String, onUserNameChange: (String) -> Unit){

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp)),
        value = userName,
        label = {
            Text("username")
        },

        onValueChange = onUserNameChange,
        singleLine = true
    )
}


@Composable
fun Password(password: String, onPasswordChange : (String) -> Unit){
//    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = password,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp)),
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        singleLine = true,
        placeholder = { Text("Password") },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
    )
}
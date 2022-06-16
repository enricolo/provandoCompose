package com.example.booker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

@Composable
fun Password() {

}

@Composable
fun Username() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    var userTextFieldState by remember {
        mutableStateOf("")
    }
    var passwordTextFieldState by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()

            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center
    ){
        TextField(
            value = userTextFieldState,
            label = {
                Text("username")
            },
            onValueChange = {
                userTextFieldState = it
            },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(50.dp))
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
    }


}
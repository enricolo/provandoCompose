package com.example.booker

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun UserName(userName : String, label : String,onUserNameChange: (String) -> Unit){

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp)),
        value = userName,
        label = {
            Text(label)
        },

        onValueChange = onUserNameChange,
        singleLine = true
    )
}



@Composable
fun Password(password: String, onPasswordChange : (String) -> Unit){

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
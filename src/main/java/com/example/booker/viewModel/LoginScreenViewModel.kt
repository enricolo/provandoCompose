package com.example.booker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booker.data.User

class LoginScreenViewModel: ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name


    fun onNameChanged(newName: String){
        _name.value = newName
    }

    fun login(user : String, password: String){

        User.username = user

    }

    fun register(user : String, password: String, distance : Int){

        User.username = user
        User.distance = distance

    }
}
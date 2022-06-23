package com.example.booker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booker.data.User
import com.example.booker.model.loginResponse
import com.example.moviematch.repository.Repository
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _loginResponse = MutableLiveData<Boolean>()

    val loginResponse: LiveData<Boolean> = _loginResponse


    fun login(email : String, password: String){

        User.email = email

        viewModelScope.launch  {
            try {
                val response = Repository().login(email, password)
//                val response = Repository().getReservations()
                if(response.isSuccessful) {
                    _loginResponse.value = response.body()?.response?.outcome

                    Log.d("reservations", response.body().toString())
                }
                else{
                    Log.d("reservations", "sent but failed")
                    Log.d("reservations", response.errorBody().toString())
                    Log.d("reservations", response.code().toString())
                }
                Log.d("reservations", response.toString())
            } catch (e: Exception) {
                Log.e("reservations", e.message, e)
            }
        }



    }

    fun register(user : String, password: String, distance : Int){

        User.email = user
        User.distance = distance

    }
}
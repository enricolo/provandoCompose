package com.example.booker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booker.data.User
import com.example.booker.model.Reservation
import com.example.moviematch.repository.Repository
import kotlinx.coroutines.launch

class ReservationScreenViewModel: ViewModel() {
    private val _reservations = MutableLiveData<List<Reservation>>()

    val reservations: LiveData<List<Reservation>> = _reservations

    fun getReservations() {

        viewModelScope.launch  {
            try {
                val response = Repository().getReservations(User.email)
//                val response = Repository().getReservations()
                if(response.isSuccessful) {
                    _reservations.value = response.body()?.response

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
}
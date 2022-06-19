package com.example.booker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booker.data.User
import com.example.booker.model.GetReservationResponse
import com.example.booker.model.Reservation
import com.example.booker.repository.ReservationRepository
import com.example.moviematch.repository.Repository
import kotlinx.coroutines.launch

class ReservationScreenViewModel: ViewModel() {
    private val _reservationRepository = ReservationRepository()
    private val _reservations = MutableLiveData<List<Reservation>>()
    private val _getReservationResponse = MutableLiveData<GetReservationResponse>()

    val reservations: LiveData<List<Reservation>> = _reservations
    val getReservationResponse: LiveData<GetReservationResponse> = _getReservationResponse

    fun setReservations(){
        _reservations.value = _reservationRepository.getAllData()
    }

    fun getReservations() {
        viewModelScope.launch  {
            try {
//                val response = Repository().getReservations(User.username)
                val response = Repository().getReservations("carletto")
                if(response.isSuccessful) {
                    _getReservationResponse.value = response.body()



                    Log.d("setGenre", response.body().toString())
                }
                else{
                    Log.d("setGenre", "sent but failed")
                    Log.d("setGenre", response.errorBody().toString())
                    Log.d("setGenre", response.code().toString())
                }
                Log.d("setGenre", response.toString())
            } catch (e: Exception) {
                Log.e("setGenre", e.message, e)
            }
        }
    }
}
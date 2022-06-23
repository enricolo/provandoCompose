package com.example.booker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviematch.repository.Repository
import kotlinx.coroutines.launch

class TurnSelectorScreenViewModel: ViewModel() {
    private val _turns = MutableLiveData<List<String>>()
    val turns: LiveData<List<String>> = _turns

//    fun setTurns(){
//        _turns.value = listOf<String>("turno mattina", "turno pomeriggio", "turno notte")
//    }

    fun getTurns() {
        viewModelScope.launch {
            try {
                val response = Repository().getTurns()

                if (response.isSuccessful) {
                    _turns.value = response.body()?.response

                    Log.d("reservations", response.body().toString())
                } else {
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
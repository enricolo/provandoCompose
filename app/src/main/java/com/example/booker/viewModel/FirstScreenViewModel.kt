package com.example.booker.viewModel

import android.content.res.Resources
import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booker.R
import com.example.booker.model.Day
import com.example.booker.model.GetTurnsResponse
import com.example.moviematch.repository.Repository
import kotlinx.coroutines.launch
import java.util.*

class FirstScreenViewModel: ViewModel() {



    private val _version = MutableLiveData<List<String>>()
    val version: LiveData<List<String>> = _version


    fun getVersion() {

        viewModelScope.launch {
            try {
                val response = Repository().getVersion("0.7")//TODO cambia con resource

                if (response.isSuccessful) {
                    _version.value = response.body()?.response

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

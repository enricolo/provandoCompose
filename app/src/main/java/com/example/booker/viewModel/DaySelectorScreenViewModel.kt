package com.example.booker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booker.model.Day
import com.example.moviematch.repository.Repository
import kotlinx.coroutines.launch
import java.util.*


class DaySelectorScreenViewModel: ViewModel() {

    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days

//    fun setDays(){
//        _days.value = listOf<String>("lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7")
//    }

    fun getDays() {

        val calendar: Calendar = Calendar.getInstance()

        val minDate = calendar.timeInMillis

        calendar.add(Calendar.MONTH, 1) //add a month
        calendar.set(Calendar.HOUR_OF_DAY, 23) //set hour to last hour
        calendar.set(Calendar.MINUTE, 59) //set minutes to last minute
        calendar.set(Calendar.SECOND, 59) //set seconds to last second
        calendar.set(Calendar.MILLISECOND, 999) //set milliseconds to last millisecond

        val maxDate = calendar.timeInMillis


        viewModelScope.launch {
            try {
                val response = Repository().getDays(minDate, maxDate)

                if (response.isSuccessful) {
                    _days.value = response.body()?.response

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
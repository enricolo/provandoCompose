package com.example.booker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DaySelectorScreenViewModel: ViewModel() {

    private val _days = MutableLiveData<List<String>>()
    val days: LiveData<List<String>> = _days

    fun setDays(){
        _days.value = listOf<String>("lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7","lun 1", "mar2", "mer3","gio 4", "ven 5", "sab 6","dom 7")
    }
}
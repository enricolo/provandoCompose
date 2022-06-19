package com.example.booker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TurnSelectorScreenViewModel: ViewModel() {
    private val _turns = MutableLiveData<List<String>>()
    val turns: LiveData<List<String>> = _turns

    fun setTurns(){
        _turns.value = listOf<String>("turno mattina", "turno pomeriggio", "turno notte")
    }
}
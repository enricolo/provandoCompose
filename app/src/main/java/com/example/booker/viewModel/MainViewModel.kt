package com.example.moviematch.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.moviematch.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository): ViewModel() {

    val setStringResponse: MutableLiveData<String> = MutableLiveData()


//    fun setNewRoom() {
//        viewModelScope.launch  {
//            try {
//                val response = repository.setNewRoom("User.username")
//                if(response.isSuccessful) {
//                    setNewRoomResponse.value = response.body()
//                    if (response.body() != null){
//                        User.roomId = response.body()!!.response.roomId
//                        User.userId = response.body()!!.response.userId
//                    }
//
//                    Log.d("setNewRoom", response.body().toString())
//                }
//                else{
//                    Log.d("setNewRoom", "sent but failed")
//                    Log.d("setNewRoom", response.errorBody().toString())
//                    Log.d("setNewRoom", response.code().toString())
//                }
//                Log.d("setNewRoom", response.toString())
//            } catch (e: Exception) {
//                Log.e("setNewRoom", e.message, e)
//            }
//        }
//    }
//
//    fun enterRoom() {
//        viewModelScope.launch {
//            try {
//                val response = repository.setRoom(User.username, User.roomId)
//                if(response.isSuccessful) {
//                    enterRoomResponse.value = response.body()
//                    if (response.body() != null){
//                        User.userId = response.body()!!.response.userId
//                    }
//                    Log.d("enterRoom", response.body().toString())
//                }
//                else{
//                    Log.d("enterRoom", "sent but failed")
//                    Log.d("enterRoom", response.errorBody().toString())
//                    Log.d("enterRoom", response.code().toString())
//                }
//                Log.d("enterRoom", response.toString())
//            } catch (e: Exception) {
//                Log.e("enterRoom", e.message, e)
//            }
//        }
//    }
//
//    fun setGenre() {
//        viewModelScope.launch  {
//            try {
//                val response = repository.setGenre(User.roomId, excludedGenresList)
//                if(response.isSuccessful) {
//                    setGenreResponse.value = response.body()
//                    Log.d("setGenre", response.body().toString())
//                }
//                else{
//                    Log.d("setGenre", "sent but failed")
//                    Log.d("setGenre", response.errorBody().toString())
//                    Log.d("setGenre", response.code().toString())
//                }
//                Log.d("setGenre", response.toString())
//            } catch (e: Exception) {
//                Log.e("setGenre", e.message, e)
//            }
//        }
//    }
//
//    fun setReady() {
//        viewModelScope.launch  {
//            try {
//                val response = repository.setReady(User.userId, User.roomId)
////                if(response.isSuccessful) {
////                    setReadyResponse.value = response.body()
////                    Log.d("setReady", response.body().toString())
////                }
////                else{
////                    Log.d("setReady", "sent but failed")
////                    Log.d("setReady", response.errorBody().toString())
////                    Log.d("setReady", response.code().toString())
////                }
////                Log.d("setReady", response.toString())
//            } catch (e: Exception) {
//                Log.e("setReady", e.message, e)
//            }
//        }
//    }
//
//
//    fun isRoomReady() {
//        viewModelScope.launch  {
//            try {
//                val response = repository.isRoomReady(User.userId, User.roomId)
//                if(response.isSuccessful) {
//                    isRoomReadyResponse.value = response.body()
//                    Log.d("setGenre", response.body().toString())
//                }
//                else{
//                    Log.d("setGenre", "sent but failed")
//                    Log.d("setGenre", response.errorBody().toString())
//                    Log.d("setGenre", response.code().toString())
//                }
//                Log.d("setGenre", response.toString())
//            } catch (e: Exception) {
//                Log.e("setGenre", e.message, e)
//            }
//        }
//    }
//
//    fun getMovies() {
//
//        viewModelScope.launch  {
//            try {
//                val response = repository.getMovies(User.roomId)
//                if(response.isSuccessful) {
//                    getMoviesResponse.value = response.body()?.response
//                    curretMovieId = response.body()?.response?.get(0)?.id ?: ""
//                }
//                else{
//                    Log.d("getMovies", response.errorBody().toString())
//                    Log.d("getMovies", response.code().toString())
//                }
//            } catch (e: Exception) {
//                Log.e("getMovies", e.message, e)
//            }
//        }
//    }
//
//    fun addGenreFromList(genre: String){
//        excludedGenresList.add(genre)
//        Log.d("checkedList", excludedGenresList.toString())
//    }
//
//    fun removeGenreFromList(genre: String){
//        excludedGenresList.remove(genre)
//        Log.d("checkedList", excludedGenresList.toString())
//    }
//
//    fun isGenreInGenreList(genre: String): Boolean {
//        return genre in excludedGenresList
//    }
//
//
//
//    fun getGenres() {
//
//        viewModelScope.launch {
//            try {
//                val response = repository.getGenres()
//                if(response.isSuccessful) {
//                    getGenresResponse.value = response.body()?.response
//                }
//                else{
//                    Log.d("getMovies", response.errorBody().toString())
//                    Log.d("getMovies", response.code().toString())
//                }
//            } catch (e: Exception) {
//                Log.e("getMovies", e.message, e)
//            }
//        }
//    }
//
//
//    fun rateMovie(liked: Boolean) {
//
//
//        viewModelScope.launch  {
//            try {
//                val response = repository.addLikedMovie(User.userId, User.roomId, curretMovieId, liked)
//                if(response.isSuccessful) {
//                    changeMovie()
//                    Log.d("addLikedMovie", response.body().toString())
//                }
//                else{
//                    Log.d("addLikedMovie", "sent but failed")
//                    Log.d("addLikedMovie", response.errorBody().toString())
//                    Log.d("addLikedMovie", response.code().toString())
//                }
//            } catch (e: Exception) {
//                Log.e("addLikedMovie", e.message, e)
//            }
//        }
//    }
//
//    fun findMatch() {
//        Log.d("testonegrosso1", "getMovies entrato")
//        viewModelScope.launch {
//
//
//            Log.d("testonegrosso1", "getMovies lanciato")
//            try {
//                Log.d("testonegrosso1", "siamo dentro")
//                val response = repository.findMatch(User.roomId)
//                Log.d("testonegrosso1", response.toString())
//                if(response.isSuccessful) {
//                    findMatchResponse.value = response.body()
//                }
//                else{
//                    Log.d("getMoviesVM", "sent but failed")
//                    Log.d("getMoviesVM", response.errorBody().toString())
//                    Log.d("getMoviesVM", response.code().toString())
//                }
//            } catch (e: Exception) {
//                Log.e("getMoviesVM", e.message, e)
//            }
//        }
//    }
//
//    fun matchedMovie() { //getMatchedMovies
//        Log.d("testonegrosso1", "matchedMovie entrato")
//        viewModelScope.launch()  {
//
//            Log.d("testonegrosso1", "matchedMovie lanciato")
//            try {
//                Log.d("testonegrosso1", "siamo dentro")
//                val response = repository.getMatchedMovies(User.roomId)
//                Log.d("testonegrosso1", response.toString())
//                if(response.isSuccessful) {
//                    matchedMovieResponse.value = response.body()
//                    Log.d("testonegrosso1", response.body().toString())
//                }
//                else{
//                    Log.d("getMoviesVM", "sent but failed")
//                    Log.d("getMoviesVM", response.errorBody().toString())
//                    Log.d("getMoviesVM", response.code().toString())
//                }
//            } catch (e: Exception) {
//                Log.e("getMoviesVM", e.message, e)
//            }
//        }
//    }
//
//    fun changeMovie() {
//        val list = getMoviesResponse.value
//        if (list != null && list.size > 0){
//            list.removeAt(0)
//            curretMovieId = list[0].id
//        }
//
//        getMoviesResponse.value = list
//
//
//    }


}

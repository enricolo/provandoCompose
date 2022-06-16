package com.example.moviematch.repository

import com.example.moviematch.api.RetrofitInstance
import retrofit2.Response

class Repository {



    suspend fun createUser(username:String): Response<String> {
        return RetrofitInstance.api.createUser(username)
    }

    suspend fun setNewRoom(username:String): Response<String> {
        return RetrofitInstance.api.setNewRoom(username)
    }

    suspend fun setRoom(username:String, roomId:Int): Response<String> {
        return RetrofitInstance.api.setRoom(username, roomId)
    }

    suspend fun getMovies(roomId: Int): Response<String> {
        return RetrofitInstance.api.getMovies(roomId)
    }

    suspend fun setGenre(roomId: Int, genre: List<String>): Response<String> {
        return RetrofitInstance.api.setGenre(roomId,genre)
    }

    suspend fun getGenres(): Response<String> {
        return RetrofitInstance.api.getGenres()
    }

//    suspend fun getPlatform(): Response<GetMovieResponse> {
//        return RetrofitInstance.api.getMovies()
//    }


    suspend fun addLikedMovie(userId: Long, roomId: Int, movieId: String, liked: Boolean): Response<String> {
        return RetrofitInstance.api.addLikedMovie(userId, roomId, movieId, liked)
    }

    suspend fun findMatch(roomId:Int): Response<String> {
        return RetrofitInstance.api.findMatch(roomId)
    }

    suspend fun getMatchedMovies(roomId:Int): Response<String> {
        return RetrofitInstance.api.getMatchedMovies(roomId)
    }

    suspend fun isRoomReady(userId: Long, roomId: Int): Response<String> {
        return RetrofitInstance.api.isRoomReady(userId, roomId)
    }

    suspend fun setReady(userId: Long, roomId: Int) {
        RetrofitInstance.api.setReady(userId, roomId)
    }


}

package com.example.moviematch.api


import retrofit2.Response
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("/createUser/?")
    suspend fun createUser(
        @Field("username") username: String
    ): Response<String>

    @GET("getMovies/?")
    suspend fun getMovies(
        @Query("roomId") roomId: Int
    ): Response<String>

    @FormUrlEncoded
    @POST("/createNewRoom/?")
    suspend fun setNewRoom(
        @Field("username") username: String
    ): Response<String>

    @FormUrlEncoded
    @POST("/enterRoom/?")
    suspend fun setRoom(
        @Field("username") username: String,
        @Field("roomId") roomId: Int
    ): Response<String>

    @FormUrlEncoded
    @POST("/setGenres/?")
    suspend fun setGenre(
        @Field("roomId") roomId: Int,
        @Field("genreList") genre: List<String>
    ): Response<String>

    @GET("getGenres/?")
    suspend fun getGenres(
//        @Query("roomId") roomId: Int
    ): Response<String>

    @FormUrlEncoded
    @POST("/rateMovie/?")
    suspend fun addLikedMovie(
        @Field("userId") userId: Long,
        @Field("roomId") roomId: Int,
        @Field("movieId") movieId: String,
        @Field("liked") liked: Boolean
    ): Response<String>


    @GET("/findMatch/?")
    suspend fun findMatch(
        @Query("roomId") roomId: Int
    ): Response<String>


    @GET("/getMatchedMovies/?")
    suspend fun getMatchedMovies(
        @Query("roomId") roomId: Int
    ): Response<String>

    @GET("/isRoomReady/?")
    suspend fun isRoomReady(
        @Query("userId") userId: Long,
        @Query("roomId") roomId: Int
    ): Response<String>

    @FormUrlEncoded
    @POST("/setReady/?")
    suspend fun setReady(
        @Field("userId") userId: Long,
        @Field("roomId") roomId: Int)
}

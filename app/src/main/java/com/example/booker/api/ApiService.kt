package com.example.moviematch.api


import com.example.booker.model.*
import retrofit2.Response
import retrofit2.http.*


interface ApiService {


    @GET("/isUpdated?")
    suspend fun isUpdated(
        @Query("version") version: String
    ): Response<GetTurnsResponse>

    @GET("/login?")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<loginResponse>


    @FormUrlEncoded
    @POST("/signUp?")
    suspend fun signUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("name") name: String,
        @Field("surname") surname: String,
        @Field("distance") distance: Int
    ): Response<String>

    @GET("/getDayReservations?")
    suspend fun getDayReservations(
        @Query("date") date : Long
    ): Response<GetReservationResponse>

    @GET("/getReservations?")
    suspend fun getReservations(
        @Query("email") email: String
    ): Response<GetReservationResponse>


    @GET("/getDays?")
    suspend fun getDays(
        @Query("minDate") minDate: Long,
        @Query("maxDate") maxDate: Long
    ): Response<GetDaysResponse>

    @GET("/getTurns?")
    suspend fun getTurns(
    ): Response<GetTurnsResponse>


    @FormUrlEncoded
    @POST("/setReservation?")
    suspend fun setReservation(
        @Field("email") email: String,
        @Field("date") name: String,
        @Field("turn") surname: String
    ): Response<String>


}

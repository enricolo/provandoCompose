package com.example.booker.model

data class GetReservationResponse(
    val code: Int,
    val response: List<Reservation>
)
package com.example.booker.model

data class loginResponse(
    val code: Int,
    val response: Response
){
    data class Response(
        val message: String,
        val outcome: Boolean
    )
}
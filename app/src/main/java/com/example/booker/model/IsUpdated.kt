package com.example.booker.model

data class IsUpdated(
    val code: Int,
    val response: Response

){
    data class Response(
        val blocking: Boolean,
        val isLastVersion: Boolean
    )
}


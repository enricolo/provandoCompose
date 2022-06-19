package com.example.booker.model
//
//data class Reservation (
//    val nome: String,
//    val giorno: String,
//    val stanza: String,
//    val distanza: Int
//)

data class Reservation (
    val stanza: String,
    val turno: String,
    val distanza: Int
)
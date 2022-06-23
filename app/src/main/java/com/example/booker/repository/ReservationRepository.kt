package com.example.booker.repository

import com.example.booker.model.Reservation

class ReservationRepository {
    fun getAllData(): List<Reservation>{
        return listOf(
            Reservation(
                turno = "mattina",
//                giorno = "martedì 14",
                stanza = "stanza1",
                distanza = 12
            ),
            Reservation(
                turno = "mattina",
//                nome = "marco",
//                giorno = "martedì 14",
                stanza = "stanza4",
                distanza = 12
            ),
            Reservation(
                turno = "mattina",
//                nome = "andrea",
//                giorno = "martedì 14",
                stanza = "stanza3",
                distanza = 12
            ),
            Reservation(
                turno = "mattina",
//                nome = "francesco",
//                giorno = "martedì 14",
                stanza = "stanza2",
                distanza = 12
            ),
            Reservation(
                turno = "mattina",
                stanza = "stanza8",
                distanza = 12
            ),
            Reservation(
                turno = "mattina",
                stanza = "stanza3",
                distanza = 12
            ),
            Reservation(
                turno = "mattina",
                stanza = "stanza7",
                distanza = 12
            ),
        )
    }
}
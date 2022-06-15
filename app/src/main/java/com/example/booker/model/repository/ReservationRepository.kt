package com.example.booker.model.repository

import com.example.booker.model.Reservation

class ReservationRepository {
    fun getAllData(): List<Reservation>{
        return listOf(
            Reservation(
                nome = "carlo",
                giorno = "martedì 14",
                stanza = "stanza1",
                distanza = 12
            ),
            Reservation(
                nome = "marco",
                giorno = "martedì 14",
                stanza = "stanza4",
                distanza = 12
            ),
            Reservation(
                nome = "andrea",
                giorno = "martedì 14",
                stanza = "stanza3",
                distanza = 12
            ),
            Reservation(
                nome = "francesco",
                giorno = "martedì 14",
                stanza = "stanza2",
                distanza = 12
            ),
            Reservation(
                nome = "francesca",
                giorno = "martedì 14",
                stanza = "stanza8",
                distanza = 12
            ),
            Reservation(
                nome = "maria",
                giorno = "martedì 14",
                stanza = "stanza3",
                distanza = 12
            ),
            Reservation(
                nome = "giancarla",
                giorno = "martedì 14",
                stanza = "stanza7",
                distanza = 12
            ),
        )
    }
}
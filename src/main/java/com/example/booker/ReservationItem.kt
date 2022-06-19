package com.example.booker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.booker.model.Reservation
import com.example.booker.repository.ReservationRepository

@Composable
fun ReservationItem(reservation: Reservation) {
    
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Green)
    ) {
        Text(
            text = reservation.giorno,
            fontSize = MaterialTheme.typography.h5.fontSize
        )
        Text(text = reservation.nome,
            fontSize = MaterialTheme.typography.h5.fontSize
        )
        Text(text = reservation.stanza,
            fontSize = MaterialTheme.typography.h5.fontSize
        )
        Text(text = reservation.distanza.toString(),
            fontSize = MaterialTheme.typography.h5.fontSize
        )

    }
    
}
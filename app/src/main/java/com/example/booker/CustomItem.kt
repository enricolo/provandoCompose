package com.example.booker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.booker.model.Reservation

@Composable
fun CustomItem(reservation: Reservation) {
    
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = reservation.giorno,
            fontSize = MaterialTheme.typography.h4.fontSize
        )
        Text(text = reservation.nome,
            fontSize = MaterialTheme.typography.h4.fontSize
        )
        Text(text = reservation.stanza,
            fontSize = MaterialTheme.typography.h4.fontSize
        )
        Text(text = reservation.distanza.toString(),
            fontSize = MaterialTheme.typography.h4.fontSize
        )

    }
    
}
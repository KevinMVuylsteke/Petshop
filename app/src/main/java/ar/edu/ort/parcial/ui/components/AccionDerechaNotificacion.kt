package ar.edu.ort.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AccionDerechaNotificacion(conFlecha: Boolean, imagenProducto: Int) {
    if (conFlecha) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Flecha",
            modifier = Modifier.size(30.dp)
        )
    } else {
        Image(
            painter = painterResource(id = imagenProducto),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
    }
}
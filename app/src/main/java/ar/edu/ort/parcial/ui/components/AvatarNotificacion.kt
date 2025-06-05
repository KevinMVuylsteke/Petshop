package ar.edu.ort.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun AvatarNotificacion(imagenRes: Int) {
    Image(
        painter = painterResource(id = imagenRes),
        contentDescription = null,
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
    )
}
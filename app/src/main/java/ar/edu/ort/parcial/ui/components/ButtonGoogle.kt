package ar.edu.ort.parcial.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.theme.Blue
import ar.edu.ort.parcial.ui.theme.GrayLight
import ar.edu.ort.parcial.ui.theme.Poppins

@Composable
fun GoogleCom() {
        Button(
        onClick = { /* Acción del botón */ },
        modifier = Modifier
            .width(157.dp)
            .height(60.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White // fondo blanco
        ),
        border = BorderStroke(1.dp, GrayLight), // borde gris claro
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_icon_png), // reemplazá con tu imagen
                contentDescription = "Google icon",
                modifier = Modifier
                    .size(25.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.google_component),
                color = Blue,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.81.sp,
                lineHeight = 14.81.sp,
                letterSpacing = 0.sp
            )
        }
    }
}


@Preview()
@Composable
fun GoogleComPreview() {
    GoogleCom()
}
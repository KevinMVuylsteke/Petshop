package ar.edu.ort.parcial.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.ui.theme.Poppins
import ar.edu.ort.parcial.ui.theme.White
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.ButtonCom
import ar.edu.ort.parcial.ui.theme.Gris

@Composable
fun Onboarding() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 80.dp, start = 30.dp, end = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.onboarding_title),
                fontSize = 40.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 56.sp, // 140% de 40sp = 56sp
                letterSpacing = 0.sp,
                modifier = Modifier
                    .width(297.dp)
                    .height(168.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.illustration),
                contentDescription = "Descripción de la imagen",
                modifier = Modifier
                    .size(318.57.dp) // ancho y alto
                    .offset(x = 4.dp) // posición desde la esquina superior izquierda
            )
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = stringResource(id = R.string.onboarding_text),
                fontSize = 14.sp,
                color = Gris,
                fontFamily = Poppins,
                fontWeight = FontWeight.Normal,
                lineHeight = 21.sp, // 150% de 14px = 21px
                letterSpacing = 0.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .width(327.dp)
                    .height(63.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.page_indicator),
                contentDescription = "Page indicator",
                modifier = Modifier
                    .size(width = 44.dp, height = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(64.dp))
            ButtonCom(
                text = stringResource(id = R.string.onboarding_button),
            )
        }
    }
}

@Preview()
@Composable
fun OnboardingPreview() {
    Onboarding()
}
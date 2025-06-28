package ar.edu.ort.parcial.screens.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.button.ButtonCom
import ar.edu.ort.parcial.ui.components.FieldCom
import ar.edu.ort.parcial.ui.theme.Poppins
import ar.edu.ort.parcial.ui.theme.White
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun PaymentMethod() {
    val number = remember { mutableStateOf("") }
    val name = remember { mutableStateOf("") }
    val expiry = remember { mutableStateOf("") }
    val cvv = remember { mutableStateOf("") }

    val isFormValid = number.value.isNotBlank() &&
            name.value.isNotBlank() &&
            expiry.value.isNotBlank() &&
            cvv.value.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(top = 90.dp, start = 26.dp, end = 26.dp)
        ) {
            Text(
                text = stringResource(id = R.string.payment_title),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                lineHeight = 22.05.sp,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 122.dp)
                    .width(133.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.payment_text),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 28.8.sp,
                letterSpacing = 0.sp,
                modifier = Modifier

                    .width(152.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            FieldCom(text = stringResource(id = R.string.field_number), value = number.value) {
                number.value = it
            }
            Spacer(modifier = Modifier.height(18.dp))
            FieldCom(text = stringResource(id = R.string.field_cname), value = name.value) {
                name.value = it
            }
            Spacer(modifier = Modifier.height(18.dp))
            FieldCom(text = stringResource(id = R.string.field_expired), value = expiry.value) {
                expiry.value = it
            }
            Spacer(modifier = Modifier.height(18.dp))
            FieldCom(text = stringResource(id = R.string.field_cvv), value = cvv.value) {
                cvv.value = it
            }}
        ButtonCom(
            text = stringResource(id = R.string.payment_button),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            onClick = { /* acción */ },
            enabled = isFormValid
        )
    }
}

@Preview()
@Composable
fun PaymentMethodPreview() {
    PaymentMethod()
}
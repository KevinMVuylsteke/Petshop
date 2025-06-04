package ar.edu.ort.parcial.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.ui.theme.Gray10
import ar.edu.ort.parcial.ui.theme.Gray30
import ar.edu.ort.parcial.ui.theme.Poppins

@Composable
fun FieldCom(text: String
){
    var textual by remember { mutableStateOf("") }

    OutlinedTextField(
        value=textual,
        onValueChange ={textual = it},
        placeholder={Text(text=text,
            color = Gray30,
            style = TextStyle(
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium, // 500
                fontSize = 14.sp,
                lineHeight = 21.sp, // 150% de 14px = 21px
                letterSpacing = 0.sp
            ))},
        modifier = Modifier
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Gray10)
    )
}

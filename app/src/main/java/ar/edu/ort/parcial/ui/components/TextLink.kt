package ar.edu.ort.parcial.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.theme.Poppins
import ar.edu.ort.parcial.ui.theme.Violet

@Composable
fun TextLink( text: String,
              text2: String) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text =  text,
            fontFamily = Poppins,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 19.2.sp, // 160% de 12px
            letterSpacing = 0.sp,
        )
        Text(
            text = text2,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 18.sp, // 150% de 12px
            letterSpacing = 0.sp,
            color = Violet
        )
    }
}
@Preview()
@Composable
fun TextLinkPreview() {
    TextLink(text = stringResource(id = R.string.field_create),
        text2 = stringResource(id = R.string.field_create_acc),)
}
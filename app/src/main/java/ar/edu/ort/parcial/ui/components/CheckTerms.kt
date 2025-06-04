package ar.edu.ort.parcial.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.Modifier
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import ar.edu.ort.parcial.ui.theme.Violet

@Composable
fun CheckTerms() {
    var isChecked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        TermsAndPrivacyText()
        //Text(text = if (isChecked) "Seleccionado" else "No seleccionado")
    }
}

@Composable
fun TermsAndPrivacyText() {
    val annotatedText = buildAnnotatedString {
        append("I Agree to the ")
        pushStringAnnotation(tag = "terms", annotation = "terms_of_service")
        withStyle(style = SpanStyle(
            color = Violet,
            fontWeight = FontWeight.Bold
        )) {
            append("Terms of Service")
        }
        pop()
        append(" and ")
        pushStringAnnotation(tag = "privacy", annotation = "privacy_policy")
        withStyle(style = SpanStyle(
            color = Violet,
            fontWeight = FontWeight.Bold
        )) {
            append("Privacy Policy")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 14.sp,
            color = Color.Gray
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(start = offset, end = offset).firstOrNull()?.let { annotation ->
                when (annotation.tag) {
                    "terms" -> {// Redireccionar a Términos
                        Log.d("ClickableText", "Términos de Servicio clickeado")
                    }
                    "privacy" -> {// Redireccionar a Política
                        Log.d("ClickableText", "Política de Privacidad clickeada")
                    }
                }
            }
        },
        modifier = Modifier
    )
}

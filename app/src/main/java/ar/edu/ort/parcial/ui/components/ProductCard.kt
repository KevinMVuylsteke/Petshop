package ar.edu.ort.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductCard(product: Product, onAddClick: () -> Unit = {}) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp) // Mantén un alto fijo si las tarjetas deben tener el mismo tamaño
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa todo el espacio de la Card
                .padding(8.dp),
            verticalArrangement = Arrangement.Center, // <--- CAMBIO AQUÍ: Centra los elementos verticalmente como un bloque
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp)
                // .padding(top = 8.dp), // Puedes quitar este padding si no lo necesitas con Arrangement.Center
                ,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacio entre imagen y texto
            Text(product.name, fontSize = 14.sp)
            Text("$${product.price}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp)) // Espacio entre precio y botón
            IconButton(
                onClick = onAddClick,
                modifier = Modifier
                    .background(Color(0xFF8C52FF), shape = CircleShape)
                    .size(32.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar", tint = Color.White)
            }
        }
    }
}

data class Product(
    val name: String,
    val price: String,
    val imageRes: Int
)
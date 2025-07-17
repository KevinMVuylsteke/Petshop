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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import ar.edu.ort.parcial.model.Product

@Composable
fun ProductCard(
    product: Product,
    navController: NavHostController,
    onClick: () -> Unit = {}
) {

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
                painter = rememberAsyncImagePainter(model = product.imageUrl),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacio entre imagen y texto
            Text(product.name, fontSize = 14.sp)
            Text("$${product.price}", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp)) // Espacio entre precio y botón
            IconButton(
                onClick = {
                    navController.navigate("ProductDetailScreen/${product.category}/${product.id}")
                },
                modifier = Modifier
                    .background(Color(0xFF8C52FF), shape = CircleShape)
                    .size(32.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar", tint = Color.White)
            }
        }
    }
}


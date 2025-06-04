package ar.edu.ort.parcial.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R // Asegúrate de importar tu R file para los drawables

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(product: ProductDetail) {
    var quantity by remember { mutableStateOf(1) } // Estado para la cantidad

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Product Detail",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Handle back action */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Handle favorite action */ }) {
                        Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorite")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White // Fondo de la pantalla
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp) // Padding horizontal para el contenido principal
        ) {
            // Sección de la imagen del producto
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp) // Alto fijo para la imagen
                    .padding(vertical = 16.dp), // Espacio arriba y abajo de la imagen
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)) // Un gris claro para el fondo de la imagen
            ) {
                // *** CÓDIGO PARA SUPERPONER IMÁGENES EXACTAMENTE COMO EN LA CAPTURA ***
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(14.dp), // Padding dentro de la tarjeta para las imágenes
                    contentAlignment = Alignment.Center // Centra el contenido general del Box
                ) {
                    // Imagen de la bolsa grande (la que está detrás y ligeramente a la izquierda)
                    Image(
                        painter = painterResource(id = R.drawable.fotocomidagatos), // <-- REEMPLAZA con el nombre de tu archivo de imagen GRANDE
                        contentDescription = "Royal Canin Kitten Large Bag",
                        modifier = Modifier
                            .fillMaxSize(0.9f) // Ocupa el 90% del Box
                            .align(Alignment.Center) // Alineada al centro del Box
                            .offset(x = (-40).dp), // Desplazamiento de 20dp a la IZQUIERDA
                        contentScale = ContentScale.Fit
                    )

                    // Imagen de la bolsa pequeña (superpuesta, delante, ligeramente a la derecha)
                    Image(
                        painter = painterResource(id = R.drawable.fotocomidagatos), // <-- REEMPLAZA con el nombre de tu archivo de imagen PEQUEÑA
                        contentDescription = "Royal Canin Kitten Small Bag",
                        modifier = Modifier
                            .fillMaxSize(0.8f) // Ajusta el tamaño relativo de la imagen pequeña
                            .align(Alignment.Center) // También centrada en el Box
                            .offset(x = 30.dp, y = 10.dp), // Desplazamiento: 30dp a la DERECHA, 10dp ABAJO
                        contentScale = ContentScale.Fit
                    )
                }
                // *** FIN DEL CÓDIGO PARA SUPERPONER IMÁGENES ***
            }

            // Nombre del producto
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Descripción del producto
            Text(
                text = product.description,
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f)) // Empuja el contenido inferior hacia abajo

            // Sección de Cantidad y Precio
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Selector de Cantidad
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp)) // Fondo gris claro
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    IconButton(
                        onClick = { if (quantity > 1) quantity-- },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(Icons.Default.Remove, contentDescription = "Decrease quantity", tint = Color.Gray)
                    }
                    Text(
                        text = quantity.toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    IconButton(
                        onClick = { quantity++ },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Increase quantity", tint = Color.Gray)
                    }
                }

                // Precio
                Text(
                    text = "$${product.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }

            // Botón "Add to Cart"
            Button(
                onClick = { /* TODO: Handle Add to Cart action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(bottom = 16.dp), // Espacio debajo del botón
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8C52FF)), // Color morado
                shape = RoundedCornerShape(12.dp) // Bordes redondeados
            ) {
                Text("Add to Cart", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
            }
        }
    }
}

// Mantén esta data class ProductDetail si no la tienes en un archivo separado
data class ProductDetail(
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int // Aunque ahora usemos dos, este podría ser para la imagen principal en otras vistas
)


@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen() {
    val sampleProduct = ProductDetail(
        name = "Royal Canin Adult",
        description = "The Persian cat has the longest and densest coat of all cat breeds. This means that it typically needs to consume more skin-health focused nutrients than other cat breeds. That's why ROYAL CANIN® Persian Adult contains an exclusive complex of nutrients to help the skin’s barrier defence role to maintain good skin and coat health.",
        price = "12,99",
        imageRes = R.drawable.fotocomidagatos // Usamos la imagen grande para este atributo en el preview
    )
    MaterialTheme {
        ProductDetailScreen(product = sampleProduct)
    }
}
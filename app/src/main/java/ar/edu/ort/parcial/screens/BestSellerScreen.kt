package ar.edu.ort.parcial.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource // Asegúrate de importar esto
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R // Importa tu archivo R para los drawables
import ar.edu.ort.parcial.ui.components.ProductCard
import ar.edu.ort.parcial.ui.components.Product // Importa la data class Product

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BestSellerScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestSellerScreen() {
    // Aquí es donde puedes definir tus productos reales.
    // Asegúrate de que R.drawable.comidaparagatos2 y R.drawable.fotocomidagatos
    // existan en tu carpeta `res/drawable`.
    val products = listOf(
        Product("RC Kitten", "20,99", R.drawable.fotocomidaperros),
        Product("RC Persian", "22,99", R.drawable.fotocomidagatos),
        Product("RC Kitten", "20,99", R.drawable.fotocomidaperros),
        Product("RC Persian", "22,99", R.drawable.fotocomidagatos),
        Product("RC Kitten", "20,99", R.drawable.fotocomidaperros),
        Product("RC Persian", "22,99", R.drawable.fotocomidagatos)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Best Seller",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Manejar acción de retroceso */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White) // Ajusta el color según sea necesario
            )
        },
        containerColor = Color.White // Establece el color de fondo de la pantalla
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 columnas como se ve en la imagen
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Espaciado horizontal entre tarjetas
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado vertical entre tarjetas
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(products) { product ->
                ProductCard(product = product) {
                    // Aquí puedes manejar la lógica cuando se hace clic en "Agregar"
                    println("Se agregó ${product.name} al carrito!")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBestSellerScreen() {
    BestSellerScreen()
}
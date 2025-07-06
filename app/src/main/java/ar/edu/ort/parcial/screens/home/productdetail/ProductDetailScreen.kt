package ar.edu.ort.parcial.screens.home.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
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
import ar.edu.ort.parcial.R
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import ar.edu.ort.parcial.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavHostController,
     viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val product = ProductDetail(
        id = "prod_rc_adult",
        name = "Royal Canin Adult",
        description = "The Persian cat has the longest and densest coat of all cat breeds. This means that it typically needs to consume more skin-health focused nutrients than other cat breeds. That's why ROYAL CANIN® Persian Adult contains an exclusive complex of nutrients to help the skin’s barrier defence role to maintain good skin and coat health.",
        price = "12,99",
        imageRes = R.drawable.fotocomidagatos
    )

    var isFavorite by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var quantity by remember { mutableStateOf(1) }


    LaunchedEffect(product.id) {
        isFavorite = viewModel.isFavorite(product.id)
    }
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
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {

                        scope.launch {
                            viewModel.toggleFavorite(product.id)
                            isFavorite = viewModel.isFavorite(product.id)
                        }
                    }) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) Color.Red else Color.Gray
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White,
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .padding(vertical = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = product.imageRes),
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxSize(0.9f)
                            .align(Alignment.Center)
                            .offset(x = (-40).dp),
                        contentScale = ContentScale.Fit
                    )

                    Image(
                        painter = painterResource(id = product.imageRes),
                        contentDescription = product.name,
                        modifier = Modifier
                            .fillMaxSize(0.8f)
                            .align(Alignment.Center)
                            .offset(x = 30.dp, y = 10.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = product.description,
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 20.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
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

                Text(
                    text = "$${product.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }

            Button(
                onClick = { /* TODO: Handle Add to Cart action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8C52FF)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Add to Cart", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
            }
        }
    }
}

data class ProductDetail(
    val id: String,
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int
)

@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen() {
    val navController = rememberNavController()
    MaterialTheme {
        ProductDetailScreen(navController = navController)
    }
}

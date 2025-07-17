package ar.edu.ort.parcial.screens.homepage.productdetail

import android.util.Log
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import androidx.navigation.NavHostController
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.ButtonCom
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    category: String,
    productId: String,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {

    Log.d("ProductDetailScreen", "ProductDetailScreen productId: $productId")
    val productState by viewModel.product.collectAsState() // Renombrar para claridad
    val currentProduct = productState
    var isFavorite by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var quantity by remember { mutableStateOf(1) }

    LaunchedEffect(Unit) {
        Log.d("launched ProductDetailScreen", "ProductDetailScreen launched productId recibido: ${productId}")
        viewModel.loadProduct(category, productId)
    }
    if (currentProduct == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }
    LaunchedEffect(currentProduct?.id) {
        currentProduct?.let {
            isFavorite = viewModel.isFavorite(it.id)
            Log.d("FavoriteCheck", "Producto favorito: $isFavorite")
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.product_detail_title),
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
                            viewModel.toggleFavorite(currentProduct.id)
                            isFavorite = viewModel.isFavorite(currentProduct.id)
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
                    AsyncImage(
                        model = currentProduct.imageUrl,
                        contentDescription = currentProduct.name,
                        modifier = Modifier
                            .fillMaxSize(0.9f)
                            .align(Alignment.Center)
                            .offset(x = (-40).dp),
                        contentScale = ContentScale.Fit
                    )

                    AsyncImage(
                        model = currentProduct.imageUrl,
                        contentDescription = currentProduct.name,
                        modifier = Modifier
                            .fillMaxSize(0.8f)
                            .align(Alignment.Center)
                            .offset(x = 30.dp, y = 10.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Text(
                text = currentProduct.fullname,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = currentProduct.description,
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
                    text = "$${currentProduct.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black
                )
            }
            ButtonCom(
                text = "Add to Cart",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                onClick = {
                    navController.navigate("cart")
                }
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen() {
    val navController = rememberNavController()
    MaterialTheme {
        ProductDetailScreen(navController = navController, category = category)
    }
}
*/
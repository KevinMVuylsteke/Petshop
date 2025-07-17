package ar.edu.ort.parcial.screens.homepage.bestseller

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.MyTopBar
import ar.edu.ort.parcial.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BestSellerScreen(
    navController: NavHostController,
    viewModel: BestSellerViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState()

    Scaffold(
        topBar = {
            MyTopBar(
                title = stringResource(id = R.string.best_seller_title)
            ) {
                navController.popBackStack()
            }
        },
        containerColor = Color.White
    )
    { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(products) { product ->
                ProductCard(
                    product = product,
                    navController = navController,
                    onClick = {
                        navController.navigate("ProductDetailScreen/${product.category}/${product.id}")
                        Log.d("","BestSeller Screen: productId (doc.id): ${product.id}")
                    }
                )
            }
        }
    }
}
/*
@Preview(showBackground = true)
@Composable
fun PreviewBestSellerScreen() {
    val navController = rememberNavController()
    BestSellerScreen(navController = navController)
}
*/
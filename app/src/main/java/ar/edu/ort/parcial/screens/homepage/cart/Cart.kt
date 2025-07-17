package ar.edu.ort.parcial.screens.homepage.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.ort.parcial.model.CartProduct
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.ButtonCom
import ar.edu.ort.parcial.ui.components.MyTopBar
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Cart(
    navController: NavHostController,
    viewModel: CartViewModel = hiltViewModel()
) {
    val cart by viewModel.cartState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCart()
    }

    if (cart == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Scaffold(
            topBar = {
                MyTopBar(title = stringResource(id = R.string.cart_title)) {
                    navController.popBackStack()
                }
            },
            bottomBar = {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Total: $${cart!!.total}",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(bottom = 8.dp)
                    )
                    ButtonCom(
                        text = stringResource(id = R.string.cart_buttoncom),
                        onClick = {
                            // Acción al hacer checkout
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        ) { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(cart!!.products) { product ->
                    CartProductCard(product = product)
                }
            }
        }
    }
}

@Composable
fun CartProductCard(product: CartProduct) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = product.thumbnail,
                contentDescription = product.title,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f).padding(start = 12.dp)) {
                Text(
                    text = product.title,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                    )
                )
                Text(
                    text = "for 2-3 years",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Justify
                    )
                )
                Text(
                    text = "$${product.total}",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color(0xFF7140FD)
                    )
                )
            }
        }
    }
}

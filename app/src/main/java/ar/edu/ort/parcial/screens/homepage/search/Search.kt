package ar.edu.ort.parcial.screens.homepage.search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcial.screens.homepage.home.Category
import ar.edu.ort.parcial.ui.components.ProductCard
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.grid.items

@Composable
fun Search(
    navController: NavHostController,
    viewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by viewModel.searchQuery.collectAsState()
    val categories = viewModel.categories
    val selectedCategoryName by viewModel.selectedCategoryName.collectAsState()
    val products by viewModel.filteredProducts.collectAsState(initial = emptyList())


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Search",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Search field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.updateQuery(it) },
            placeholder = { Text("Search your Product") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Category Filters
        CategorySection(categories = categories,
            selectedCategoryName = selectedCategoryName,
            onCategorySelected = { viewModel.selectCategory(it) }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Recent Searches
        if (products.isEmpty()) {
            Text("No se encontraron productos.", modifier = Modifier.padding(16.dp))
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(products) { product ->
                    ProductCard(product = product,
                        navController = navController,
                        onClick = {
                            Log.d("SearchScreen", "Navigating to ProductDetailScreen with: ${product.category}, ${product.id}")
                            navController.navigate("ProductDetailScreen/${product.category}/${product.id}")
                            //Log.d("HomeScreen", "Best Seller item clicked: ${product.id}")
                        })

                    /*{
                        navController.navigate("productDetail/${product.category}/${product.id}")
                    }*/
                }
            }
        }
    }
}

@Composable
fun CategorySection(
    categories: List<Category>,
    selectedCategoryName: String?,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(modifier = Modifier.padding(16.dp)) {
        items(categories) { category ->
            val isSelected = category.name == selectedCategoryName
            Button(
                onClick = { onCategorySelected(category.name) },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSelected) Color(0xFF7A50E3) else Color.LightGray,
                    contentColor = if (isSelected) Color.White else Color.Black
                ),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(category.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    val navController = rememberNavController()
    Search(navController= navController)
}
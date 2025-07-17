package ar.edu.ort.parcial.screens.homepage.search

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcial.screens.homepage.home.Category
import ar.edu.ort.parcial.ui.components.ProductCard
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.res.stringResource
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.MyTopBar

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
        MyTopBar(
            title = stringResource(id = R.string.search_title),
            onBackClick = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.updateQuery(it) },
            placeholder = { Text(stringResource(id = R.string.search_outlined)) },
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

        CategorySection(categories = categories,
            selectedCategoryName = selectedCategoryName,
            onCategorySelected = { viewModel.selectCategory(it) }
        )

        Spacer(modifier = Modifier.height(24.dp))

        if (products.isEmpty()) {
            Text(stringResource(id = R.string.lazy_product), modifier = Modifier.padding(16.dp))
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
                            })
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
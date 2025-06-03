package ar.edu.ort.parcial.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.BottomNavBar

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavBar(navController) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LocationSection()
            PromoSection()
            CategorySection()
            BestSellerSection()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {},
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.padding(end = 8.dp)
            ) {


                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.LightGray.copy(alpha = 0.3f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { /* TODO: Search */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black)
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))


                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.LightGray.copy(alpha = 0.3f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { /* TODO: Notifications */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.Black)
                    }
                }
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun LocationSection() {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Location", color = Color.Gray, fontSize = 12.sp)

        }
        Text("Jebres, Surakarta", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PromoSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(200.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF7A50E3)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(180.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fotocomidagatos),
                    contentDescription = "Promo Image Back",
                    modifier = Modifier
                        .size(width = 180.dp, height = 220.dp)
                        .offset(x = 14.dp, y = 12.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.fotocomidagatos),
                    contentDescription = "Promo Image Front",
                    modifier = Modifier
                        .size(width = 180.dp, height = 220.dp)
                        .offset(x = -10.dp, y = 0.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    "Royal Canin\nAdult Pomeraniann",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Get an interesting promo here,\nwithout conditions",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}


@Composable
fun CategorySection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Category", fontWeight = FontWeight.Bold)
            Text("View All", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            val categories = listOf("Food", "Toys", "Accessories")
            categories.forEach { category ->
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(20.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (category == "Food") Color(0xFF7A50E3) else Color.LightGray,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(category)
                }
            }
        }
    }
}

@Composable
fun BestSellerSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Best Seller", fontWeight = FontWeight.Bold)
            Text("View All", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(listOf("RC Kitten" to "$20.99", "RC Persian" to "$22.99")) { (name, price) ->
                ProductItem(name, price)
            }
        }
    }
}

@Composable
fun ProductItem(name: String, price: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(end = 16.dp)
            .width(160.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fotocomidaperros),
                contentDescription = "Product",
                modifier = Modifier.height(100.dp)
            )
            Text(name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(price, fontSize = 12.sp)
            IconButton(onClick = { /*TODO: Add to cart*/ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}


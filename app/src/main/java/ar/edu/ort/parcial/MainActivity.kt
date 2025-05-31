package ar.edu.petshopapptp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import ar.edu.petshopapptp3.ui.theme.PetshopAppTP3Theme
import androidx.compose.material3.TopAppBarDefaults
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.BottomNavigation
import androidx.compose.material3.BottomNavigationItem
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetshopAppTP3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

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

@Composable
fun TopBar() {
    TopAppBar(
        title = {},
        actions = {
            IconButton(onClick = { /* TODO: Cart */ }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
            }
            IconButton(onClick = { /* TODO: Notifications */ }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}



@Composable
fun LocationSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Location", color = Color.Gray, fontSize = 12.sp)
        Text("Jebres, Surakarta", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun PromoSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        backgroundColor = Color(0xFF7A50E3),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.promo_image), // agrega la imagen
                contentDescription = "Promo",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Royal Canin\nAdult Pomeraniann", color = Color.White, fontWeight = FontWeight.Bold)
                Text("Get an interesting promo here, without conditions", color = Color.White, fontSize = 12.sp)
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
                        backgroundColor = if (category == "Food") Color(0xFF7A50E3) else Color.LightGray
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text(category, color = Color.White)
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
                painter = painterResource(id = R.drawable.product_placeholder),
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

@Composable
fun BottomNavBar(navController: NavController) {
    BottomNavigation {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = true,
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Schedule, contentDescription = "History") },
            selected = false,
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            selected = false,
            onClick = { }
        )
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetshopAppTP3Theme {
        MainApp()
    }
}

package ar.edu.ort.parcial.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavBar(navController: NavController) {
    BottomAppBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true, // Actualmente siempre seleccionado
            onClick = {
                // Si tienes una ruta para Home, úsala aquí:
                // navController.navigate("home_screen")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Schedule, contentDescription = "History") },
            label = { Text("History") },
            selected = false, // Nunca seleccionado visualmente
            onClick = {
                // Si tienes una ruta para History, úsala aquí:
                // navController.navigate("history_screen")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Cart") },
            selected = false, // Nunca seleccionado visualmente
            onClick = {
                // Aquí ya tienes la navegación al carrito, ¡esto está bien!
                navController.navigate("cart_screen")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false, // Nunca seleccionado visualmente
            onClick = {
                // Si tienes una ruta para Profile, úsala aquí:
                // navController.navigate("profile_screen")
            }
        )
    }
}
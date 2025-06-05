package ar.edu.ort.parcial.ui.components
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ar.edu.ort.parcial.navigation.NavRoutes

@Composable
fun BottomNavBar(navController: NavController) {
    BottomAppBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            selected = false, // Actualmente siempre seleccionado
            onClick = {navController.navigate(NavRoutes.HOME)
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Schedule, contentDescription = "History") },
            selected = false, // Nunca seleccionado visualmente
            onClick = {
                // navController.navigate()
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            selected = false, // Nunca seleccionado visualmente
            onClick = {
                //navController.navigate(NavRoutes.CART)
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            selected = false, // Nunca seleccionado visualmente
            onClick = {navController.navigate(NavRoutes.PROFILE){
                    popUpTo(NavRoutes.HOME) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}
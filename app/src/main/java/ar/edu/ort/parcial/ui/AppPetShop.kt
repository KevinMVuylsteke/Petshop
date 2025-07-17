package ar.edu.ort.parcial.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcial.ui.viewmodel.MainActivityViewModel
import ar.edu.ort.parcial.navigation.AppNavigation
import ar.edu.ort.parcial.ui.theme.ParcialTheme

@Composable
fun AppPetShop(viewModel: MainActivityViewModel){
    ParcialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()

            AppNavigation(navController, viewModel)
        }

    }
}
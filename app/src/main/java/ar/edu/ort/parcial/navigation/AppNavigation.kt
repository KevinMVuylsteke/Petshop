package ar.edu.ort.parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcial.screens.Onboarding
import ar.edu.ort.parcial.screens.LoginIn
import ar.edu.ort.parcial.screens.CreateAccount

object NavRoutes {
    const val ONBOARDING = "onboarding"
    const val LOGIN = "LoginIn"
    const val CREATE = "CreateAccount"
    const val CREATE2 = "CreateAccount"
}


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.ONBOARDING) {
        composable(NavRoutes.ONBOARDING) {
            Onboarding(
                onNavigateToLogin = { navController.navigate(NavRoutes.LOGIN) }
            )
        }
        composable(NavRoutes.LOGIN) {
            LoginIn(
                onNavigateToCreate = { navController.navigate(NavRoutes.CREATE) }
            )
        }
        composable(NavRoutes.CREATE) {
            CreateAccount(
                onCreateToLogin = { navController.navigate(NavRoutes.LOGIN) }
            )
        }
    }
}

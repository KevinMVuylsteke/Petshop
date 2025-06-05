package ar.edu.ort.parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcial.screens.Onboarding
import ar.edu.ort.parcial.screens.LoginIn
import ar.edu.ort.parcial.screens.CreateAccount
import ar.edu.ort.parcial.screens.HomeScreen
import ar.edu.ort.parcial.screens.NotificationScreen
import ar.edu.ort.parcial.screens.ProfileScreen
import ar.edu.ort.parcial.screens.SellerScreen
import ar.edu.ort.parcial.screens.BestSellerScreen

object NavRoutes {
    const val ONBOARDING = "onboarding"
    const val LOGIN = "LoginIn"
    const val CREATE = "CreateAccount"
    const val HOME = "Home"
    const val NOTIFICATION = "Notification"
    const val PROFILE = "Profile"
    const val SELLER = "Seller"
    const val BESTSELLER = "BestSeller"
    const val PRODUCTDETAIL = "ProductDetail"
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.ONBOARDING) {
        composable(NavRoutes.ONBOARDING) {
            Onboarding(navController)
        }
        composable(NavRoutes.LOGIN) {
            LoginIn(navController)
        }
        composable(NavRoutes.CREATE) {
            CreateAccount(navController)
        }
        composable(NavRoutes.HOME) {
            HomeScreen(navController)
        }
        composable(NavRoutes.NOTIFICATION) {
            NotificationScreen(navController)
        }
        composable(NavRoutes.PROFILE) {
            ProfileScreen(navController)
        }
        composable(NavRoutes.SELLER) {
            SellerScreen(navController)
        }
        composable(NavRoutes.BESTSELLER) {
            BestSellerScreen(navController)
        }
        composable(NavRoutes.PRODUCTDETAIL) {
            SellerScreen(navController)
        }
    }
}

package ar.edu.ort.parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcial.screens.onboarding.Onboarding
import ar.edu.ort.parcial.screens.auth.LoginIn
import ar.edu.ort.parcial.screens.auth.CreateAccount
import ar.edu.ort.parcial.screens.home.HomeScreen
import ar.edu.ort.parcial.screens.notifications.NotificationScreen
import ar.edu.ort.parcial.screens.profile.ProfileScreen
import ar.edu.ort.parcial.screens.profile.SellerScreen
import ar.edu.ort.parcial.screens.home.BestSellerScreen

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

package ar.edu.ort.parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ar.edu.ort.parcial.ui.viewmodel.MainActivityViewModel
import ar.edu.ort.parcial.screens.onboarding.Onboarding
import ar.edu.ort.parcial.screens.auth.loginin.LoginIn
import ar.edu.ort.parcial.screens.auth.createaccount.CreateAccount
import ar.edu.ort.parcial.screens.homepage.home.HomeScreen
import ar.edu.ort.parcial.screens.notifications.NotificationScreen
import ar.edu.ort.parcial.screens.profile.ProfileScreen
import ar.edu.ort.parcial.screens.profile.SellerScreen
import ar.edu.ort.parcial.screens.homepage.bestseller.BestSellerScreen
import ar.edu.ort.parcial.screens.homepage.cart.Cart
import ar.edu.ort.parcial.screens.homepage.productdetail.ProductDetailScreen
import ar.edu.ort.parcial.screens.homepage.search.Search

object NavRoutes {
    const val ONBOARDING = "onboarding"
    const val LOGIN = "LoginIn"
    const val CREATE = "CreateAccount"
    const val HOME = "Home"
    const val NOTIFICATION = "Notification"
    const val PROFILE = "Profile"
    const val SELLER = "Seller"
    const val BESTSELLER = "BestSeller"
    const val PRODUCTDETAIL = "ProductDetailScreen"
    const val SEARCH = "SearchScreen"
    const val CART = "Cart"
}

@Composable
fun AppNavigation(navController: NavHostController, viewModel: MainActivityViewModel) {
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
        //composable(NavRoutes.PRODUCTDETAIL) {
        //    ProductDetailScreen(navController)
        //}
        composable("${NavRoutes.PRODUCTDETAIL}/{category}/{productId}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(navController, category, productId)
        }
        composable(NavRoutes.SEARCH) {
            Search(navController)
        }
        composable(NavRoutes.CART) {
            Cart(navController)
        }
    }
}

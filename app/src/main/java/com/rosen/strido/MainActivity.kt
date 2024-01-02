package com.rosen.strido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rosen.strido.navigation.Route
import com.rosen.strido.presentation.AccountScreen
import com.rosen.strido.presentation.FavoriteScreen
import com.rosen.strido.presentation.HomeScreen
import com.rosen.strido.presentation.ProductDetails
import com.rosen.strido.presentation.ShoppingBagScreen
import com.rosen.strido.presentation.ShoppingCartScreen
import com.rosen.strido.ui.theme.StridoTheme
import com.rosen.timecraft.ui.components.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StridoTheme {

                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { contentPadding ->

                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                        navController = navController,
                        startDestination = Route.HomeScreen.route
                    ) {
                        composable(route = Route.HomeScreen.route) {
                            HomeScreen(navController)
                        }

                        composable(route = Route.FavoriteScreen.route) {
                            FavoriteScreen(contentPadding = contentPadding)
                        }

                        composable(route = Route.ShoppingBag.route) {
                            ShoppingBagScreen(contentPadding = contentPadding)
                        }

                        composable(route = Route.ShoppingCart.route) {
                            ShoppingCartScreen(contentPadding = contentPadding)
                        }

                        composable(route = Route.Account.route) {
                            AccountScreen(contentPadding = contentPadding)
                        }

                        composable(route = "productDetails/{productId}") { backStackEntry ->
                            val productId = backStackEntry.arguments?.getString("productId")
                            ProductDetails(productId = productId)
                        }
                    }

                }

            }
        }
    }
}

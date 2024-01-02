package com.rosen.strido.navigation

sealed class Route(val route: String) {
    object HomeScreen : Route("home_screen")
    object FavoriteScreen : Route("favorite_screen")
    object ShoppingBag : Route("shopping_bag_screen")
    object Account : Route("account_screen")
    object ShoppingCart : Route("shopping_cart_screen")
}
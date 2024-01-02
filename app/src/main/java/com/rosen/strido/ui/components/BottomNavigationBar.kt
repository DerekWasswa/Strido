package com.rosen.timecraft.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rosen.strido.R
import com.rosen.strido.navigation.Route
import com.rosen.strido.ui.theme.Black
import com.rosen.strido.ui.theme.StridoTheme
import com.rosen.strido.ui.theme.White


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val navBarScreens = listOf(
        Route.HomeScreen,
        Route.FavoriteScreen,
        Route.ShoppingBag,
        Route.ShoppingCart,
        Route.Account
    )

    if (currentDestination?.route in navBarScreens.map { it.route })
        NavigationBar(
            containerColor = White,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AddNavigationBarItem(
                    label = "Home",
                    iconResId = R.drawable.home_default,
                    focusedIconResId = R.drawable.home_white,
                    destinationRoute = Route.HomeScreen,
                    currentDestination = currentDestination,
                    navController = navController
                )

                AddNavigationBarItem(
                    label = "Favorites",
                    iconResId = R.drawable.favorite_default,
                    focusedIconResId = R.drawable.favorite_white,
                    destinationRoute = Route.FavoriteScreen,
                    currentDestination = currentDestination,
                    navController = navController
                )

                AddNavigationBarItem(
                    label = "Bag",
                    iconResId = R.drawable.shopping_bag_default,
                    focusedIconResId = R.drawable.shopping_bag_white,
                    destinationRoute = Route.ShoppingBag,
                    currentDestination = currentDestination,
                    navController = navController
                )

                AddNavigationBarItem(
                    label = "Cart",
                    iconResId = R.drawable.shopping_cart_default,
                    focusedIconResId = R.drawable.shopping_cart_white,
                    destinationRoute = Route.ShoppingCart,
                    currentDestination = currentDestination,
                    navController = navController
                )

                AddNavigationBarItem(
                    label = "Account",
                    iconResId = R.drawable.person_default,
                    focusedIconResId = R.drawable.person_white,
                    destinationRoute = Route.Account,
                    currentDestination = currentDestination,
                    navController = navController
                )

            }
        }
}


@Composable
private fun RowScope.AddNavigationBarItem(
    label : String,
    iconResId: Int,
    focusedIconResId: Int,
    destinationRoute: Route,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == destinationRoute.route } == true

    val background =
        if (selected) Black else Color.Transparent

    val contentColor =
        if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(destinationRoute.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = if (selected) focusedIconResId else iconResId),
                contentDescription = "icon",
                tint = contentColor
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = label,
                    color = contentColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    StridoTheme {
        val navController = rememberNavController()
        BottomNavigationBar(navController = navController)
    }
}
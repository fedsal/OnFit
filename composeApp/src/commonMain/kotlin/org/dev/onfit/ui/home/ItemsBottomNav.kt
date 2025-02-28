package org.dev.onfit.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector
import org.dev.onfit.ui.navigation.HomeDestination

sealed class ItemsBottomNav(
    val icon: ImageVector,
    val title: String,
    val route: HomeDestination
) {
    data object Profile: ItemsBottomNav(
        icon = Icons.Outlined.Home,
        title = "Home",
        route = HomeDestination.Home
    )

    data object Shop: ItemsBottomNav(
        icon = Icons.Outlined.ShoppingBag,
        title = "Shop",
        route = HomeDestination.Shop
    )
}
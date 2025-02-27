package org.dev.onfit.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector
import org.dev.onfit.ui.navigation.HomeDestination

sealed class ItemsBottomNav(
    val icon: ImageVector,
    val title: String,
    val route: HomeDestination
) {
    data object Profile: ItemsBottomNav(
        icon = Icons.Rounded.Person,
        title = "Profile",
        route = HomeDestination.Profile
    )

    data object Shop: ItemsBottomNav(
        icon = Icons.Rounded.ShoppingBag,
        title = "Shop",
        route = HomeDestination.Shop
    )
}
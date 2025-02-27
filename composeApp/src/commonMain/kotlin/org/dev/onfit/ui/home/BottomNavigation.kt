package org.dev.onfit.ui.home

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.dev.onfit.ui.navigation.HomeDestination
import org.dev.onfit.ui.navigation.hasRoute

@Composable
fun BottomNavigation(
    navHostController: NavHostController
) {
    val menuItems = listOf(ItemsBottomNav.Shop, ItemsBottomNav.Profile)
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val showBottomBar = navBackStackEntry.hasRoute(HomeDestination.Home)
    if (showBottomBar) {
        BottomAppBar {
            NavigationBar {
                menuItems.forEach { item ->
                    NavigationBarItem(
                        selected = navBackStackEntry.hasRoute(item.route),
                        label = {
                            Text(text = item.title)
                        },
                        onClick = { navHostController.navigate(item.route) },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.title) }
                    )
                }
            }
        }
    }
}

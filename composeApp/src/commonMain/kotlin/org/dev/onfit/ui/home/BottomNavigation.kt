package org.dev.onfit.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        BottomAppBar(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .height(100.dp),
        ) {
            Column {
                Spacer(Modifier.size(20.dp))
                NavigationBar(Modifier.offset(y = (-5).dp)) {
                    menuItems.forEach { item ->
                        NavigationBarItem(
                            selected = navBackStackEntry.hasRoute(item.route),
                            label = {
                                Text(text = item.title)
                            },
                            onClick = { navHostController.navigate(item.route) },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.Transparent,
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                            )
                        )
                    }
                }
            }
        }
    }
}

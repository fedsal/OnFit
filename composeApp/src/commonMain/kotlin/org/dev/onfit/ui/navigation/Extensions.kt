package org.dev.onfit.ui.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy

fun NavBackStackEntry?.hasRoute(route: Any): Boolean = this?.destination?.hierarchy?.any {
    it.hasRoute(route::class)
} ?: false
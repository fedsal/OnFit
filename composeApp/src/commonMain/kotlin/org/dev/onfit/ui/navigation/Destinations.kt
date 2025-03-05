package org.dev.onfit.ui.navigation

import kotlinx.serialization.Serializable

// Routes for auth
@Serializable
sealed class AuthDestination {
    @Serializable
    data object Auth: AuthDestination()
    @Serializable
    data object Login: AuthDestination()
    @Serializable
    data object Register: AuthDestination()
}

// Route for splash
@Serializable
data object Splash

// Route for Account
@Serializable
data object Account

// Route for home
sealed class HomeDestination {
    @Serializable
    data object HomeGraph : HomeDestination()
    @Serializable
    data object Home : HomeDestination()
    @Serializable
    data object Shop : HomeDestination()
}
package org.dev.onfit.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class Destination {

    @Serializable
    data object Splash : Destination()

    @Serializable
    data object Login : Destination()

    @Serializable
    data object Home : Destination()

}
package org.dev.onfit.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.dev.onfit.ui.login.LoginScreen
import org.dev.onfit.ui.navigation.profile.ProfileScreen
import org.dev.onfit.ui.navigation.shop.ShopScreen
import org.dev.onfit.ui.splash.SplashScreen

@Composable
fun OnFitNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> { SplashScreen() }
        navigation<HomeDestination.Home>(startDestination = HomeDestination.Profile) {
            composable<HomeDestination.Profile> { ProfileScreen() }
            composable<HomeDestination.Shop> { ShopScreen() }
        }
        navigation<AuthDestination.Auth>(startDestination = AuthDestination.Login) {
            composable<AuthDestination.Login> { LoginScreen() }
            composable<AuthDestination.Register> { Text("Register") }
        }
    }
}
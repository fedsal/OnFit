package org.dev.onfit.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.dev.onfit.ui.login.LoginScreen
import org.dev.onfit.ui.splash.SplashScreen

@Composable
fun OnFitNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Home) {
        composable<Splash> { SplashScreen() }
        composable<Home> { Text("Home") }
        navigation<AuthDestination.Auth>(startDestination = AuthDestination.Login) {
            composable<AuthDestination.Login> { LoginScreen() }
            composable<AuthDestination.Register> { Text("Register") }
        }
    }
}
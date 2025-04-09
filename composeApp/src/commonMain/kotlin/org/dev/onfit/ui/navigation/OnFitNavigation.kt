package org.dev.onfit.ui.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import org.dev.onfit.ui.account.AccountScreen
import org.dev.onfit.ui.home.HomeScreen
import org.dev.onfit.ui.home.shop.ShopScreen
import org.dev.onfit.ui.login.LoginScreen
import org.dev.onfit.ui.splash.SplashScreen

@Composable
fun OnFitNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> { SplashScreen() }
        navigation<HomeDestination.HomeGraph>(startDestination = HomeDestination.Home) {
            composable<HomeDestination.Home>(
                enterTransition = { EnterTransition.None }
            ) { HomeScreen() }
            composable<HomeDestination.Shop>(
                enterTransition = { EnterTransition.None }
            ) { ShopScreen() }
        }
        animatedComposable<Account> { AccountScreen() }
        animatedNavigation<AuthDestination.Auth>(startDestination = AuthDestination.Login) {
            animatedComposable<AuthDestination.Login> { LoginScreen() }
            animatedComposable<AuthDestination.Register> { Text("Register") }
        }
    }
}

/**
 * Slide in/out animated navigation
 */
inline fun <reified T : Any> NavGraphBuilder.animatedNavigation(
    startDestination: Any,
    noinline builder: NavGraphBuilder.() -> Unit
) {
    navigation<T>(
        startDestination = startDestination,
        builder = builder,
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
    )
}

/**
 * Slide in/out animated composable
 */
inline fun <reified T : Any> NavGraphBuilder.animatedComposable(
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) },
        content = content
    )
}
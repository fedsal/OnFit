package org.dev.onfit.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.dev.onfit.framework.di.dataSourceModule
import org.dev.onfit.framework.di.networkModule
import org.dev.onfit.framework.di.repositoryModule
import org.dev.onfit.framework.di.viewmodelModule
import org.dev.onfit.ui.login.LoginScreen
import org.dev.onfit.ui.splash.SplashScreen
import org.dev.onfit.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module
import org.koin.dsl.module

@Composable
@Preview
fun App(
    platformModules: List<Module> = emptyList()
) {
    val navController = rememberNavController()
    val navigationModule = module {
        single<NavHostController> { navController }
    }
    fun applicationModules() =
        listOf(viewmodelModule, repositoryModule, dataSourceModule, networkModule, navigationModule)
    KoinApplication(application = { modules(applicationModules() + platformModules) }) {
        AppTheme {
            NavHost(navController = navController, startDestination = Destination.Splash) {
                composable<Destination.Splash> { SplashScreen() }
                composable<Destination.Login> { LoginScreen() }
            }
        }
    }
}

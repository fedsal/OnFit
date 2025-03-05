package org.dev.onfit.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QrCode
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.dev.onfit.framework.di.dataSourceModule
import org.dev.onfit.framework.di.networkModule
import org.dev.onfit.framework.di.repositoryModule
import org.dev.onfit.framework.di.viewmodelModule
import org.dev.onfit.ui.common.composables.HomeTopBarContent
import org.dev.onfit.ui.common.composables.OnFitTopBar
import org.dev.onfit.ui.home.BottomNavigation
import org.dev.onfit.ui.navigation.Account
import org.dev.onfit.ui.navigation.HomeDestination
import org.dev.onfit.ui.navigation.OnFitNavigation
import org.dev.onfit.ui.navigation.hasRoute
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
            MainScreen(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing),
        topBar = {
            if (navBackStackEntry.hasRoute(HomeDestination.Home)) {
                OnFitTopBar {
                    HomeTopBarContent(onAccountTapped = { navController.navigate(Account) })
                }
            }
        },
        bottomBar = {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                BottomNavigation(navController)
                if (navBackStackEntry.hasRoute(HomeDestination.HomeGraph))
                    FloatingActionButton(
                        modifier = Modifier.size(70.dp).offset(y = (-30).dp),
                        onClick = {},
                        shape = CircleShape,
                        elevation = FloatingActionButtonDefaults.elevation(0.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            imageVector = Icons.Rounded.QrCode,
                            tint = Color.Black,
                            contentDescription = ""
                        )
                    }
            }
        }
    ) { padding ->
        OnFitNavigation(modifier = Modifier.padding(padding), navController = navController)
    }
}

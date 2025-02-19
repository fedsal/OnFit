package org.dev.onfit.ui

import androidx.compose.runtime.Composable
import org.dev.onfit.di.dataSourceModule
import org.dev.onfit.di.networkModule
import org.dev.onfit.di.repositoryModule
import org.dev.onfit.di.viewmodelModule
import org.dev.onfit.ui.login.LoginScreen
import org.dev.onfit.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module

@Composable
@Preview
fun App(
    platformModules: List<Module> = emptyList()
) {
    fun applicationModules() =
        listOf(viewmodelModule, repositoryModule, dataSourceModule, networkModule)
    KoinApplication(application = { modules(applicationModules() + platformModules) }) {
        AppTheme {
            LoginScreen()
        }
    }
}

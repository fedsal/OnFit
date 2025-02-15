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
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(
                viewmodelModule,
                repositoryModule,
                dataSourceModule,
                networkModule
            )
        }
    ) {
        AppTheme {
            LoginScreen()
        }
    }
}

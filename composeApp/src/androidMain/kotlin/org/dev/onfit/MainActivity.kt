package org.dev.onfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.dev.onfit.common.createDataStore
import org.dev.onfit.ui.App
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            App(listOf(dataStoreModule))
        }
    }

    private val dataStoreModule = module {
        single { createDataStore(applicationContext) }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
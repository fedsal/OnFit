package org.dev.onfit

import androidx.compose.ui.window.ComposeUIViewController
import org.dev.onfit.ui.App
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController {
    App(
        listOf(dataStoreModule)
    )
}

private val dataStoreModule = module {
    single { createDataStore() }
}
package org.dev.onfit.framework.di

import org.dev.onfit.ui.login.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewmodelModule = module {
    viewModelOf(::LoginViewModel)
}

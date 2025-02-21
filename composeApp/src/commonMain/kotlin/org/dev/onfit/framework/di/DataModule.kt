package org.dev.onfit.framework.di

import org.dev.onfit.data.auth.AuthRepository
import org.dev.onfit.data.auth.LocalAuthDataSource
import org.dev.onfit.data.auth.RemoteAuthDataSource
import org.dev.onfit.framework.datastore.AuthLocalDataSource
import org.dev.onfit.framework.ktor.AuthRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> { AuthRepository(get(),get()) }
}

val dataSourceModule = module {
    single<RemoteAuthDataSource> { AuthRemoteDataSource(get()) }
    single<LocalAuthDataSource> { AuthLocalDataSource(get()) }
}


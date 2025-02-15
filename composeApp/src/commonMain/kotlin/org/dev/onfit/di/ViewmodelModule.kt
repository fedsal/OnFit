package org.dev.onfit.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.dev.onfit.data.auth.AuthRemoteDataSource
import org.dev.onfit.data.auth.AuthRepository
import org.dev.onfit.ui.login.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewmodelModule = module {
    viewModelOf(::LoginViewModel)
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepository(get<AuthRemoteDataSource>(),get<AuthRemoteDataSource>()) }
}

val dataSourceModule = module {
    single<AuthRemoteDataSource> { AuthRemoteDataSource(get()) }
}

val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}
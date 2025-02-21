package org.dev.onfit.data.auth

import org.dev.onfit.domain.login.LoginResponse

class AuthRepository(
    private val remoteDataSource: RemoteAuthDataSource,
    private val localDataSource: LocalAuthDataSource
) {
    suspend fun login(username: String, password: String): LoginResponse {
        return remoteDataSource.login(username, password)
    }

    suspend fun saveRefreshToken(token: String) {
        localDataSource.saveRefreshToken(token)
    }

    suspend fun saveAccessToken(token: String) {
        localDataSource.saveAccessToken(token)
    }
}
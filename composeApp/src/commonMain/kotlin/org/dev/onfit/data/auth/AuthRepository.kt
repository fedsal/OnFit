package org.dev.onfit.data.auth

import org.dev.onfit.domain.login.LoginResponse

class AuthRepository(
    private val remoteDataSource: AuthDataSource,
    private val localDataSource: AuthDataSource
) {
    suspend fun login(username: String, password: String): LoginResponse {
        return remoteDataSource.login(username, password)
    }

    suspend fun saveToken(token: String) {
        remoteDataSource.saveToken(token)
    }
}
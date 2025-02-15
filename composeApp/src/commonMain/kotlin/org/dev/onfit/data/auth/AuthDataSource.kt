package org.dev.onfit.data.auth

import org.dev.onfit.domain.login.LoginResponse

interface AuthDataSource {
    suspend fun login(username: String, password: String): LoginResponse
    suspend fun saveToken(token: String)
}
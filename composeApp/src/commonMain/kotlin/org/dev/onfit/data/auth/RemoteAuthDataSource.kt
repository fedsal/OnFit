package org.dev.onfit.data.auth

import org.dev.onfit.domain.login.LoginResponse

interface RemoteAuthDataSource {
    suspend fun login(username: String, password: String): LoginResponse
}
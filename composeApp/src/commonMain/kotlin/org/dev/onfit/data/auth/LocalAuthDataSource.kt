package org.dev.onfit.data.auth

interface LocalAuthDataSource {
    suspend fun getRefreshToken(): String?
    suspend fun saveRefreshToken(token: String): Boolean
    suspend fun getAccessToken(): String?
    suspend fun saveAccessToken(token: String): Boolean
    suspend fun logout(): Boolean
}
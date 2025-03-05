package org.dev.onfit.framework.ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.*
import org.dev.onfit.data.auth.RemoteAuthDataSource
import org.dev.onfit.domain.login.LoginRequest
import org.dev.onfit.domain.login.LoginResponse

class AuthRemoteDataSource(private val client: HttpClient): RemoteAuthDataSource {

    override suspend fun login(username: String, password: String): LoginResponse {
        val response = client.post("login") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(username, password))
        }
        if (!response.status.isSuccess())
            throw Exception("Error al iniciar sesión")
        return response.body()
    }
}

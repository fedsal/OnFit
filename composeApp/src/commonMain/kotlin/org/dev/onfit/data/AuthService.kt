package org.dev.onfit.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.*
import org.dev.onfit.domain.login.LoginRequest
import org.dev.onfit.domain.login.LoginResponse

class AuthService(private val client: HttpClient) {

    suspend fun login(username: String, password: String): LoginResponse {
        return client.post("/login") {
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(username, password))
        }.body()
    }

    companion object {
        const val BASE_URL = "http://localhost:8080"
    }
}

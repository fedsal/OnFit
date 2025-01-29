package org.dev.onfit.domain.login

import org.dev.onfit.domain.User
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String? = null,
    val expiresIn: Int? = null,
    val user: User? = null
)

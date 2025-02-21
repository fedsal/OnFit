package org.dev.onfit.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val email: String,
    val phone: String,
    val birthdate: String,
    val address: String,
    @SerialName("sport_center_id")
    val sportCenterId: Int,
)

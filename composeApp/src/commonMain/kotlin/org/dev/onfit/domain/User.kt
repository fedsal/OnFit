package com.dev.onfit.domain

data class User(
    val name: String,
    val email: String,
    val phone: String,
    val birthdate: String,
    val address: String,
    val sportCenterId: Int,
)

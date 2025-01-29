package org.dev.onfit.domain

data class SportCenter(
    val id: Int,
    val name: String,
    val description: String,
    val whatsapp: String,
    val coordinates: Coordinates,
)

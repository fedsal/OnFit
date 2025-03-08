package org.dev.onfit.ui.common

import androidx.compose.ui.platform.UriHandler
import io.ktor.http.URLBuilder

const val WHATSAPP_URI = "https://wa.me/"

fun openWhatsapp(
    phoneNumber: String,
    uriHandler: UriHandler
) {
    val url = URLBuilder(WHATSAPP_URI + phoneNumber).apply {
        parameters.append("text", "Hola, quisiera mas información sobre el gimnasio.")

    }.buildString()
    uriHandler.openUri(url)
}

const val GOOGLE_MAPS_URI = "https://www.google.com/maps/search/"

fun openSportCenterMaps(
    latitude: String,
    longitude: String,
    uriHandler: UriHandler
) {
    val url = URLBuilder(GOOGLE_MAPS_URI).apply {
        parameters.append("api", "1")
        parameters.append("query", "$latitude,$longitude")
    }.buildString()
    uriHandler.openUri(url)
}
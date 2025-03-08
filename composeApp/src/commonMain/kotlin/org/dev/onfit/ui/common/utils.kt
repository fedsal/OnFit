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
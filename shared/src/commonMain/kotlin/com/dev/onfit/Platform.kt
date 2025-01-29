package com.dev.onfit

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
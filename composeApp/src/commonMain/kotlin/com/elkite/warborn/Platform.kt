package com.elkite.warborn

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
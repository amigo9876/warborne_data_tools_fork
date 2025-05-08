package com.elkite.warborn.data.network

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val httpClient = HttpClient(getPlatformEngine()) {
    install(ContentNegotiation) {
        json(Json { ignoreUnknownKeys = true })
    }
}

package com.elkite.warborn.data.network

import io.ktor.client.engine.HttpClientEngineFactory

expect fun getPlatformEngine(): HttpClientEngineFactory<*>
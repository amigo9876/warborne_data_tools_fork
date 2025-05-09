package com.elkite.warborn

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.elkite.warborn.presentation.screen.main.MainScreen
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    Napier.base(DebugAntilog())

    MaterialTheme {
        MainScreen.Content()
    }
}
package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import kotlinx.browser.window
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
@Composable
actual fun CopyButton(
    textToCopy: String,
    buttonText: @Composable () -> Unit,
    modifier: Modifier,
) {
    Button(
        onClick = {
            val url = window.location.href
            window.navigator.clipboard.writeText(url) },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = WarborneColorTheme.textDescriptionColor,
            containerColor = WarborneColorTheme.textBackgroundColor,
        )
    ) {
        buttonText()
    }
}
package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import kotlinx.browser.window

@Composable
actual fun ClickableText(text: String) {
    GearStylizedText(text = text, color = WarborneColorTheme.textShieldColor, modifier = Modifier.clickable {
        window.location.href = text
    })
}
package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun CopyButton(
    textToCopy: String,
    buttonText: @Composable () -> Unit,
    modifier: Modifier = Modifier,
)
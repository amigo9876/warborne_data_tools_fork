package com.elkite.warborn.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.widgets.utils.isCompact

object WarborneSizeTheme {
    @Composable
    fun getIconSize(): Dp {
        return if (isCompact())
            48.dp
        else
            64.dp
    }

    @Composable
    fun getIconSizeSmall(): Dp {
        return if (isCompact())
            32.dp
        else
            48.dp
    }

}
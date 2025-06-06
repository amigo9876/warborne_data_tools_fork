package com.elkite.warborn.presentation.screen.patch.common

import androidx.compose.runtime.Composable
import com.elkite.warborn.presentation.screen.main.MainScreenModel

@Composable
expect fun PatchScreenCommon(
    state: MainScreenModel.BuildScreenState.Success
)
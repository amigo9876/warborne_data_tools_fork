package com.elkite.warborn.presentation.screen.search.common

import androidx.compose.runtime.Composable
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.screen.search.SearchScreenModel

@Composable
expect fun SearchScreenCommon(
    state: MainScreenModel.BuildScreenState.Success,
    searchScreenModel: SearchScreenModel
)
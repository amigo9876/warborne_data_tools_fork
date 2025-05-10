package com.elkite.warborn.presentation.widgets.loadout_from_url

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel
import kotlinx.browser.window

@Composable
actual fun LoadoutFromUrl(
    screenModel: BuildScreenModel,
    loadout: Loadout,
) {
    val queryParams = remember(loadout) { screenModel.loadout.value.toQueryParams() }
    var lastQueryParamsMap by remember { mutableStateOf<Map<String, String>>(emptyMap()) }

    if (queryParams != lastQueryParamsMap.entries.joinToString("&") { "${it.key}=${it.value}" }) {
        lastQueryParamsMap = queryParams.split("&")
            .mapNotNull {
                val parts = it.split("=")
                if (parts.size == 2) parts[0] to parts[1] else null
            }.toMap()
        window.history.replaceState(null, "", "?$queryParams")
    }

    screenModel.updateLoadoutFromUrl(window.location.href)
}
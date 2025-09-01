package com.elkite.warborn.presentation.widgets.loadout_from_url

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.elkite.warborn.domain.entities.old.Loadout
import kotlinx.browser.window

@Composable
actual fun LoadoutFromUrl(
    loadout: Loadout,
    onLoadoutUrlUpdate: (String) -> Unit,
) {
    val queryParams = remember(loadout) { loadout.toQueryParams() }
    var lastQueryParamsMap by remember { mutableStateOf<Map<String, String>>(emptyMap()) }

    if (queryParams != lastQueryParamsMap.entries.joinToString("&") { "${it.key}=${it.value}" }) {
        lastQueryParamsMap = queryParams.split("&")
            .mapNotNull {
                val parts = it.split("=")
                if (parts.size == 2) parts[0] to parts[1] else null
            }.toMap()
        window.history.replaceState(null, "", "?$queryParams")
    }

    onLoadoutUrlUpdate(window.location.href)
}
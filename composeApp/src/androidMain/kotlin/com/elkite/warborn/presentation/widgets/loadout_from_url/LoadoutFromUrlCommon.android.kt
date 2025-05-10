package com.elkite.warborn.presentation.widgets.loadout_from_url

import androidx.compose.runtime.Composable
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.presentation.screen.build_loadout.BuildScreenModel

@Composable
actual fun LoadoutFromUrl(
    screenModel: BuildScreenModel,
    loadout: Loadout,
) {
    screenModel.updateLoadoutFromUrl("")
}
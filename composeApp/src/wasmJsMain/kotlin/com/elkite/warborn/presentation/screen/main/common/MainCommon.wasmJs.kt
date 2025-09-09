package com.elkite.warborn.presentation.screen.main.common

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.presentation.screen.main.DescriptionColumn
import com.elkite.warborn.presentation.screen.main.ItemListColumn
import com.elkite.warborn.presentation.screen.main.LoadoutColumn
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.isMediumOrCompact
import com.elkite.warborn.util.DrifterResources
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun MainContent(
    screenModel: MainScreenModel,
    state: MainScreenModel.BuildScreenState.Success
) {
    val loadoutState = screenModel.loadout.collectAsState()
    val scrollableState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Crossfade(
            targetState = loadoutState.value.drifter,
            animationSpec = tween()
        ) { drifter ->
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(DrifterResources.getDrifterFullBodyBg(drifter = drifter?.gameId)),
                contentScale = Crop,
                alignment = Alignment.BottomCenter,
                alpha = 0.3f,
                contentDescription = null,
            )
        }

        GearStylizedText(
            text = "This app is not affiliated with or endorsed by QOOLAND",
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(16.dp).align(Alignment.BottomCenter)
        )
        FlowRow(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollableState),
            verticalArrangement = Arrangement.Top,
            horizontalArrangement = if (isMediumOrCompact()) Arrangement.SpaceAround else Arrangement.Start,
            maxItemsInEachRow = 3
        ) {
            LoadoutColumn(
                loadout = loadoutState.value,
                onLoadoutUrlUpdate = { url ->
                    screenModel.updateLoadoutFromUrl(url, state)
                },
                onSelectedLoadoutType = { type ->
                    screenModel.updateSelectedLoadout(type)
                }
            )

            ItemListColumn(
                state = state,
                loadout = loadoutState.value,
                onUpdateHeadGear = {
                    screenModel.updateHead(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.HEAD)
                },
                onUpdateChestGear = {
                    screenModel.updateChest(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.CHEST)
                },
                onUpdateBootsGear = {
                    screenModel.updateBoots(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.BOOTS)
                },
                onUpdateDrifter = {
                    screenModel.updateDrifter(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.DRIFTER)
                },
                onUpdateWeapon = { selectedWeaponType, weaponGear ->
                    screenModel.updateWeapon(weaponGear)
                    screenModel.updateSelectedLoadout(selectedWeaponType)
                },
                onUpdateModHead = {
                    screenModel.updateModHead(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.MOD_HEAD)
                },
                onUpdateModChest = {
                    screenModel.updateModChest(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.MOD_CHEST)
                },
                onUpdateModBoots = {
                    screenModel.updateModBoots(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.MOD_BOOTS)
                },
                onUpdateWeaponMod = {
                    screenModel.updateWeaponMod(it)
                    screenModel.updateSelectedLoadout(SelectedLoadoutType.MOD_WEAPON)
                },
            )

            DescriptionColumn(
                if (loadoutState.value.isEmpty())
                    loadoutState.value.copy(
                        drifter = state.data.drifters.strDrifters.first()
                    )
                else loadoutState.value
            )
        }
    }
}
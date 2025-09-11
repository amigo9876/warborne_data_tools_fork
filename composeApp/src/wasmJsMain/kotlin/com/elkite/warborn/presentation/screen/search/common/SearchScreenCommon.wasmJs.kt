package com.elkite.warborn.presentation.screen.search.common

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearSlot
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.screen.search.SearchScreenModel
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.search.SearchArmorCard
import com.elkite.warborn.presentation.widgets.search.SearchDrifterCard
import com.elkite.warborn.presentation.widgets.search.SearchMod
import com.elkite.warborn.presentation.widgets.search.SearchWeaponCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.util.DrifterResources
import org.jetbrains.compose.resources.painterResource

@Composable
actual fun SearchScreenCommon(
    state: MainScreenModel.BuildScreenState.Success,
    searchScreenModel: SearchScreenModel
) {
    val text = remember {
        mutableStateOf("")
    }
    val drifters = searchScreenModel.drifterFiltered.collectAsState()
    val weapons = searchScreenModel.weaponFiltered.collectAsState()
    val armor = searchScreenModel.armorFiltered.collectAsState()
    val mods = searchScreenModel.modFiltered.collectAsState()

    val filters = remember {
        mutableStateMapOf(
            GearSlot.DRIFTER to true,
            GearSlot.WEAPON to true,
            GearSlot.CONSUMABLE to true,
            GearSlot.MODS to true,
            GearSlot.HEAD to true
        )
    }

    LaunchedEffect(text.value + filters) {
            searchScreenModel.filterDrifters(text.value)
            searchScreenModel.filterWeapons(text.value)
            searchScreenModel.filterArmor(text.value)
            searchScreenModel.filterMods(text.value)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Crossfade(
            targetState = state.data,
            animationSpec = tween()
        ) { _ ->
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(DrifterResources.getDrifterFullBodyBg(drifter = null)),
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


        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Row(Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    value = text.value,
                    onValueChange = {
                        text.value = it
                    },
                    label = { GearStylizedText(text = "Search") },
                    textStyle = MaterialTheme.typography.body1.copy(
                        color = WarborneColorTheme.textDescriptionColor
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedLabelColor = WarborneColorTheme.textDescriptionColor,
                        focusedLabelColor = WarborneColorTheme.textDescriptionColor,
                        unfocusedIndicatorColor = WarborneColorTheme.textDescriptionColor,
                        focusedIndicatorColor = WarborneColorTheme.textDescriptionColor,
                        cursorColor = WarborneColorTheme.textDescriptionColor,
                        textColor = WarborneColorTheme.textDescriptionColor,
                        backgroundColor = WarborneColorTheme.textBackgroundColor
                    )
                )
                Spacer(Modifier.size(16.dp))
                Row {
                    GearStylizedText(text = "Filters:", modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp))
                    filters.forEach {
                        Filters(it) { filter ->
                           filters[filter] = !(filters[filter] ?: false)
                        }
                    }
                }
            }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 300.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                if (drifters.value.isNotEmpty()&& filters[GearSlot.DRIFTER] == true) {
                    items(drifters.value) {
                        SearchDrifterCard(
                            it.second,
                            it.first
                        )
                    }
                }

                if (weapons.value.isNotEmpty()&& filters[GearSlot.WEAPON] == true) {
                    items(weapons.value) {
                        SearchWeaponCard(
                            it.first,
                            it.second
                        )
                    }
                }

                if (armor.value.isNotEmpty()&& filters[GearSlot.HEAD] == true) {
                    items(armor.value) {
                        SearchArmorCard(
                            it.first,
                            it.second
                        )
                    }
                }

                if (mods.value.isNotEmpty() && filters[GearSlot.MODS] == true) {
                    items(mods.value) {
                        SearchMod(
                            modifier = Modifier,
                            it
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Filters(
    filter: Map.Entry<GearSlot, Boolean>, onClick: (GearSlot) -> Unit
) {
    FilterChip(
        onClick = {onClick(filter.key)},
        selected = filter.value,
        modifier = Modifier.padding(8.dp),
        content = {
            GearStylizedText(
                text = when (filter.key) {
                    GearSlot.DRIFTER -> "Drifters"
                    GearSlot.WEAPON -> "Weapons"
                    GearSlot.CONSUMABLE -> "Consumables"
                    GearSlot.MODS -> "Mods"
                    GearSlot.HEAD -> "Armors"
                    else -> "Other"
                }
            )
        },
        leadingIcon = if (filter.value) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else null,

    )
}
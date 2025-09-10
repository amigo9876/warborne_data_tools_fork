package com.elkite.warborn.presentation.screen.search.common

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.unit.dp
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

    LaunchedEffect(text.value) {
        searchScreenModel.filterWeapons(text.value)
        searchScreenModel.filterDrifters(text.value)
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

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 300.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                if (drifters.value.isNotEmpty()) {
                    items(drifters.value) {
                        SearchDrifterCard(
                            it.second,
                            it.first
                        )
                    }
                }

                if (weapons.value.isNotEmpty()) {
                    items(weapons.value) {
                        SearchWeaponCard(
                            it.first,
                            it.second
                        )
                    }
                }

                if (armor.value.isNotEmpty()) {
                    items(armor.value) {
                        SearchArmorCard(
                            it.first,
                            it.second
                        )
                    }
                }

                if (mods.value.isNotEmpty()) {
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
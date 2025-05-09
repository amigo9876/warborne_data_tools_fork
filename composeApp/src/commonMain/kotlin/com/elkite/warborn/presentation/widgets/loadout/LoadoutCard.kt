package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource


@Composable
fun LoadoutCardList(
    loadout: Loadout,
    onClick: (LoadoutType) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.DarkGray)
            .verticalScroll(rememberScrollState())
    ) {
        LoadoutCard(LoadoutType.HEAD, loadout.head, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.CHEST, loadout.chest, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.BOOTS, loadout.boots, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.WEAPON, loadout.weapon, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.PASSIVE, loadout.passive, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.BASIC_ATTACK, loadout.basicAttack, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.COMMON_SKILL, loadout.commonSkill, onClick)

    }
}

@Composable
fun LoadoutCard(
    loadoutType: LoadoutType,
    spell: Spell?,
    onClick: (LoadoutType) -> Unit,
) {
    Row {
        Box(modifier = Modifier.size(64.dp).clickable {
            onClick(loadoutType)
        }) {
            spell?.let {
                Icon(
                    painter = painterResource(
                        IconMap.getSkillIcon(
                            spell.associatedGearType,
                            spell.id
                        )
                    ),
                    contentDescription = "Home",
                    modifier = Modifier.size(64.dp),
                    tint = Color.Unspecified
                )
                Text(spell.name)
            } ?: Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Red)
            )
        }

        when (loadoutType) {
            LoadoutType.HEAD,
            LoadoutType.CHEST,
            LoadoutType.BOOTS,
            LoadoutType.WEAPON -> spell?.gearName?.let {
                Spacer(modifier = Modifier.size(16.dp))
                Box(modifier = Modifier.size(64.dp).clickable {
                    onClick(loadoutType)
                }) {
                    Icon(
                        painter = painterResource(
                            IconMap.getArmorIcon(
                                spell.associatedGearType,
                                spell.gearName
                            )
                        ),
                        contentDescription = "Home",
                        modifier = Modifier.size(64.dp),
                        tint = Color.Unspecified,
                    )
                }
            }

            else -> {
                // Handle other loadout types if needed
            }
        }

    }
}
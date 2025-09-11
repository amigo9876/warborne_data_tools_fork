package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.loadout.Loadout
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.isCompact
import com.elkite.warborn.presentation.widgets.utils.isMedium
import com.elkite.warborn.util.DrifterResources
import org.jetbrains.compose.resources.painterResource


@Composable
fun LoadoutCard(
    modifier: Modifier = Modifier,
    loadout: Loadout,
    onSelectedLoadoutType: (SelectedLoadoutType) -> Unit,
) {
    Column(
        modifier = modifier.wrapContentSize()
            .padding(16.dp)
    ) {
        Row {
            Box(
                modifier = Modifier
                    .height(if (isCompact() || isMedium()) 500.dp else 470.dp)
                    .width(if (isCompact() || isMedium()) 450.dp else 344.dp)
                    .clip(RectangleShape)
                    .border(
                        width = 3.dp,
                        brush = WarborneColorTheme.legendaryBrush,
                        shape = RectangleShape
                    )
                    .clickable { onSelectedLoadoutType(SelectedLoadoutType.DRIFTER) }
            ) {
                Crossfade(
                    targetState = loadout.drifter,
                    animationSpec = tween(1000)
                ) { drifter ->
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(DrifterResources.getDrifterCard(drifter = drifter?.gameId)),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
                if (isCompact() || isMedium())
                    ArmorLoadoutWithModColumn(
                        loadout, onSelectedLoadoutType
                    )
                GearStylizedTextTitle(
                    modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
                    text = loadout.drifter?.name ?: "Select drifter"
                )
            }
            if (!isCompact() && !isMedium()) {
                Spacer(modifier = Modifier.width(16.dp))
                ArmorLoadoutWithModColumn(
                    loadout, onSelectedLoadoutType
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier = Modifier.wrapContentSize()) {
            LoadoutWeaponBasicIcon(
                basicSpell = loadout.weapon?.activeBasicSpell
                    ?: loadout.weapon?.basicSpells?.first(),
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.BASIC_ATTACK,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.BASIC_ATTACK) },
                weaponType = loadout.weapon?.weaponType ?: WeaponType.sword,
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutWeaponCommonIcon(
                commonSpell = loadout.weapon?.activeCommonSpell
                    ?: loadout.weapon?.commonSpells?.first(),
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.COMMON_SKILL,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.COMMON_SKILL) },
                weaponType = loadout.weapon?.weaponType ?: WeaponType.sword,
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutWeaponSkillIcon(
                spell = loadout.weapon,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.WEAPON,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.WEAPON) },
                weaponType = loadout.weapon?.weaponType ?: WeaponType.sword,
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutDrifterSkillIcon(
                drifter = loadout.drifter,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.DRIFTER,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.DRIFTER) },
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutChestGearSkillIcon(
                chestGear = loadout.chest,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.CHEST,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.CHEST) },
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutBootsGearSkillIcon(
                bootsGear = loadout.boots,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.BOOTS,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.BOOTS) },
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Row(modifier = Modifier.wrapContentSize()) {
            LoadoutHeadGearSkillIcon(
                headGear = loadout.head,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.HEAD,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.HEAD) },
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutDrifterPassiveIcon(
                drifter = loadout.drifter,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.DRIFTER,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.DRIFTER) },
            )
            Spacer(modifier = Modifier.size(8.dp))
            LoadoutWeaponPassiveIcon(
                passiveSpell = loadout.weapon?.passiveSpell,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.PASSIVE,
                onClick = { onSelectedLoadoutType(SelectedLoadoutType.PASSIVE) },
                weaponType = loadout.weapon?.weaponType ?: WeaponType.sword,
            )
        }
    }
}

@Composable
private fun BoxScope.ArmorLoadoutWithModColumn(
    loadout: Loadout,
    onSelectedLoadoutType: (SelectedLoadoutType) -> Unit
) {
    Column(
        modifier = Modifier.align(Alignment.TopEnd).padding(top = 16.dp, end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutWeaponGearIcon(
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
                weaponGear = loadout.weapon,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.WEAPON)
                },
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.WEAPON
            )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutWeaponModIcon(
                mod = loadout.weaponMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_WEAPON,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_WEAPON)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp).background(Color.Black),
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutHeadGearIcon(
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.HEAD,
                headGear = loadout.head,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.HEAD)
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutArmorModIcon(
                mod = loadout.headMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_HEAD,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_HEAD)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutChestGearIcon(
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.CHEST,
                chestGear = loadout.chest,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.CHEST)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),

                )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutArmorModIcon(
                mod = loadout.chestMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_CHEST,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_CHEST)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),

                )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutBootsGearIcon(
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.BOOTS,
                bootsGear = loadout.boots,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.BOOTS)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),

                )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutArmorModIcon(
                mod = loadout.bootsMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_BOOTS,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_BOOTS)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),

                )
        }
        Spacer(modifier = Modifier.size(16.dp))

    }
}

@Composable
private fun ArmorLoadoutWithModColumn(
    loadout: Loadout,
    onSelectedLoadoutType: (SelectedLoadoutType) -> Unit
) {
    Column(modifier = Modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutWeaponGearIcon(
                modifier = Modifier.size(64.dp),
                weaponGear = loadout.weapon,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.WEAPON)
                },
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.WEAPON
            )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutWeaponModIcon(
                mod = loadout.weaponMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_WEAPON,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_WEAPON)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutHeadGearIcon(
                modifier = Modifier.size(64.dp),
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.HEAD,
                headGear = loadout.head,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.HEAD)
                }
            )

            Spacer(modifier = Modifier.size(16.dp))
            LoadoutArmorModIcon(
                mod = loadout.headMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_HEAD,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_HEAD)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutChestGearIcon(
                modifier = Modifier.size(64.dp),

                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.CHEST,
                chestGear = loadout.chest,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.CHEST)
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutArmorModIcon(
                mod = loadout.chestMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_CHEST,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_CHEST)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LoadoutBootsGearIcon(
                modifier = Modifier.size(64.dp),

                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.BOOTS,
                bootsGear = loadout.boots,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.BOOTS)
                }
            )
            Spacer(modifier = Modifier.size(16.dp))
            LoadoutArmorModIcon(
                mod = loadout.bootsMod,
                isSelected = loadout.selectedLoadoutType == SelectedLoadoutType.MOD_BOOTS,
                onClick = {
                    onSelectedLoadoutType(SelectedLoadoutType.MOD_BOOTS)
                },
                modifier = Modifier.size(if (isCompact()) 48.dp else 64.dp),
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}
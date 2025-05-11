package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.theme.WarborneTheme.borderSkillColor
import com.elkite.warborn.presentation.theme.WarborneTheme.textBackgroundColor
import com.elkite.warborn.presentation.widgets.drifter.DrifterIcon
import com.elkite.warborn.presentation.widgets.gear.ArmorImage
import com.elkite.warborn.presentation.widgets.spell.SpellIcon
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Nature_Common_Attack
import com.elkite.warborn.resources.ParagonPortrait_None
import com.elkite.warborn.resources.Res
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource


@Composable
fun LoadoutCardList(
    modifier: Modifier = Modifier,
    loadout: Loadout,
    onClick: (LoadoutType) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp).defaultMinSize(
            minWidth = 500.dp
        ).verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Black)
                .clip(MaterialTheme.shapes.small) // Clip to the border shape
                .border(
                    width = 3.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            WarborneTheme.drifterBorderStartColor,
                            WarborneTheme.drifterBorderMiddleColor,
                            WarborneTheme.drifterBorderEndColor
                        )
                    ),
                    shape = MaterialTheme.shapes.small
                )
                .paint(
                    painterResource(IconMap.getDrifterFullBodyBg(drifter = loadout.drifter)),
                    contentScale = ContentScale.None,
                    alignment = Alignment.BottomCenter,
                )
                .paint(
                    painterResource(IconMap.getDrifterFullBody(drifter = loadout.drifter)),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.BottomCenter,
                )
                .padding(16.dp)
        )
        {
            LoadoutDrifterCard(LoadoutType.DRIFTER, loadout.drifter, onClick)
            Spacer(Modifier.size(16.dp))
            LoadoutSpellCard(LoadoutType.HEAD, loadout.head, onClick)
            Spacer(Modifier.size(16.dp))
            LoadoutSpellCard(LoadoutType.CHEST, loadout.chest, onClick)
            Spacer(Modifier.size(16.dp))
            LoadoutSpellCard(LoadoutType.BOOTS, loadout.boots, onClick)
            Spacer(Modifier.size(16.dp))
            Row {
                LoadoutSpellCard(LoadoutType.WEAPON, loadout.weapon, onClick)
                LoadoutSpellCard(LoadoutType.BASIC_ATTACK, loadout.basicAttack, onClick)
                LoadoutSpellCard(LoadoutType.COMMON_SKILL, loadout.commonSkill, onClick)
                LoadoutSpellCard(LoadoutType.PASSIVE, loadout.passive, onClick)
            }
        }
        Column(modifier = Modifier.weight(1f)) {

        }
    }
}

@Composable
fun LoadoutDrifterCard(
    loadoutType: LoadoutType,
    drifter: Drifter?,
    onClick: (LoadoutType) -> Unit,
) {
    Row {
        Box(
            modifier = Modifier
                .size(64.dp)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            WarborneTheme.drifterBorderStartColor,
                            WarborneTheme.drifterBorderMiddleColor,
                            WarborneTheme.drifterBorderEndColor
                        )
                    ),
                    shape = RectangleShape // You can change this to a different shape if needed
                )
                .background(Color.Black)
                .clickable {
                    onClick(loadoutType)
                }) {
            drifter?.let {
                DrifterIcon(
                    modifier = Modifier.size(64.dp),
                    drifter = it
                )
            } ?: Image(
                painter = painterResource(Res.drawable.ParagonPortrait_None),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
                    .clip(CutCornerShape(16.dp))
            )
        }
    }
}

@Composable
fun LoadoutSpellCard(
    loadoutType: LoadoutType,
    spell: Spell?,
    onClick: (LoadoutType) -> Unit,
) {
    Row {
        ArmorIcon(loadoutType, spell, onClick)
        Spacer(Modifier.size(16.dp))
        SpellIconTransform(loadoutType, onClick, spell)
    }
}


@Composable
private fun ArmorIcon(
    loadoutType: LoadoutType,
    spell: Spell?,
    onClick: (LoadoutType) -> Unit
) {
    when (loadoutType) {
        LoadoutType.HEAD,
        LoadoutType.CHEST,
        LoadoutType.BOOTS,
        LoadoutType.WEAPON -> spell?.gearName?.let {
            Box(
                modifier = Modifier.size(64.dp).border(
                    width = 2.dp,
                    color = borderSkillColor,
                ).clickable {
                    onClick(loadoutType)
                }) {
                ArmorImage(modifier = Modifier.size(64.dp), spell = spell)
            }
        } ?: EmptyLoadout(loadoutType, onClick)

        else -> {}
    }
}

@Composable
private fun SpellIconTransform(
    loadoutType: LoadoutType,
    onClick: (LoadoutType) -> Unit,
    spell: Spell?
) {

    val modifier = when (loadoutType) {
        LoadoutType.PASSIVE -> Modifier
            .size(64.dp)
            .clip(CutCornerShape(16.dp))
            .border(
                width = 2.dp,
                color = borderSkillColor,
                shape = CutCornerShape(16.dp)
            )
            .background(Color.Black)
            .clickable {
                onClick(loadoutType)
            }

        else -> Modifier.size(64.dp)
            .background(Color.Black)
            .border(
                width = 2.dp,
                color = borderSkillColor,
            ).clickable {
                onClick(loadoutType)
            }
    }

    Box(
        modifier = modifier
    ) {
        spell?.let {
            SpellIcon(modifier = Modifier.size(64.dp), it)
        }
    }
}

@Composable
private fun EmptyLoadout(
    loadoutType: LoadoutType,
    onClick: (LoadoutType) -> Unit
) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .background(textBackgroundColor)
            .border(
                width = 2.dp,
                color = borderSkillColor,
                shape = if (loadoutType == LoadoutType.PASSIVE)
                    CutCornerShape(16.dp) else RectangleShape
            )
            .clickable { onClick(loadoutType) },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                when (loadoutType) {
                    LoadoutType.HEAD -> Res.drawable.Com_Head_Helmet
                    LoadoutType.CHEST -> Res.drawable.Com_Clothes_Armor
                    LoadoutType.BOOTS -> Res.drawable.Com_Shoes_Boots
                    LoadoutType.WEAPON -> Res.drawable.Com_Weapon_Sword
                    else -> Res.drawable.Nature_Common_Attack
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
                .let {
                    if (loadoutType == LoadoutType.PASSIVE)
                        return@let Modifier.clip(
                            CutCornerShape(16.dp)
                        )
                    it
                },
        )
    }
}


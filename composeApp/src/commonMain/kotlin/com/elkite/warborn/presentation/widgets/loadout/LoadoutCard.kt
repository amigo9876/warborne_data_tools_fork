package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.presentation.widgets.spell.SpellIcon
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Nature_Common_Attack
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource


@Composable
fun LoadoutCardList(
    modifier: Modifier = Modifier,
    loadout: Loadout,
    onClick: (LoadoutType) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
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
        LoadoutCard(LoadoutType.BASIC_ATTACK, loadout.basicAttack, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.COMMON_SKILL, loadout.commonSkill, onClick)
        Spacer(modifier = Modifier.size(16.dp))
        LoadoutCard(LoadoutType.PASSIVE, loadout.passive, onClick)
    }
}

@Composable
fun LoadoutCard(
    loadoutType: LoadoutType,
    spell: Spell?,
    onClick: (LoadoutType) -> Unit,
) {
    Row {
        SpellIconTransform(loadoutType, onClick, spell)
        Spacer(modifier = Modifier.size(16.dp))
        ArmorIcon(loadoutType, spell ?: return@Row, onClick)
    }
}

@Composable
private fun ArmorIcon(
    loadoutType: LoadoutType,
    spell: Spell,
    onClick: (LoadoutType) -> Unit
) {
    when (loadoutType) {
        LoadoutType.HEAD,
        LoadoutType.CHEST,
        LoadoutType.BOOTS,
        LoadoutType.WEAPON -> spell.gearName?.let {
            Box(modifier = Modifier.size(64.dp).clickable {
                onClick(loadoutType)
            }) {
                ArmorImage(modifier = Modifier.size(64.dp), spell = spell)
            }
        }

        else -> {}
    }
}

@Composable
private fun SpellIconTransform(
    loadoutType: LoadoutType,
    onClick: (LoadoutType) -> Unit,
    spell: Spell?
) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .let {
                if (loadoutType == LoadoutType.PASSIVE)
                    return@let Modifier.clip(
                        CutCornerShape(16.dp)
                    )
                it
            }
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = if (loadoutType == LoadoutType.PASSIVE)
                    CutCornerShape(16.dp) else RectangleShape
            )
            .clickable {
                onClick(loadoutType)
            }) {
        spell?.let {
           SpellIcon(modifier = Modifier.size(64.dp), it)
        } ?: EmptyLoadout(loadoutType)
    }
}

@Composable
private fun EmptyLoadout(loadoutType: LoadoutType) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .background(Color.LightGray)
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = if (loadoutType == LoadoutType.PASSIVE)
                    CutCornerShape(16.dp) else RectangleShape
            ),
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
            contentDescription = "Home",
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


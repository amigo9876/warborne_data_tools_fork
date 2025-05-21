package com.elkite.warborn.presentation.widgets.loadout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.presentation.theme.WarborneTheme.borderSkillColor
import com.elkite.warborn.presentation.theme.WarborneTheme.legendaryBrush
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Nature_Common_Attack
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun EmptyLoadout(
    isSelected: Boolean = false,
    loadoutType: LoadoutType,
    onClick: () -> Unit
) {
   val modifier = if (isSelected) {
       Modifier
           .size(64.dp)
           .border(
               width = 2.dp,
               brush = legendaryBrush,
               shape = when (loadoutType) {
                   LoadoutType.PASSIVE -> CutCornerShape(16.dp)
                   LoadoutType.HEAD,
                   LoadoutType.CHEST,
                   LoadoutType.BOOTS,
                   LoadoutType.WEAPON-> RectangleShape
                   else -> RectangleShape
               }
           )
           .clip(when (loadoutType) {
               LoadoutType.PASSIVE -> CutCornerShape(16.dp)
               LoadoutType.HEAD,
               LoadoutType.CHEST,
               LoadoutType.BOOTS,
               LoadoutType.WEAPON-> RectangleShape
               else -> RectangleShape
           })
           .background(Color.Black)
           .clickable { onClick() }
   } else {
       Modifier
           .size(64.dp)
           .border(
               width = 2.dp,
               color = borderSkillColor,
               shape = when (loadoutType) {
                   LoadoutType.PASSIVE -> CutCornerShape(16.dp)
                   LoadoutType.HEAD,
                   LoadoutType.CHEST,
                   LoadoutType.BOOTS,
                   LoadoutType.WEAPON-> RectangleShape
                   else -> RectangleShape
               }
           )
           .clip(when (loadoutType) {
               LoadoutType.PASSIVE -> CutCornerShape(16.dp)
               LoadoutType.HEAD,
               LoadoutType.CHEST,
               LoadoutType.BOOTS,
               LoadoutType.WEAPON-> RectangleShape
               else -> RectangleShape
           })
           .background(Color.Black)
           .clickable { onClick() }
   }

    Box(
        modifier = modifier,
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
            modifier = Modifier.size(48.dp)
                .let {
                    when (loadoutType) {
                        LoadoutType.PASSIVE -> return@let it.clip(CutCornerShape(16.dp))
                        LoadoutType.HEAD,
                        LoadoutType.CHEST,
                        LoadoutType.BOOTS,
                        LoadoutType.WEAPON -> return@let it.clip(CircleShape)
                        else -> it
                    }
                },
        )
    }
}

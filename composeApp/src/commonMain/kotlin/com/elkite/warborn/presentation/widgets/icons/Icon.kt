package com.elkite.warborn.presentation.widgets.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.mod.ModType
import com.elkite.warborn.domain.entities.spells.ISpell
import com.elkite.warborn.resources.ArmorEpic1
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.WeaponEpic1
import com.elkite.warborn.resources.equip_medicine_3_3
import com.elkite.warborn.util.BootsResources
import com.elkite.warborn.util.ChestResources
import com.elkite.warborn.util.ConsumableResources
import com.elkite.warborn.util.DrifterResources
import com.elkite.warborn.util.HeadResources
import com.elkite.warborn.util.ModResources
import com.elkite.warborn.util.weapons.AxeResources
import com.elkite.warborn.util.weapons.BowResources
import com.elkite.warborn.util.weapons.CurseResources
import com.elkite.warborn.util.weapons.DaggerResources
import com.elkite.warborn.util.weapons.FireResources
import com.elkite.warborn.util.weapons.FrostResources
import com.elkite.warborn.util.weapons.GunResources
import com.elkite.warborn.util.weapons.HolyResources
import com.elkite.warborn.util.weapons.MaceResources
import com.elkite.warborn.util.weapons.NatureResources
import com.elkite.warborn.util.weapons.SpearResources
import com.elkite.warborn.util.weapons.SwordResources
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HeadGearIcon(
    modifier: Modifier = Modifier.size(48.dp),
    headGear: HeadGear?,
    iconType: IconType
) {
    val drawableResource = when (headGear) {
        null -> when (iconType) {
            IconType.ARMOR -> HeadResources.getHeadSlotIcon()
            IconType.SKILL -> null
        }

        else -> {
            when (iconType) {
                IconType.ARMOR -> HeadResources.getHeadArmorIcon(
                    headGear.gearName,
                    headGear.category
                )

                IconType.SKILL -> HeadResources.getHeadSkillIcon(
                    headGear.spellId,
                    headGear.category
                )
            }
        }
    }
    Icon(
        modifier = if (headGear == null) modifier.padding(8.dp) else modifier,
        drawableResource = drawableResource
    )

}

@Composable
fun ChestGearIcon(
    modifier: Modifier = Modifier.size(48.dp),
    chestGear: ChestGear?,
    iconType: IconType
) {
    val drawableResource = when (chestGear) {
        null -> when (iconType) {
            IconType.ARMOR -> ChestResources.getChestSlotIcon()
            IconType.SKILL -> null
        }

        else -> {
            when (iconType) {
                IconType.ARMOR -> ChestResources.getChestArmorIcon(
                    chestGear.gearName,
                    chestGear.category
                )

                IconType.SKILL -> ChestResources.getChestSkillIcon(
                    chestGear.spellId,
                    chestGear.category
                )
            }
        }
    }
    Icon(
        modifier = if (chestGear == null) modifier.padding(8.dp) else modifier,
        drawableResource = drawableResource
    )
}

@Composable
fun BootsGearIcon(
    modifier: Modifier = Modifier.size(48.dp),
    bootsGear: BootsGear?,
    iconType: IconType
) {
    val drawableResource = when (bootsGear) {
        null -> when (iconType) {
            IconType.ARMOR -> BootsResources.getBootsSlotIcon()
            IconType.SKILL -> null
        }

        else -> {
            when (iconType) {
                IconType.ARMOR -> BootsResources.getBootsArmorIcon(
                    bootsGear.gearName,
                    bootsGear.category
                )

                IconType.SKILL -> BootsResources.getBootsSkillIcon(
                    bootsGear.spellId,
                    bootsGear.category
                )
            }
        }
    }
    Icon(
        modifier = if (bootsGear == null) modifier.padding(8.dp) else modifier,
        drawableResource = drawableResource
    )
}

@Composable
fun DrifterIcon(
    modifier: Modifier = Modifier.size(48.dp),
    drifterId: String?
) {
    Icon(
        drawableResource =
            DrifterResources.getDrifterIcon(
                drifterId
            ),
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun DrifterSpellIcon(
    modifier: Modifier = Modifier.size(48.dp),
    drifter: Drifter?,
) {
    if (drifter == null) {
        Icon(
            modifier = modifier,
            drawableResource = null
        )
        return
    } else
        Icon(
            modifier = modifier,
            drawableResource = DrifterResources.getDrifterSpell(drifter.spell.spellId)
        )
}

@Composable
fun DrifterPassiveIcon(
    modifier: Modifier = Modifier.size(48.dp),
    drifter: Drifter?,
) {
    if (drifter == null) {
        Icon(
            modifier = modifier,
            drawableResource = null
        )
        return
    } else
        Icon(
            modifier = modifier,
            drawableResource = DrifterResources.getDrifterPassive(drifter.passive.spellId)
        )
}

@Composable
fun WeaponSkillIcon(
    modifier: Modifier = Modifier.size(48.dp),
    spell: ISpell?,
    weaponType: WeaponType
) {
    Icon(
        modifier = modifier,
        drawableResource = if (spell == null) null else
            when (weaponType) {
                WeaponType.bow -> BowResources.getBowSkillIcon(spell.spellId)
                WeaponType.sword -> SwordResources.getSwordSkillIcon(spell.spellId)
                WeaponType.axe -> AxeResources.getAxeSkillIcon(spell.spellId)
                WeaponType.mace -> MaceResources.getMaceSkillIcon(spell.spellId)
                WeaponType.gun -> GunResources.getGunSkillIcon(spell.spellId)
                WeaponType.spear -> SpearResources.getSpearSkillIcon(spell.spellId)
                WeaponType.dagger -> DaggerResources.getDaggerSkillIcon(spell.spellId)
                WeaponType.nature -> NatureResources.getNatureSkillIcon(spell.spellId)
                WeaponType.fire -> FireResources.getFireSkillIcon(spell.spellId)
                WeaponType.frost -> FrostResources.getFrostSkillIcon(spell.spellId)
                WeaponType.curse -> CurseResources.getCurseSkillIcon(spell.spellId)
                WeaponType.holy -> HolyResources.getHolySkillIcon(spell.spellId)
            }
    )
}

@Composable
fun WeaponGearIcon(
    modifier: Modifier = Modifier.size(48.dp),
    weaponGear: WeaponGear?,
) {
    if (weaponGear == null) {
        Icon(
            modifier = modifier.padding(8.dp),
            drawableResource = SwordResources.getSwordSlotIcon()
        )
    } else {
        Icon(
            modifier = modifier,
            drawableResource = when (weaponGear.weaponType) {
                WeaponType.bow -> BowResources.getBowWeaponIcon(weaponGear.gearName)
                WeaponType.sword -> SwordResources.getSwordWeaponIcon(weaponGear.gearName)
                WeaponType.axe -> AxeResources.getAxeWeaponIcon(weaponGear.gearName)
                WeaponType.mace -> MaceResources.getMaceWeaponIcon(weaponGear.gearName)
                WeaponType.gun -> GunResources.getGunWeaponIcon(weaponGear.gearName)
                WeaponType.spear -> SpearResources.getSpearWeaponIcon(weaponGear.gearName)
                WeaponType.dagger -> DaggerResources.getDaggerWeaponIcon(weaponGear.gearName)
                WeaponType.nature -> NatureResources.getNatureWeaponIcon(weaponGear.gearName)
                WeaponType.fire -> FireResources.getFireWeaponIcon(weaponGear.gearName)
                WeaponType.frost -> FrostResources.getFrostWeaponIcon(weaponGear.gearName)
                WeaponType.curse -> CurseResources.getCurseWeaponIcon(weaponGear.gearName)
                WeaponType.holy -> HolyResources.getHolyWeaponIcon(weaponGear.gearName)
            }
        )
    }
}

@Composable
fun WeaponSlotIcon(
    modifier: Modifier = Modifier.size(48.dp),
    weaponType: WeaponType
) {
    Icon(
        modifier = modifier,
        drawableResource = when (weaponType) {
            WeaponType.bow -> BowResources.getBowSlotIcon()
            WeaponType.sword -> SwordResources.getSwordSlotIcon()
            WeaponType.axe -> AxeResources.getAxeSlotIcon()
            WeaponType.mace -> MaceResources.getMaceSlotIcon()
            WeaponType.gun -> GunResources.getGunSlotIcon()
            WeaponType.spear -> SpearResources.getSpearSlotIcon()
            WeaponType.dagger -> DaggerResources.getDaggerSlotIcon()
            WeaponType.nature -> NatureResources.getNatureSlotIcon()
            WeaponType.fire -> FireResources.getFireSlotIcon()
            WeaponType.frost -> FrostResources.getFrostSlotIcon()
            WeaponType.curse -> CurseResources.getCurseSlotIcon()
            WeaponType.holy -> HolyResources.getHolySlotIcon()
        }
    )
}

@Composable
fun ModIcon(
    modifier: Modifier = Modifier.size(48.dp),
    modType: ModType,
    modGameId: String?,
) {
    Icon(
        modifier = if (modGameId != null) modifier else modifier.padding(8.dp),
        drawableResource = if (modGameId == null) {
        if (modType == ModType.WEAPON)
            Res.drawable.WeaponEpic1
        else
            Res.drawable.ArmorEpic1
    } else {
        ModResources.getModIcon(modGameId)
    },
        colorFilter = if (modGameId == null) ColorFilter.tint(Color.White) else null
    )
}

@Composable
fun ConsumableIcon(
    modifier: Modifier = Modifier.size(48.dp),
    consumableGameId: String?,
) {
    Icon(
        modifier = if (consumableGameId != null) modifier else modifier.padding(8.dp),
        drawableResource = if (consumableGameId == null) {
            Res.drawable.equip_medicine_3_3
        } else {
            ConsumableResources.getConsumable(consumableGameId)
        },
        colorFilter = if (consumableGameId == null) ColorFilter.tint(Color.White) else null
    )
}

// Basic icon used by other types ^
@Composable
private fun Icon(
    modifier: Modifier = Modifier.size(48.dp),
    drawableResource: DrawableResource?,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null,
) {

        if (drawableResource == null)
            Box(modifier)
        else
            Image(
                painter = painterResource(drawableResource),
                contentDescription = null,
                modifier = modifier,
                contentScale = contentScale,
                colorFilter = colorFilter
            )
}
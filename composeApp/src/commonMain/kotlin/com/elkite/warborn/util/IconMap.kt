package com.elkite.warborn.util

import com.elkite.warborn.domain.entities.gear.Drifter
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.resources.Avatar_TotemPower
import com.elkite.warborn.resources.Axe_Common_Attack_SP_1
import com.elkite.warborn.resources.Axe_Common_Attack_SP_2
import com.elkite.warborn.resources.Axe_Common_Attack_SP_3
import com.elkite.warborn.resources.Axe_Common_Skill_1
import com.elkite.warborn.resources.Axe_Common_Skill_2_2
import com.elkite.warborn.resources.Axe_Common_Skill_3
import com.elkite.warborn.resources.Axe_Common_Skill_4
import com.elkite.warborn.resources.Axe_DoubleWhirl
import com.elkite.warborn.resources.Axe_Flywheel
import com.elkite.warborn.resources.Axe_GiantSwing
import com.elkite.warborn.resources.Axe_JumpSlash
import com.elkite.warborn.resources.Axe_Passive
import com.elkite.warborn.resources.Axe_Slayer
import com.elkite.warborn.resources.Axe_Throw
import com.elkite.warborn.resources.Axe_Whirlwind
import com.elkite.warborn.resources.Cloth_Str_1
import com.elkite.warborn.resources.Cloth_Str_2
import com.elkite.warborn.resources.Cloth_Str_3
import com.elkite.warborn.resources.Cloth_Str_4
import com.elkite.warborn.resources.Cloth_Str_5
import com.elkite.warborn.resources.Cloth_Str_6
import com.elkite.warborn.resources.Cloth_Str_8
import com.elkite.warborn.resources.EnhancementItem_ARMOR1
import com.elkite.warborn.resources.EnhancementItem_ARMOR2
import com.elkite.warborn.resources.EnhancementItem_ARMOR3
import com.elkite.warborn.resources.EnhancementItem_ARMOR4
import com.elkite.warborn.resources.EnhancementItem_ARMOR5
import com.elkite.warborn.resources.EnhancementItem_ARMOR6
import com.elkite.warborn.resources.EnhancementItem_ARMOR7
import com.elkite.warborn.resources.EnhancementItem_AXE1
import com.elkite.warborn.resources.EnhancementItem_AXE2
import com.elkite.warborn.resources.EnhancementItem_AXE3
import com.elkite.warborn.resources.EnhancementItem_AXE4
import com.elkite.warborn.resources.EnhancementItem_AXE5
import com.elkite.warborn.resources.EnhancementItem_AXE6
import com.elkite.warborn.resources.EnhancementItem_AXE7
import com.elkite.warborn.resources.EnhancementItem_BOOTS1
import com.elkite.warborn.resources.EnhancementItem_BOOTS2
import com.elkite.warborn.resources.EnhancementItem_BOOTS3
import com.elkite.warborn.resources.EnhancementItem_BOOTS4
import com.elkite.warborn.resources.EnhancementItem_BOOTS5
import com.elkite.warborn.resources.EnhancementItem_BOOTS6
import com.elkite.warborn.resources.EnhancementItem_BOOTS7
import com.elkite.warborn.resources.EnhancementItem_GUN1
import com.elkite.warborn.resources.EnhancementItem_GUN2
import com.elkite.warborn.resources.EnhancementItem_GUN3
import com.elkite.warborn.resources.EnhancementItem_GUN4
import com.elkite.warborn.resources.EnhancementItem_GUN5
import com.elkite.warborn.resources.EnhancementItem_GUN6
import com.elkite.warborn.resources.EnhancementItem_GUN7
import com.elkite.warborn.resources.EnhancementItem_HELMET1
import com.elkite.warborn.resources.EnhancementItem_HELMET2
import com.elkite.warborn.resources.EnhancementItem_HELMET3
import com.elkite.warborn.resources.EnhancementItem_HELMET4
import com.elkite.warborn.resources.EnhancementItem_HELMET5
import com.elkite.warborn.resources.EnhancementItem_HELMET6
import com.elkite.warborn.resources.EnhancementItem_HELMET7
import com.elkite.warborn.resources.EnhancementItem_MACE1
import com.elkite.warborn.resources.EnhancementItem_MACE2
import com.elkite.warborn.resources.EnhancementItem_MACE3
import com.elkite.warborn.resources.EnhancementItem_MACE4
import com.elkite.warborn.resources.EnhancementItem_MACE5
import com.elkite.warborn.resources.EnhancementItem_MACE6
import com.elkite.warborn.resources.EnhancementItem_MACE7
import com.elkite.warborn.resources.EnhancementItem_SWORD1
import com.elkite.warborn.resources.EnhancementItem_SWORD2
import com.elkite.warborn.resources.EnhancementItem_SWORD3
import com.elkite.warborn.resources.EnhancementItem_SWORD4
import com.elkite.warborn.resources.EnhancementItem_SWORD5
import com.elkite.warborn.resources.EnhancementItem_SWORD6
import com.elkite.warborn.resources.EnhancementItem_SWORD7
import com.elkite.warborn.resources.GunAttack_1
import com.elkite.warborn.resources.GunAttack_2
import com.elkite.warborn.resources.GunAttack_3
import com.elkite.warborn.resources.Gun_BulletCharge
import com.elkite.warborn.resources.Gun_Common_Skill_1
import com.elkite.warborn.resources.Gun_Common_Skill_3
import com.elkite.warborn.resources.Gun_Common_Skill_4
import com.elkite.warborn.resources.Gun_Common_Skill_5
import com.elkite.warborn.resources.Gun_Common_Skill_6
import com.elkite.warborn.resources.Gun_Flashbang
import com.elkite.warborn.resources.Gun_GatlinGun
import com.elkite.warborn.resources.Gun_Grenade
import com.elkite.warborn.resources.Gun_PrismGun
import com.elkite.warborn.resources.Gun_RifleGun
import com.elkite.warborn.resources.Gun_ShotGun
import com.elkite.warborn.resources.Gun_ThreeGun
import com.elkite.warborn.resources.Helm_Str_1
import com.elkite.warborn.resources.Helm_Str_3
import com.elkite.warborn.resources.Helm_Str_4
import com.elkite.warborn.resources.Helm_Str_5
import com.elkite.warborn.resources.Helm_Str_6
import com.elkite.warborn.resources.Helm_Str_7
import com.elkite.warborn.resources.Helm_Str_8
import com.elkite.warborn.resources.MaceAttack_1
import com.elkite.warborn.resources.MaceAttack_2
import com.elkite.warborn.resources.MaceAttack_3
import com.elkite.warborn.resources.Mace_1HandMace
import com.elkite.warborn.resources.Mace_CamlannMace
import com.elkite.warborn.resources.Mace_Common_Skill_1
import com.elkite.warborn.resources.Mace_Common_Skill_2
import com.elkite.warborn.resources.Mace_Common_Skill_3
import com.elkite.warborn.resources.Mace_Common_Skill_4
import com.elkite.warborn.resources.Mace_Common_Skill_5
import com.elkite.warborn.resources.Mace_Common_Skill_6
import com.elkite.warborn.resources.Mace_DualMace
import com.elkite.warborn.resources.Mace_Hook
import com.elkite.warborn.resources.Mace_Passive
import com.elkite.warborn.resources.Mace_ShieldMace_2
import com.elkite.warborn.resources.Mace_ThunderMace
import com.elkite.warborn.resources.ParagonFullBody_Dex_1
import com.elkite.warborn.resources.ParagonFullBody_Dex_2
import com.elkite.warborn.resources.ParagonFullBody_Dex_3
import com.elkite.warborn.resources.ParagonFullBody_Dex_4
import com.elkite.warborn.resources.ParagonFullBody_Dex_5
import com.elkite.warborn.resources.ParagonFullBody_Dex_6
import com.elkite.warborn.resources.ParagonFullBody_Dex_7
import com.elkite.warborn.resources.ParagonFullBody_Dex_8
import com.elkite.warborn.resources.ParagonFullBody_Dex_9
import com.elkite.warborn.resources.ParagonFullBody_Int_1
import com.elkite.warborn.resources.ParagonFullBody_Int_10
import com.elkite.warborn.resources.ParagonFullBody_Int_11
import com.elkite.warborn.resources.ParagonFullBody_Int_2
import com.elkite.warborn.resources.ParagonFullBody_Int_3
import com.elkite.warborn.resources.ParagonFullBody_Int_4
import com.elkite.warborn.resources.ParagonFullBody_Int_6
import com.elkite.warborn.resources.ParagonFullBody_Int_7
import com.elkite.warborn.resources.ParagonFullBody_Int_9
import com.elkite.warborn.resources.ParagonFullBody_None
import com.elkite.warborn.resources.ParagonFullBody_Str_1
import com.elkite.warborn.resources.ParagonFullBody_Str_2
import com.elkite.warborn.resources.ParagonFullBody_Str_3
import com.elkite.warborn.resources.ParagonFullBody_Str_4
import com.elkite.warborn.resources.ParagonFullBody_Str_5
import com.elkite.warborn.resources.ParagonFullBody_Str_6
import com.elkite.warborn.resources.ParagonFullBody_Str_7
import com.elkite.warborn.resources.ParagonFullBody_Str_8
import com.elkite.warborn.resources.ParagonFullBody_Str_9
import com.elkite.warborn.resources.ParagonPortrait_Dex_1
import com.elkite.warborn.resources.ParagonPortrait_Dex_2
import com.elkite.warborn.resources.ParagonPortrait_Dex_3
import com.elkite.warborn.resources.ParagonPortrait_Dex_4
import com.elkite.warborn.resources.ParagonPortrait_Dex_5
import com.elkite.warborn.resources.ParagonPortrait_Dex_6
import com.elkite.warborn.resources.ParagonPortrait_Dex_7
import com.elkite.warborn.resources.ParagonPortrait_Dex_8
import com.elkite.warborn.resources.ParagonPortrait_Dex_9
import com.elkite.warborn.resources.ParagonPortrait_Int_1
import com.elkite.warborn.resources.ParagonPortrait_Int_10
import com.elkite.warborn.resources.ParagonPortrait_Int_11
import com.elkite.warborn.resources.ParagonPortrait_Int_2
import com.elkite.warborn.resources.ParagonPortrait_Int_3
import com.elkite.warborn.resources.ParagonPortrait_Int_4
import com.elkite.warborn.resources.ParagonPortrait_Int_6
import com.elkite.warborn.resources.ParagonPortrait_Int_7
import com.elkite.warborn.resources.ParagonPortrait_Int_9
import com.elkite.warborn.resources.ParagonPortrait_None
import com.elkite.warborn.resources.ParagonPortrait_Str_1
import com.elkite.warborn.resources.ParagonPortrait_Str_2
import com.elkite.warborn.resources.ParagonPortrait_Str_3
import com.elkite.warborn.resources.ParagonPortrait_Str_4
import com.elkite.warborn.resources.ParagonPortrait_Str_5
import com.elkite.warborn.resources.ParagonPortrait_Str_6
import com.elkite.warborn.resources.ParagonPortrait_Str_7
import com.elkite.warborn.resources.ParagonPortrait_Str_8
import com.elkite.warborn.resources.ParagonPortrait_Str_9
import com.elkite.warborn.resources.Paragon_Skill_Dex_1
import com.elkite.warborn.resources.Paragon_Skill_Dex_1_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_2
import com.elkite.warborn.resources.Paragon_Skill_Dex_2_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_3
import com.elkite.warborn.resources.Paragon_Skill_Dex_3_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_4
import com.elkite.warborn.resources.Paragon_Skill_Dex_4_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_5
import com.elkite.warborn.resources.Paragon_Skill_Dex_5_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_6
import com.elkite.warborn.resources.Paragon_Skill_Dex_6_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_7
import com.elkite.warborn.resources.Paragon_Skill_Dex_7_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_8
import com.elkite.warborn.resources.Paragon_Skill_Dex_8_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_9
import com.elkite.warborn.resources.Paragon_Skill_Dex_9_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_1
import com.elkite.warborn.resources.Paragon_Skill_Int_10
import com.elkite.warborn.resources.Paragon_Skill_Int_10_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_11
import com.elkite.warborn.resources.Paragon_Skill_Int_11_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_1_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_2
import com.elkite.warborn.resources.Paragon_Skill_Int_2_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_3
import com.elkite.warborn.resources.Paragon_Skill_Int_3_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_4
import com.elkite.warborn.resources.Paragon_Skill_Int_4_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_6
import com.elkite.warborn.resources.Paragon_Skill_Int_6_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_7
import com.elkite.warborn.resources.Paragon_Skill_Int_7_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_9
import com.elkite.warborn.resources.Paragon_Skill_Int_9_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_1
import com.elkite.warborn.resources.Paragon_Skill_Str_1_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_2
import com.elkite.warborn.resources.Paragon_Skill_Str_2_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_3
import com.elkite.warborn.resources.Paragon_Skill_Str_3_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_4
import com.elkite.warborn.resources.Paragon_Skill_Str_4_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_5
import com.elkite.warborn.resources.Paragon_Skill_Str_5_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_6
import com.elkite.warborn.resources.Paragon_Skill_Str_6_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_7
import com.elkite.warborn.resources.Paragon_Skill_Str_7_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_8
import com.elkite.warborn.resources.Paragon_Skill_Str_8_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_9
import com.elkite.warborn.resources.Paragon_Skill_Str_9_Passive
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.Shoes_Str_1
import com.elkite.warborn.resources.Shoes_Str_2
import com.elkite.warborn.resources.Shoes_Str_3
import com.elkite.warborn.resources.Shoes_Str_4
import com.elkite.warborn.resources.Shoes_Str_5
import com.elkite.warborn.resources.Shoes_Str_6
import com.elkite.warborn.resources.Shoes_Str_7
import com.elkite.warborn.resources.SwordAttack_1
import com.elkite.warborn.resources.SwordAttack_2
import com.elkite.warborn.resources.SwordAttack_3
import com.elkite.warborn.resources.Sword_Carving
import com.elkite.warborn.resources.Sword_Clarent
import com.elkite.warborn.resources.Sword_Claymore
import com.elkite.warborn.resources.Sword_Common_Skill_1
import com.elkite.warborn.resources.Sword_Common_Skill_2
import com.elkite.warborn.resources.Sword_Common_Skill_3
import com.elkite.warborn.resources.Sword_Common_Skill_4
import com.elkite.warborn.resources.Sword_Common_Skill_5
import com.elkite.warborn.resources.Sword_KingSlash
import com.elkite.warborn.resources.Sword_Knight
import com.elkite.warborn.resources.Sword_Passive
import com.elkite.warborn.resources.Sword_ThousandBlade
import com.elkite.warborn.resources.Sword_ZeroSlash
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object IconMap {

    fun getDrifterIcon(drifter: Drifter?) : DrawableResource {
        return when (drifter?.gameId) {
            "paragon_str_1" -> Res.drawable.ParagonPortrait_Str_1
            "paragon_str_2" -> Res.drawable.ParagonPortrait_Str_2
            "paragon_str_3" -> Res.drawable.ParagonPortrait_Str_3
            "paragon_str_4" -> Res.drawable.ParagonPortrait_Str_4
            "paragon_str_5" -> Res.drawable.ParagonPortrait_Str_5
            "paragon_str_6" -> Res.drawable.ParagonPortrait_Str_6
            "paragon_str_7" -> Res.drawable.ParagonPortrait_Str_7
            "paragon_str_8" -> Res.drawable.ParagonPortrait_Str_8
            "paragon_str_9" -> Res.drawable.ParagonPortrait_Str_9
            "paragon_int_1" -> Res.drawable.ParagonPortrait_Int_1
            "paragon_int_2" -> Res.drawable.ParagonPortrait_Int_2
            "paragon_int_3" -> Res.drawable.ParagonPortrait_Int_3
            "paragon_int_4" -> Res.drawable.ParagonPortrait_Int_4
            "paragon_int_9" -> Res.drawable.ParagonPortrait_Int_9
            "paragon_int_6" -> Res.drawable.ParagonPortrait_Int_6
            "paragon_int_7" -> Res.drawable.ParagonPortrait_Int_7
            "paragon_int_11" -> Res.drawable.ParagonPortrait_Int_11
            "paragon_int_10" -> Res.drawable.ParagonPortrait_Int_10
            "paragon_dex_1" -> Res.drawable.ParagonPortrait_Dex_1
            "paragon_dex_2" -> Res.drawable.ParagonPortrait_Dex_2
            "paragon_dex_3" -> Res.drawable.ParagonPortrait_Dex_3
            "paragon_dex_4" -> Res.drawable.ParagonPortrait_Dex_4
            "paragon_dex_5" -> Res.drawable.ParagonPortrait_Dex_5
            "paragon_dex_6" -> Res.drawable.ParagonPortrait_Dex_6
            "paragon_dex_7" -> Res.drawable.ParagonPortrait_Dex_7
            "paragon_dex_8" -> Res.drawable.ParagonPortrait_Dex_8
            "paragon_dex_9" -> Res.drawable.ParagonPortrait_Dex_9
            null -> Res.drawable.ParagonPortrait_None
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterFullBody(drifter: Drifter?) : DrawableResource {
        return when (drifter?.gameId) {
            "paragon_str_1" -> Res.drawable.ParagonFullBody_Str_1
            "paragon_str_2" -> Res.drawable.ParagonFullBody_Str_2
            "paragon_str_3" -> Res.drawable.ParagonFullBody_Str_3
            "paragon_str_4" -> Res.drawable.ParagonFullBody_Str_4
            "paragon_str_5" -> Res.drawable.ParagonFullBody_Str_5
            "paragon_str_6" -> Res.drawable.ParagonFullBody_Str_6
            "paragon_str_7" -> Res.drawable.ParagonFullBody_Str_7
            "paragon_str_8" -> Res.drawable.ParagonFullBody_Str_8
            "paragon_str_9" -> Res.drawable.ParagonFullBody_Str_9
            "paragon_int_1" -> Res.drawable.ParagonFullBody_Int_1
            "paragon_int_2" -> Res.drawable.ParagonFullBody_Int_2
            "paragon_int_3" -> Res.drawable.ParagonFullBody_Int_3
            "paragon_int_4" -> Res.drawable.ParagonFullBody_Int_4
            "paragon_int_10" -> Res.drawable.ParagonFullBody_Int_10
            "paragon_int_6" -> Res.drawable.ParagonFullBody_Int_6
            "paragon_int_7" -> Res.drawable.ParagonFullBody_Int_7
            "paragon_int_11" -> Res.drawable.ParagonFullBody_Int_11
            "paragon_int_9" -> Res.drawable.ParagonFullBody_Int_9
            "paragon_dex_1" -> Res.drawable.ParagonFullBody_Dex_1
            "paragon_dex_2" -> Res.drawable.ParagonFullBody_Dex_2
            "paragon_dex_3" -> Res.drawable.ParagonFullBody_Dex_3
            "paragon_dex_4" -> Res.drawable.ParagonFullBody_Dex_4
            "paragon_dex_5" -> Res.drawable.ParagonFullBody_Dex_5
            "paragon_dex_6" -> Res.drawable.ParagonFullBody_Dex_6
            "paragon_dex_7" -> Res.drawable.ParagonFullBody_Dex_7
            "paragon_dex_8" -> Res.drawable.ParagonFullBody_Dex_8
            "paragon_dex_9" -> Res.drawable.ParagonFullBody_Dex_9
            null -> Res.drawable.ParagonFullBody_None
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterSpell(drifter: Drifter) : DrawableResource {
        return when (drifter.gameId) {
            "paragon_str_1" -> Res.drawable.Paragon_Skill_Str_1
            "paragon_str_2" -> Res.drawable.Paragon_Skill_Str_2
            "paragon_str_3" -> Res.drawable.Paragon_Skill_Str_3
            "paragon_str_4" -> Res.drawable.Paragon_Skill_Str_4
            "paragon_str_5" -> Res.drawable.Paragon_Skill_Str_5
            "paragon_str_6" -> Res.drawable.Paragon_Skill_Str_6
            "paragon_str_7" -> Res.drawable.Paragon_Skill_Str_7
            "paragon_str_8" -> Res.drawable.Paragon_Skill_Str_8
            "paragon_str_9" -> Res.drawable.Paragon_Skill_Str_9
            "paragon_dex_1" -> Res.drawable.Paragon_Skill_Dex_1
            "paragon_dex_2" -> Res.drawable.Paragon_Skill_Dex_2
            "paragon_dex_3" -> Res.drawable.Paragon_Skill_Dex_3
            "paragon_dex_4" -> Res.drawable.Paragon_Skill_Dex_4
            "paragon_dex_5" -> Res.drawable.Paragon_Skill_Dex_5
            "paragon_dex_6" -> Res.drawable.Paragon_Skill_Dex_6
            "paragon_dex_7" -> Res.drawable.Paragon_Skill_Dex_7
            "paragon_dex_8" -> Res.drawable.Paragon_Skill_Dex_8
            "paragon_dex_9" -> Res.drawable.Paragon_Skill_Dex_9
            "paragon_int_1" -> Res.drawable.Paragon_Skill_Int_1
            "paragon_int_2" -> Res.drawable.Paragon_Skill_Int_2
            "paragon_int_3" -> Res.drawable.Paragon_Skill_Int_3
            "paragon_int_4" -> Res.drawable.Paragon_Skill_Int_4
            "paragon_int_10" -> Res.drawable.Paragon_Skill_Int_10
            "paragon_int_6" -> Res.drawable.Paragon_Skill_Int_6
            "paragon_int_7" -> Res.drawable.Paragon_Skill_Int_7
            "paragon_int_11" -> Res.drawable.Paragon_Skill_Int_11
            "paragon_int_9" -> Res.drawable.Paragon_Skill_Int_9
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterPassive(drifter: Drifter) : DrawableResource {
        return when (drifter.gameId) {
            "paragon_str_1" -> Res.drawable.Paragon_Skill_Str_1_Passive
            "paragon_str_2" -> Res.drawable.Paragon_Skill_Str_2_Passive
            "paragon_str_3" -> Res.drawable.Paragon_Skill_Str_3_Passive
            "paragon_str_4" -> Res.drawable.Paragon_Skill_Str_4_Passive
            "paragon_str_5" -> Res.drawable.Paragon_Skill_Str_5_Passive
            "paragon_str_6" -> Res.drawable.Paragon_Skill_Str_6_Passive
            "paragon_str_7" -> Res.drawable.Paragon_Skill_Str_7_Passive
            "paragon_str_8" -> Res.drawable.Paragon_Skill_Str_8_Passive
            "paragon_str_9" -> Res.drawable.Paragon_Skill_Str_9_Passive
            "paragon_dex_1" -> Res.drawable.Paragon_Skill_Dex_1_Passive
            "paragon_dex_2" -> Res.drawable.Paragon_Skill_Dex_2_Passive
            "paragon_dex_3" -> Res.drawable.Paragon_Skill_Dex_3_Passive
            "paragon_dex_4" -> Res.drawable.Paragon_Skill_Dex_4_Passive
            "paragon_dex_5" -> Res.drawable.Paragon_Skill_Dex_5_Passive
            "paragon_dex_6" -> Res.drawable.Paragon_Skill_Dex_6_Passive
            "paragon_dex_7" -> Res.drawable.Paragon_Skill_Dex_7_Passive
            "paragon_dex_8" -> Res.drawable.Paragon_Skill_Dex_8_Passive
            "paragon_dex_9" -> Res.drawable.Paragon_Skill_Dex_9_Passive
            "paragon_int_1" -> Res.drawable.Paragon_Skill_Int_1_Passive
            "paragon_int_2" -> Res.drawable.Paragon_Skill_Int_2_Passive
            "paragon_int_3" -> Res.drawable.Paragon_Skill_Int_3_Passive
            "paragon_int_4" -> Res.drawable.Paragon_Skill_Int_4_Passive
            "paragon_int_10" -> Res.drawable.Paragon_Skill_Int_10_Passive
            "paragon_int_6" -> Res.drawable.Paragon_Skill_Int_6_Passive
            "paragon_int_7" -> Res.drawable.Paragon_Skill_Int_7_Passive
            "paragon_int_11" -> Res.drawable.Paragon_Skill_Int_11_Passive
            "paragon_int_9" -> Res.drawable.Paragon_Skill_Int_9_Passive
            else -> Res.drawable.error_emoji
        }
    }

    fun getSkillIcon(gearType: GearType, id: String) : DrawableResource {
        return when (gearType) {
            GearType.HEAD -> getSkillHeadIcon(id)
            GearType.CHEST -> getSkillChestIcon(id)
            GearType.BOOTS -> getSkillBootsIcon(id)
            GearType.SWORD -> getSkillSwordIcon(id)
            GearType.GUN -> getSkillGunIcon(id)
            GearType.AXE -> getSkillAxeIcon(id)
            GearType.MACE -> getSkillMaceIcon(id)
            else -> Res.drawable.error_emoji
        }
    }

    fun getWeaponIcon(gearType: GearType) : DrawableResource {
        return when (gearType) {
            GearType.SWORD -> Res.drawable.EnhancementItem_SWORD4
            GearType.GUN -> Res.drawable.EnhancementItem_GUN1
            GearType.AXE -> Res.drawable.EnhancementItem_AXE2
            GearType.MACE -> Res.drawable.EnhancementItem_MACE1
            else -> Res.drawable.error_emoji
        }
    }

    fun getArmorIcon(gearType: GearType, id: String): DrawableResource {
        return when (gearType) {
            GearType.HEAD -> getArmorHeadIcon(id)
            GearType.CHEST -> getArmorChestIcon(id)
            GearType.BOOTS -> getArmorBootsIcon(id)
            GearType.SWORD -> getArmorSwordIcon(id)
            GearType.GUN -> getArmorGunIcon(id)
            GearType.AXE -> getArmorAxeIcon(id)
            GearType.MACE -> getArmorMaceIcon(id)
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorHeadIcon(id: String): DrawableResource {
        return when (id) {
            "Furor's Helm" -> Res.drawable.EnhancementItem_HELMET3
            "Ironclad Helm" -> Res.drawable.EnhancementItem_HELMET6
            "Hellfire Visor" -> Res.drawable.EnhancementItem_HELMET2
            "Reptilian Helm" -> Res.drawable.EnhancementItem_HELMET4
            "Savage Helm" -> Res.drawable.EnhancementItem_HELMET1
            "Stormveil Mask" -> Res.drawable.EnhancementItem_HELMET5
            "Warden's Gaze" -> Res.drawable.EnhancementItem_HELMET7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorChestIcon(id: String): DrawableResource {
        return when (id) {
            "Guardian's Blessing" -> Res.drawable.EnhancementItem_ARMOR4
            "Aegis Plate" -> Res.drawable.EnhancementItem_ARMOR1
            "Dazzling Guard" -> Res.drawable.EnhancementItem_ARMOR2
            "Tempest Charge" -> Res.drawable.EnhancementItem_ARMOR6
            "Tangle Guard" -> Res.drawable.EnhancementItem_ARMOR7
            "Warden's Shell" -> Res.drawable.EnhancementItem_ARMOR3
            "Magsurge Armor" -> Res.drawable.EnhancementItem_ARMOR5
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorBootsIcon(id: String): DrawableResource {
        return when (id) {
            "Energizer Boots" -> Res.drawable.EnhancementItem_BOOTS4
            "Wrathstep" -> Res.drawable.EnhancementItem_BOOTS5
            "Bulwark Striders" -> Res.drawable.EnhancementItem_BOOTS1
            "Titan Walkers" -> Res.drawable.EnhancementItem_BOOTS2
            "Vanguard's March" -> Res.drawable.EnhancementItem_BOOTS6
            "Impact Heavy Boots" -> Res.drawable.EnhancementItem_BOOTS3
            "Avalanche Boots" -> Res.drawable.EnhancementItem_BOOTS7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorSwordIcon(id: String): DrawableResource {
        return when (id) {
            "Storm Cleaver" -> Res.drawable.EnhancementItem_SWORD4
            "Hellcore Cleaver" -> Res.drawable.EnhancementItem_SWORD1
            "Voidblade" -> Res.drawable.EnhancementItem_SWORD3
            "Lordbreaker" -> Res.drawable.EnhancementItem_SWORD5
            "Titan's Spineblade" -> Res.drawable.EnhancementItem_SWORD6
            "Judicator" -> Res.drawable.EnhancementItem_SWORD2
            "Sovereign's Radiance" -> Res.drawable.EnhancementItem_SWORD7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorGunIcon(id: String): DrawableResource {
        return when (id) {
            "Shattercoil" -> Res.drawable.EnhancementItem_GUN1
            "Sentinel Barrage" -> Res.drawable.EnhancementItem_GUN2
            "Spectral Assault" -> Res.drawable.EnhancementItem_GUN3
            "Blightspitter" -> Res.drawable.EnhancementItem_GUN4
            "Luminet Cannon" -> Res.drawable.EnhancementItem_GUN6
            "Voideye" -> Res.drawable.EnhancementItem_GUN5
            "Prism Cloak" -> Res.drawable.EnhancementItem_GUN7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorAxeIcon(id: String): DrawableResource {
        return when (id) {
            "Berserker's Fury" -> Res.drawable.EnhancementItem_AXE2
            "Emerald Edge" -> Res.drawable.EnhancementItem_AXE1
            "Ravager's Cleave" -> Res.drawable.EnhancementItem_AXE6
            "Bonefang Reaper" -> Res.drawable.EnhancementItem_AXE7
            "Cyclone Cleave" -> Res.drawable.EnhancementItem_AXE4
            "Wreckingsaw" -> Res.drawable.EnhancementItem_AXE5
            "Wingblade" -> Res.drawable.EnhancementItem_AXE3
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorMaceIcon(id: String): DrawableResource {
        return when (id) {
            "Breaker's Resolve" -> Res.drawable.EnhancementItem_MACE1
            "Gravity Hammer" -> Res.drawable.EnhancementItem_MACE2
            "Voidbreaker" -> Res.drawable.EnhancementItem_MACE3
            "Ripper's Grasp" -> Res.drawable.EnhancementItem_MACE4
            "Bulwark Core" -> Res.drawable.EnhancementItem_MACE6
            "Abyssal Conduit" -> Res.drawable.EnhancementItem_MACE5
            "Thunderlord's Wrath" -> Res.drawable.EnhancementItem_MACE7
            else -> Res.drawable.error_emoji
        }
    }


    private fun getSkillWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "SwordAttack_1" -> Res.drawable.SwordAttack_1
            "SwordAttack_2" -> Res.drawable.SwordAttack_2
            "SwordAttack_3" -> Res.drawable.SwordAttack_3
            "Sword_Common_Skill_1" -> Res.drawable.Sword_Common_Skill_1
            "Sword_Common_Skill_3" -> Res.drawable.Sword_Common_Skill_3
            "Sword_Common_Skill_4" -> Res.drawable.Sword_Common_Skill_4
            "Sword_Common_Skill_5" -> Res.drawable.Sword_Common_Skill_5
            "Sword_Common_Skill_2" -> Res.drawable.Sword_Common_Skill_2
            "Sword_ZeroSlash" -> Res.drawable.Sword_ZeroSlash
            "Sword_Passive" -> Res.drawable.Sword_Passive
            "Sword_Claymore" -> Res.drawable.Sword_Claymore
            "Sword_Clarent" -> Res.drawable.Sword_Clarent
            "Sword_KingSlash" -> Res.drawable.Sword_KingSlash
            "Sword_Knight" -> Res.drawable.Sword_Knight
            "Sword_Carving" -> Res.drawable.Sword_Carving
            "Sword_ThousandBlade" -> Res.drawable.Sword_ThousandBlade

            "GunAttack_1" -> Res.drawable.GunAttack_1
            "GunAttack_2" -> Res.drawable.GunAttack_2
            "GunAttack_3" -> Res.drawable.GunAttack_3
            "Gun_Common_Skill_1" -> Res.drawable.Gun_Common_Skill_1
            "Gun_Common_Skill_6" -> Res.drawable.Gun_Common_Skill_6
            "Gun_Common_Skill_4" -> Res.drawable.Gun_Common_Skill_4
            "Gun_Flashbang" -> Res.drawable.Gun_Flashbang
            "Gun_Common_Skill_3" -> Res.drawable.Gun_Common_Skill_3
            "Gun_ShotGun" -> Res.drawable.Gun_ShotGun
            "Gun_BulletCharge" -> Res.drawable.Gun_BulletCharge
            "Gun_GatlinGun" -> Res.drawable.Gun_GatlinGun
            "Gun_ThreeGun" -> Res.drawable.Gun_ThreeGun
            "Gun_Grenade" -> Res.drawable.Gun_Grenade
            "Gun_Common_Skill_5" -> Res.drawable.Gun_Common_Skill_5
            "Gun_RifleGun" -> Res.drawable.Gun_RifleGun
            "Gun_PrismGun" -> Res.drawable.Gun_PrismGun

            "Axe_Common_Attack_SP_1" -> Res.drawable.Axe_Common_Attack_SP_1
            "Axe_Common_Attack_SP_2" -> Res.drawable.Axe_Common_Attack_SP_2
            "Axe_Common_Attack_SP_3" -> Res.drawable.Axe_Common_Attack_SP_3
            "Avatar_TotemPower" -> Res.drawable.Avatar_TotemPower
            "Axe_Common_Skill_2_2" -> Res.drawable.Axe_Common_Skill_2_2
            "Axe_Common_Skill_4" -> Res.drawable.Axe_Common_Skill_4
            "Axe_Common_Skill_6" -> Res.drawable.Axe_Common_Skill_3
            "Axe_Common_Skill_1" -> Res.drawable.Axe_Common_Skill_1
            "Axe_Whirlwind" -> Res.drawable.Axe_Whirlwind
            "Axe_Passive" -> Res.drawable.Axe_Passive
            "Axe_Throw" -> Res.drawable.Axe_Throw
            "Axe_Slayer" -> Res.drawable.Axe_Slayer
            "Axe_JumpSlash" -> Res.drawable.Axe_JumpSlash
            "Axe_GiantSwing" -> Res.drawable.Axe_GiantSwing
            "Axe_Flywheel" -> Res.drawable.Axe_Flywheel
            "Axe_DoubleWhirl" -> Res.drawable.Axe_DoubleWhirl

            "MaceAttack_2" -> Res.drawable.MaceAttack_2
            "MaceAttack_1" -> Res.drawable.MaceAttack_1
            "MaceAttack_3" -> Res.drawable.MaceAttack_3
            "Mace_Common_Skill_6" -> Res.drawable.Mace_Common_Skill_6
            "Mace_Common_Skill_3" -> Res.drawable.Mace_Common_Skill_3
            "Mace_Common_Skill_1" -> Res.drawable.Mace_Common_Skill_1
            "Mace_Common_Skill_2" -> Res.drawable.Mace_Common_Skill_2
            "Mace_Common_Skill_4" -> Res.drawable.Mace_Common_Skill_4
            "Mace_1HandMace" -> Res.drawable.Mace_1HandMace
            "Mace_Passive" -> Res.drawable.Mace_Passive
            "Mace_Common_Skill_5" -> Res.drawable.Mace_Common_Skill_5
            "Mace_DualMace" -> Res.drawable.Mace_DualMace
            "Mace_Hook" -> Res.drawable.Mace_Hook
            "Mace_ShieldMace_2" -> Res.drawable.Mace_ShieldMace_2
            "Mace_CamlannMace" -> Res.drawable.Mace_CamlannMace
            "Mace_ThunderMace" -> Res.drawable.Mace_ThunderMace

            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillHeadIcon(id: String): DrawableResource {
        return when (id) {
            "Helm_Str_8" -> Res.drawable.Helm_Str_8
            "Helm_Str_7" -> Res.drawable.Helm_Str_7
            "Helm_Str_6" -> Res.drawable.Helm_Str_6
            "Helm_Str_5" -> Res.drawable.Helm_Str_5
            "Helm_Str_4" -> Res.drawable.Helm_Str_4
            "Helm_Str_3" -> Res.drawable.Helm_Str_3
            "Helm_Str_1" -> Res.drawable.Helm_Str_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillChestIcon(id: String): DrawableResource {
        return when (id) {
            "Cloth_Str_8" -> Res.drawable.Cloth_Str_8
            "Cloth_Str_6" -> Res.drawable.Cloth_Str_6
            "Cloth_Str_5" -> Res.drawable.Cloth_Str_5
            "Cloth_Str_4" -> Res.drawable.Cloth_Str_4
            "Cloth_Str_3" -> Res.drawable.Cloth_Str_3
            "Cloth_Str_2" -> Res.drawable.Cloth_Str_2
            "Cloth_Str_1" -> Res.drawable.Cloth_Str_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillBootsIcon(id: String): DrawableResource {
        return when (id) {
            "Shoes_Str_7" -> Res.drawable.Shoes_Str_7
            "Shoes_Str_6" -> Res.drawable.Shoes_Str_6
            "Shoes_Str_5" -> Res.drawable.Shoes_Str_5
            "Shoes_Str_4" -> Res.drawable.Shoes_Str_4
            "Shoes_Str_3" -> Res.drawable.Shoes_Str_3
            "Shoes_Str_2" -> Res.drawable.Shoes_Str_2
            "Shoes_Str_1" -> Res.drawable.Shoes_Str_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillSwordIcon(id: String): DrawableResource {
        return when (id) {
            "SwordAttack_1" -> Res.drawable.SwordAttack_1
            "SwordAttack_2" -> Res.drawable.SwordAttack_2
            "SwordAttack_3" -> Res.drawable.SwordAttack_3
            "Sword_Common_Skill_1" -> Res.drawable.Sword_Common_Skill_1
            "Sword_Common_Skill_3" -> Res.drawable.Sword_Common_Skill_3
            "Sword_Common_Skill_4" -> Res.drawable.Sword_Common_Skill_4
            "Sword_Common_Skill_5" -> Res.drawable.Sword_Common_Skill_5
            "Sword_Common_Skill_2" -> Res.drawable.Sword_Common_Skill_2
            "Sword_ZeroSlash" -> Res.drawable.Sword_ZeroSlash
            "Sword_Passive" -> Res.drawable.Sword_Passive
            "Sword_Claymore" -> Res.drawable.Sword_Claymore
            "Sword_Clarent" -> Res.drawable.Sword_Clarent
            "Sword_KingSlash" -> Res.drawable.Sword_KingSlash
            "Sword_Knight" -> Res.drawable.Sword_Knight
            "Sword_Carving" -> Res.drawable.Sword_Carving
            "Sword_ThousandBlade" -> Res.drawable.Sword_ThousandBlade
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillGunIcon(id: String): DrawableResource {
        return when (id) {
            "GunAttack_1" -> Res.drawable.GunAttack_1
            "GunAttack_2" -> Res.drawable.GunAttack_2
            "GunAttack_3" -> Res.drawable.GunAttack_3
            "Gun_Common_Skill_1" -> Res.drawable.Gun_Common_Skill_1
            "Gun_Common_Skill_6" -> Res.drawable.Gun_Common_Skill_6
            "Gun_Common_Skill_4" -> Res.drawable.Gun_Common_Skill_4
            "Gun_Flashbang" -> Res.drawable.Gun_Flashbang
            "Gun_Common_Skill_3" -> Res.drawable.Gun_Common_Skill_3
            "Gun_ShotGun" -> Res.drawable.Gun_ShotGun
            "Gun_BulletCharge" -> Res.drawable.Gun_BulletCharge
            "Gun_GatlinGun" -> Res.drawable.Gun_GatlinGun
            "Gun_ThreeGun" -> Res.drawable.Gun_ThreeGun
            "Gun_Grenade" -> Res.drawable.Gun_Grenade
            "Gun_Common_Skill_5" -> Res.drawable.Gun_Common_Skill_5
            "Gun_RifleGun" -> Res.drawable.Gun_RifleGun
            "Gun_PrismGun" -> Res.drawable.Gun_PrismGun
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillAxeIcon(id: String): DrawableResource {
        return when (id) {
            "Axe_Common_Attack_SP_1" -> Res.drawable.Axe_Common_Attack_SP_1
            "Axe_Common_Attack_SP_2" -> Res.drawable.Axe_Common_Attack_SP_2
            "Axe_Common_Attack_SP_3" -> Res.drawable.Axe_Common_Attack_SP_3
            "Avatar_TotemPower" -> Res.drawable.Avatar_TotemPower
            "Axe_Common_Skill_2_2" -> Res.drawable.Axe_Common_Skill_2_2
            "Axe_Common_Skill_4" -> Res.drawable.Axe_Common_Skill_4
            "Axe_Common_Skill_6" -> Res.drawable.Axe_Common_Skill_3
            "Axe_Common_Skill_1" -> Res.drawable.Axe_Common_Skill_1
            "Axe_Whirlwind" -> Res.drawable.Axe_Whirlwind
            "Axe_Passive" -> Res.drawable.Axe_Passive
            "Axe_Throw" -> Res.drawable.Axe_Throw
            "Axe_Slayer" -> Res.drawable.Axe_Slayer
            "Axe_JumpSlash" -> Res.drawable.Axe_JumpSlash
            "Axe_GiantSwing" -> Res.drawable.Axe_GiantSwing
            "Axe_Flywheel" -> Res.drawable.Axe_Flywheel
            "Axe_DoubleWhirl" -> Res.drawable.Axe_DoubleWhirl
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillMaceIcon(id: String): DrawableResource {
        return when (id) {
            "MaceAttack_2" -> Res.drawable.MaceAttack_2
            "MaceAttack_1" -> Res.drawable.MaceAttack_1
            "MaceAttack_3" -> Res.drawable.MaceAttack_3
            "Mace_Common_Skill_6" -> Res.drawable.Mace_Common_Skill_6
            "Mace_Common_Skill_3" -> Res.drawable.Mace_Common_Skill_3
            "Mace_Common_Skill_1" -> Res.drawable.Mace_Common_Skill_1
            "Mace_Common_Skill_2" -> Res.drawable.Mace_Common_Skill_2
            "Mace_Common_Skill_4" -> Res.drawable.Mace_Common_Skill_4
            "Mace_1HandMace" -> Res.drawable.Mace_1HandMace
            "Mace_Passive" -> Res.drawable.Mace_Passive
            "Mace_Common_Skill_5" -> Res.drawable.Mace_Common_Skill_5
            "Mace_DualMace" -> Res.drawable.Mace_DualMace
            "Mace_Hook" -> Res.drawable.Mace_Hook
            "Mace_ShieldMace_2" -> Res.drawable.Mace_ShieldMace_2
            "Mace_CamlannMace" -> Res.drawable.Mace_CamlannMace
            "Mace_ThunderMace" -> Res.drawable.Mace_ThunderMace
            else -> Res.drawable.error_emoji
        }
    }

}
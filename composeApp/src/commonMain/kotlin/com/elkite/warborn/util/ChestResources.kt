package com.elkite.warborn.util

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.resources.Cloth_Dex_1
import com.elkite.warborn.resources.Cloth_Dex_2
import com.elkite.warborn.resources.Cloth_Dex_3
import com.elkite.warborn.resources.Cloth_Dex_4
import com.elkite.warborn.resources.Cloth_Dex_5
import com.elkite.warborn.resources.Cloth_Dex_6
import com.elkite.warborn.resources.Cloth_Dex_7
import com.elkite.warborn.resources.Cloth_Int_1
import com.elkite.warborn.resources.Cloth_Int_10
import com.elkite.warborn.resources.Cloth_Int_2
import com.elkite.warborn.resources.Cloth_Int_3
import com.elkite.warborn.resources.Cloth_Int_5
import com.elkite.warborn.resources.Cloth_Int_7
import com.elkite.warborn.resources.Cloth_Int_8
import com.elkite.warborn.resources.Cloth_Str_1
import com.elkite.warborn.resources.Cloth_Str_2
import com.elkite.warborn.resources.Cloth_Str_3
import com.elkite.warborn.resources.Cloth_Str_4
import com.elkite.warborn.resources.Cloth_Str_5
import com.elkite.warborn.resources.Cloth_Str_6
import com.elkite.warborn.resources.Cloth_Str_8
import com.elkite.warborn.resources.Cloth_Str_9
import com.elkite.warborn.resources.Com_Clothes_Armor
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_ARMOR1
import com.elkite.warborn.resources.SpecImage_ARMOR2
import com.elkite.warborn.resources.SpecImage_ARMOR3
import com.elkite.warborn.resources.SpecImage_ARMOR4
import com.elkite.warborn.resources.SpecImage_ARMOR5
import com.elkite.warborn.resources.SpecImage_ARMOR6
import com.elkite.warborn.resources.SpecImage_ARMOR7
import com.elkite.warborn.resources.SpecImage_ARMOR8
import com.elkite.warborn.resources.SpecImage_JACKET1
import com.elkite.warborn.resources.SpecImage_JACKET2
import com.elkite.warborn.resources.SpecImage_JACKET3
import com.elkite.warborn.resources.SpecImage_JACKET4
import com.elkite.warborn.resources.SpecImage_JACKET5
import com.elkite.warborn.resources.SpecImage_JACKET6
import com.elkite.warborn.resources.SpecImage_JACKET7
import com.elkite.warborn.resources.SpecImage_ROBE1
import com.elkite.warborn.resources.SpecImage_ROBE2
import com.elkite.warborn.resources.SpecImage_ROBE3
import com.elkite.warborn.resources.SpecImage_ROBE4
import com.elkite.warborn.resources.SpecImage_ROBE5
import com.elkite.warborn.resources.SpecImage_ROBE6
import com.elkite.warborn.resources.SpecImage_ROBE7
import com.elkite.warborn.resources.SpecImage_ROBE8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object ChestResources {
    fun getChestArmorIcon(id: String, category: Category): DrawableResource {
        when (category) {
            Category.AGI -> return getChestArmorIconDex(id)
            Category.INT -> return getChestArmorIconInt(id)
            Category.STR -> return getChestArmorIconStr(id)
        }
    }

    fun getChestSkillIcon(id: String, category: Category): DrawableResource {
        when (category) {
            Category.AGI -> return getChestSkillIconDex(id)
            Category.INT -> return getChestSkillIconInt(id)
            Category.STR -> return getChestSkillIconStr(id)
        }
    }

    fun getChestSlotIcon(): DrawableResource {
        return Res.drawable.Com_Clothes_Armor
    }

    private fun getChestSkillIconStr(id: String): DrawableResource {
        return when (id) {
            "Cloth_Str_8" -> Res.drawable.Cloth_Str_8
            "Cloth_Str_6" -> Res.drawable.Cloth_Str_6
            "Cloth_Str_5" -> Res.drawable.Cloth_Str_5
            "Cloth_Str_4" -> Res.drawable.Cloth_Str_4
            "Cloth_Str_3" -> Res.drawable.Cloth_Str_3
            "Cloth_Str_2" -> Res.drawable.Cloth_Str_2
            "Cloth_Str_1" -> Res.drawable.Cloth_Str_1
            "Cloth_Str_9" -> Res.drawable.Cloth_Str_9
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestSkillIconInt(id: String): DrawableResource {
        return when (id) {
            "Cloth_Int_7" -> Res.drawable.Cloth_Int_7
            "Cloth_Int_8" -> Res.drawable.Cloth_Int_8
            "Cloth_Int_5" -> Res.drawable.Cloth_Int_5
            "Cloth_Int_4" -> Res.drawable.Cloth_Int_2
            "Cloth_Int_3" -> Res.drawable.Cloth_Int_3
            "Cloth_Int_2" -> Res.drawable.Cloth_Int_2
            "Cloth_Int_1" -> Res.drawable.Cloth_Int_1
            "Cloth_Int_8" -> Res.drawable.Cloth_Int_8
            "Cloth_Int_10" -> Res.drawable.Cloth_Int_10
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestSkillIconDex(id: String): DrawableResource {
        return when (id) {
            "Cloth_Dex_7" -> Res.drawable.Cloth_Dex_7
            "Cloth_Dex_6" -> Res.drawable.Cloth_Dex_6
            "Cloth_Dex_5" -> Res.drawable.Cloth_Dex_5
            "Cloth_Dex_4" -> Res.drawable.Cloth_Dex_4
            "Cloth_Dex_3" -> Res.drawable.Cloth_Dex_3
            "Cloth_Dex_2" -> Res.drawable.Cloth_Dex_2
            "Cloth_Dex_1" -> Res.drawable.Cloth_Dex_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestArmorIconDex(id: String): DrawableResource {
        return when (id) {
            "Ranger's Hide" -> Res.drawable.SpecImage_JACKET1
            "Beastcaller's Coat" -> Res.drawable.SpecImage_JACKET2
            "Deathmantle" -> Res.drawable.SpecImage_JACKET3
            "Retaliation Coat" -> Res.drawable.SpecImage_JACKET4
            "Hero's Embrace" -> Res.drawable.SpecImage_JACKET5
            "Recovery Vest" -> Res.drawable.SpecImage_JACKET6
            "Mistshroud" -> Res.drawable.SpecImage_JACKET7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestArmorIconInt(id: String): DrawableResource {
        return when (id) {
            "Cleansing Robe" -> Res.drawable.SpecImage_ROBE1
            "Repulsor Mantle" -> Res.drawable.SpecImage_ROBE2
            "Vigorcloak" -> Res.drawable.SpecImage_ROBE3
            "Archaneweaver" -> Res.drawable.SpecImage_ROBE4
            "Dreadcloak" -> Res.drawable.SpecImage_ROBE5
            "Exorcist's Robe" -> Res.drawable.SpecImage_ROBE6
            "Warding Shroud" -> Res.drawable.SpecImage_ROBE7
            "Cloth_Int_10" -> Res.drawable.SpecImage_ROBE8
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestArmorIconStr(id: String): DrawableResource {
        return when (id) {
            "Guardian's Blessing" -> Res.drawable.SpecImage_ARMOR4
            "Aegis Plate" -> Res.drawable.SpecImage_ARMOR1
            "Dazzling Guard" -> Res.drawable.SpecImage_ARMOR2
            "Tempest Charge" -> Res.drawable.SpecImage_ARMOR6
            "Tangle Guard" -> Res.drawable.SpecImage_ARMOR7
            "Warden's Shell" -> Res.drawable.SpecImage_ARMOR3
            "Magsurge Armor" -> Res.drawable.SpecImage_ARMOR5
            "Cloth_Str_9" -> Res.drawable.SpecImage_ARMOR8
            else -> Res.drawable.error_emoji
        }
    }
}
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
            "SpecImage_JACKET1" -> Res.drawable.SpecImage_JACKET1
            "SpecImage_JACKET2" -> Res.drawable.SpecImage_JACKET2
            "SpecImage_JACKET3" -> Res.drawable.SpecImage_JACKET3
            "SpecImage_JACKET4" -> Res.drawable.SpecImage_JACKET4
            "SpecImage_JACKET5" -> Res.drawable.SpecImage_JACKET5
            "SpecImage_JACKET6" -> Res.drawable.SpecImage_JACKET6
            "SpecImage_JACKET7" -> Res.drawable.SpecImage_JACKET7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestArmorIconInt(id: String): DrawableResource {
        return when (id) {
            "SpecImage_ROBE1" -> Res.drawable.SpecImage_ROBE1
            "SpecImage_ROBE2" -> Res.drawable.SpecImage_ROBE2
            "SpecImage_ROBE3" -> Res.drawable.SpecImage_ROBE3
            "SpecImage_ROBE4" -> Res.drawable.SpecImage_ROBE4
            "SpecImage_ROBE5" -> Res.drawable.SpecImage_ROBE5
            "SpecImage_ROBE6" -> Res.drawable.SpecImage_ROBE6
            "SpecImage_ROBE7" -> Res.drawable.SpecImage_ROBE7
            "SpecImage_ROBE8" -> Res.drawable.SpecImage_ROBE8
            else -> Res.drawable.error_emoji
        }
    }

    private fun getChestArmorIconStr(id: String): DrawableResource {
        return when (id) {
            "SpecImage_ARMOR4" -> Res.drawable.SpecImage_ARMOR4
            "SpecImage_ARMOR1" -> Res.drawable.SpecImage_ARMOR1
            "SpecImage_ARMOR2" -> Res.drawable.SpecImage_ARMOR2
            "SpecImage_ARMOR6" -> Res.drawable.SpecImage_ARMOR6
            "SpecImage_ARMOR7" -> Res.drawable.SpecImage_ARMOR7
            "SpecImage_ARMOR3" -> Res.drawable.SpecImage_ARMOR3
            "SpecImage_ARMOR5" -> Res.drawable.SpecImage_ARMOR5
            "SpecImage_ARMOR8" -> Res.drawable.SpecImage_ARMOR8
            else -> Res.drawable.error_emoji
        }
    }
}
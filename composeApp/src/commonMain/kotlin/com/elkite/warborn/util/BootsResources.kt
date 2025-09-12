package com.elkite.warborn.util

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.resources.Com_Shoes_Boots
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.Shoes_Dex_1
import com.elkite.warborn.resources.Shoes_Dex_2
import com.elkite.warborn.resources.Shoes_Dex_3
import com.elkite.warborn.resources.Shoes_Dex_4
import com.elkite.warborn.resources.Shoes_Dex_5
import com.elkite.warborn.resources.Shoes_Dex_7
import com.elkite.warborn.resources.Shoes_Dex_8
import com.elkite.warborn.resources.Shoes_Dex_9
import com.elkite.warborn.resources.Shoes_Int_1
import com.elkite.warborn.resources.Shoes_Int_2
import com.elkite.warborn.resources.Shoes_Int_3
import com.elkite.warborn.resources.Shoes_Int_4
import com.elkite.warborn.resources.Shoes_Int_5
import com.elkite.warborn.resources.Shoes_Int_6
import com.elkite.warborn.resources.Shoes_Int_7
import com.elkite.warborn.resources.Shoes_Int_8
import com.elkite.warborn.resources.Shoes_Str_1
import com.elkite.warborn.resources.Shoes_Str_2
import com.elkite.warborn.resources.Shoes_Str_3
import com.elkite.warborn.resources.Shoes_Str_4
import com.elkite.warborn.resources.Shoes_Str_5
import com.elkite.warborn.resources.Shoes_Str_6
import com.elkite.warborn.resources.Shoes_Str_7
import com.elkite.warborn.resources.SpecImage_BOOTS1
import com.elkite.warborn.resources.SpecImage_BOOTS2
import com.elkite.warborn.resources.SpecImage_BOOTS3
import com.elkite.warborn.resources.SpecImage_BOOTS4
import com.elkite.warborn.resources.SpecImage_BOOTS5
import com.elkite.warborn.resources.SpecImage_BOOTS6
import com.elkite.warborn.resources.SpecImage_BOOTS7
import com.elkite.warborn.resources.SpecImage_SANDALS1
import com.elkite.warborn.resources.SpecImage_SANDALS2
import com.elkite.warborn.resources.SpecImage_SANDALS3
import com.elkite.warborn.resources.SpecImage_SANDALS4
import com.elkite.warborn.resources.SpecImage_SANDALS5
import com.elkite.warborn.resources.SpecImage_SANDALS6
import com.elkite.warborn.resources.SpecImage_SANDALS7
import com.elkite.warborn.resources.SpecImage_SANDALS8
import com.elkite.warborn.resources.SpecImage_SHOES1
import com.elkite.warborn.resources.SpecImage_SHOES2
import com.elkite.warborn.resources.SpecImage_SHOES3
import com.elkite.warborn.resources.SpecImage_SHOES4
import com.elkite.warborn.resources.SpecImage_SHOES5
import com.elkite.warborn.resources.SpecImage_SHOES6
import com.elkite.warborn.resources.SpecImage_SHOES7
import com.elkite.warborn.resources.SpecImage_SHOES8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object BootsResources {
    fun getBootsArmorIcon(id: String, category: Category): DrawableResource {
        return when (category) {
            Category.AGI -> getBootsArmorIconDex(id)
            Category.INT -> getBootsArmorIconInt(id)
            Category.STR -> getBootsArmorIconStr(id)
        }
    }

    fun getBootsSkillIcon(id: String, category: Category): DrawableResource {
        return when (category) {
            Category.AGI -> getBootsSkillIconDex(id)
            Category.INT -> getBootsSkillIconInt(id)
            Category.STR -> getBootsSkillIconStr(id)
        }
    }

    fun getBootsSlotIcon(): DrawableResource {
        return Res.drawable.Com_Shoes_Boots
    }

    private fun getBootsSkillIconStr(id: String): DrawableResource {
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

    private fun getBootsSkillIconInt(id: String): DrawableResource {
        return when (id) {
            "Shoes_Int_7" -> Res.drawable.Shoes_Int_7
            "Shoes_Int_6" -> Res.drawable.Shoes_Int_6
            "Shoes_Int_5" -> Res.drawable.Shoes_Int_5
            "Shoes_Int_4" -> Res.drawable.Shoes_Int_4
            "Shoes_Int_3" -> Res.drawable.Shoes_Int_3
            "Shoes_Int_2" -> Res.drawable.Shoes_Int_2
            "Shoes_Int_1" -> Res.drawable.Shoes_Int_1
            "Shoes_Int_8" -> Res.drawable.Shoes_Int_8
            else -> Res.drawable.error_emoji
        }
    }

    private fun getBootsSkillIconDex(id: String): DrawableResource {
        return when (id) {
            "Shoes_Dex_7" -> Res.drawable.Shoes_Dex_7
            "Shoes_Dex_8" -> Res.drawable.Shoes_Dex_8
            "Shoes_Dex_5" -> Res.drawable.Shoes_Dex_5
            "Shoes_Dex_4" -> Res.drawable.Shoes_Dex_4
            "Shoes_Dex_3" -> Res.drawable.Shoes_Dex_3
            "Shoes_Dex_2" -> Res.drawable.Shoes_Dex_2
            "Shoes_Dex_1" -> Res.drawable.Shoes_Dex_1
            "Shoes_Dex_9" -> Res.drawable.Shoes_Dex_9
            else -> Res.drawable.error_emoji
        }
    }

    private fun getBootsArmorIconStr(id: String): DrawableResource {
        return when (id) {
            "Energizer Boots" -> Res.drawable.SpecImage_BOOTS4
            "Wrathstep" -> Res.drawable.SpecImage_BOOTS5
            "Bulwark Striders" -> Res.drawable.SpecImage_BOOTS1
            "Titan Walkers" -> Res.drawable.SpecImage_BOOTS2
            "Vanguard's March" -> Res.drawable.SpecImage_BOOTS6
            "Impact Heavy Boots" -> Res.drawable.SpecImage_BOOTS3
            "Avalanche Boots" -> Res.drawable.SpecImage_BOOTS7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getBootsArmorIconInt(id: String): DrawableResource {
        return when (id) {
            "Blinkstep Boots" -> Res.drawable.SpecImage_SANDALS1
            "Arcaneflow Boots" -> Res.drawable.SpecImage_SANDALS2
            "Savagefoot Boots" -> Res.drawable.SpecImage_SANDALS3
            "Frostwalker Boots" -> Res.drawable.SpecImage_SANDALS4
            "Miasma Stompers" -> Res.drawable.SpecImage_SANDALS5
            "Shifter's Strides" -> Res.drawable.SpecImage_SANDALS6
            "Phantomstep Boots" -> Res.drawable.SpecImage_SANDALS7
            "Shoes_Int_8" -> Res.drawable.SpecImage_SANDALS8
            else -> Res.drawable.error_emoji
        }
    }

    private fun getBootsArmorIconDex(id: String): DrawableResource {
        return when (id) {
            "Fleeting Steps" -> Res.drawable.SpecImage_SHOES1
            "Swiftstride Boots" -> Res.drawable.SpecImage_SHOES2
            "Deathwalker Boots" -> Res.drawable.SpecImage_SHOES3
            "Evasion Striders" -> Res.drawable.SpecImage_SHOES4
            "Rallystep Boots" -> Res.drawable.SpecImage_SHOES5
            "Shadeveil Slippers" -> Res.drawable.SpecImage_SHOES6
            "Exodrift Slippers" -> Res.drawable.SpecImage_SHOES7
            "Shoes_Dex_9" -> Res.drawable.SpecImage_SHOES8
            else -> Res.drawable.error_emoji
        }
    }
}
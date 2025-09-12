package com.elkite.warborn.util

import com.elkite.warborn.domain.entities.common.Category
import com.elkite.warborn.resources.Com_Head_Helmet
import com.elkite.warborn.resources.Helm_Dex_1
import com.elkite.warborn.resources.Helm_Dex_2
import com.elkite.warborn.resources.Helm_Dex_3
import com.elkite.warborn.resources.Helm_Dex_4
import com.elkite.warborn.resources.Helm_Dex_5
import com.elkite.warborn.resources.Helm_Dex_7
import com.elkite.warborn.resources.Helm_Dex_8
import com.elkite.warborn.resources.Helm_Dex_9
import com.elkite.warborn.resources.Helm_Int_1
import com.elkite.warborn.resources.Helm_Int_2
import com.elkite.warborn.resources.Helm_Int_3
import com.elkite.warborn.resources.Helm_Int_4
import com.elkite.warborn.resources.Helm_Int_5
import com.elkite.warborn.resources.Helm_Int_7
import com.elkite.warborn.resources.Helm_Int_8
import com.elkite.warborn.resources.Helm_Str_1
import com.elkite.warborn.resources.Helm_Str_3
import com.elkite.warborn.resources.Helm_Str_4
import com.elkite.warborn.resources.Helm_Str_5
import com.elkite.warborn.resources.Helm_Str_6
import com.elkite.warborn.resources.Helm_Str_7
import com.elkite.warborn.resources.Helm_Str_8
import com.elkite.warborn.resources.Helm_Str_9
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_COWL1
import com.elkite.warborn.resources.SpecImage_COWL2
import com.elkite.warborn.resources.SpecImage_COWL3
import com.elkite.warborn.resources.SpecImage_COWL4
import com.elkite.warborn.resources.SpecImage_COWL5
import com.elkite.warborn.resources.SpecImage_COWL6
import com.elkite.warborn.resources.SpecImage_COWL7
import com.elkite.warborn.resources.SpecImage_HELMET1
import com.elkite.warborn.resources.SpecImage_HELMET2
import com.elkite.warborn.resources.SpecImage_HELMET3
import com.elkite.warborn.resources.SpecImage_HELMET4
import com.elkite.warborn.resources.SpecImage_HELMET5
import com.elkite.warborn.resources.SpecImage_HELMET6
import com.elkite.warborn.resources.SpecImage_HELMET7
import com.elkite.warborn.resources.SpecImage_HELMET8
import com.elkite.warborn.resources.SpecImage_HOOD1
import com.elkite.warborn.resources.SpecImage_HOOD2
import com.elkite.warborn.resources.SpecImage_HOOD3
import com.elkite.warborn.resources.SpecImage_HOOD4
import com.elkite.warborn.resources.SpecImage_HOOD5
import com.elkite.warborn.resources.SpecImage_HOOD6
import com.elkite.warborn.resources.SpecImage_HOOD7
import com.elkite.warborn.resources.SpecImage_HOOD8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object HeadResources {
    fun getHeadArmorIcon(id: String, category: Category): DrawableResource {
        return when (category) {
            Category.AGI -> getHeadArmorIconDex(id)
            Category.INT -> getHeadArmorIconInt(id)
            Category.STR -> getHeadArmorIconStr(id)
        }
    }

    fun getHeadSkillIcon(id: String, category: Category): DrawableResource {
        return when (category) {
            Category.AGI -> getHeadSkillIconDex(id)
            Category.INT -> getHeadSkillIconInt(id)
            Category.STR -> getHeadSkillIconStr(id)
        }
    }

    fun getHeadSlotIcon(): DrawableResource {
        return Res.drawable.Com_Head_Helmet
    }

    private fun getHeadSkillIconStr(id: String): DrawableResource {
        return when (id) {
            "Helm_Str_8" -> Res.drawable.Helm_Str_8
            "Helm_Str_7" -> Res.drawable.Helm_Str_7
            "Helm_Str_6" -> Res.drawable.Helm_Str_6
            "Helm_Str_5" -> Res.drawable.Helm_Str_5
            "Helm_Str_4" -> Res.drawable.Helm_Str_4
            "Helm_Str_3" -> Res.drawable.Helm_Str_3
            "Helm_Str_1" -> Res.drawable.Helm_Str_1
            "Helm_Str_9" -> Res.drawable.Helm_Str_9
            else -> Res.drawable.error_emoji
        }
    }

    private fun getHeadSkillIconInt(id: String): DrawableResource {
        return when (id) {
            "Helm_Int_8" -> Res.drawable.Helm_Int_8
            "Helm_Int_7" -> Res.drawable.Helm_Int_7
            "Helm_Int_2" -> Res.drawable.Helm_Int_2
            "Helm_Int_5" -> Res.drawable.Helm_Int_5
            "Helm_Int_4" -> Res.drawable.Helm_Int_4
            "Helm_Int_3" -> Res.drawable.Helm_Int_3
            "Helm_Int_1" -> Res.drawable.Helm_Int_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getHeadSkillIconDex(id: String): DrawableResource {
        return when (id) {
            "Helm_Dex_8" -> Res.drawable.Helm_Dex_8
            "Helm_Dex_7" -> Res.drawable.Helm_Dex_7
            "Helm_Dex_2" -> Res.drawable.Helm_Dex_2
            "Helm_Dex_5" -> Res.drawable.Helm_Dex_5
            "Helm_Dex_4" -> Res.drawable.Helm_Dex_4
            "Helm_Dex_3" -> Res.drawable.Helm_Dex_3
            "Helm_Dex_1" -> Res.drawable.Helm_Dex_1
            "Helm_Dex_9" -> Res.drawable.Helm_Dex_9
            else -> Res.drawable.error_emoji

        }
    }

    private fun getHeadArmorIconDex(id: String): DrawableResource {
        return when (id) {
            "Vital Mantle" -> Res.drawable.SpecImage_HOOD2
            "Stormcaller's Hood" -> Res.drawable.SpecImage_HOOD1
            "Shadeveil Mask" -> Res.drawable.SpecImage_HOOD5
            "Wrathveil Shade" -> Res.drawable.SpecImage_HOOD6
            "Purifier's Shroud" -> Res.drawable.SpecImage_HOOD7
            "Ironwill veil" -> Res.drawable.SpecImage_HOOD3
            "Folly Helm" -> Res.drawable.SpecImage_HOOD4
            "Helm_Dex_9" -> Res.drawable.SpecImage_HOOD8
            else -> Res.drawable.error_emoji
        }

    }

    private fun getHeadArmorIconInt(id: String): DrawableResource {
        return when (id) {
            "Breezeweaver" -> Res.drawable.SpecImage_COWL1
            "Healer's Hood" -> Res.drawable.SpecImage_COWL3
            "Mystic Surge" -> Res.drawable.SpecImage_COWL2
            "Earth Vein Hood" -> Res.drawable.SpecImage_COWL5
            "Crimson Breeze" -> Res.drawable.SpecImage_COWL6
            "Twilight Mantle" -> Res.drawable.SpecImage_COWL7
            "Sanctum Shroud" -> Res.drawable.SpecImage_COWL4
            else -> Res.drawable.error_emoji
        }
    }

    private fun getHeadArmorIconStr(id: String): DrawableResource {
        return when (id) {
            "Furor's Helm" -> Res.drawable.SpecImage_HELMET3
            "Ironclad Helm" -> Res.drawable.SpecImage_HELMET6
            "Hellfire Visor" -> Res.drawable.SpecImage_HELMET2
            "Reptilian Helm" -> Res.drawable.SpecImage_HELMET4
            "Savage Helm" -> Res.drawable.SpecImage_HELMET1
            "Stormveil Mask" -> Res.drawable.SpecImage_HELMET5
            "Warden's Gaze" -> Res.drawable.SpecImage_HELMET7
            "Riposte Helm" -> Res.drawable.SpecImage_HELMET8
            else -> Res.drawable.error_emoji
        }
    }


}
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
            "SpecImage_HOOD2" -> Res.drawable.SpecImage_HOOD2
            "SpecImage_HOOD1" -> Res.drawable.SpecImage_HOOD1
            "SpecImage_HOOD5" -> Res.drawable.SpecImage_HOOD5
            "SpecImage_HOOD6" -> Res.drawable.SpecImage_HOOD6
            "SpecImage_HOOD7" -> Res.drawable.SpecImage_HOOD7
            "SpecImage_HOOD3" -> Res.drawable.SpecImage_HOOD3
            "SpecImage_HOOD4" -> Res.drawable.SpecImage_HOOD4
            "SpecImage_HOOD8" -> Res.drawable.SpecImage_HOOD8
            else -> Res.drawable.error_emoji
        }

    }

    private fun getHeadArmorIconInt(id: String): DrawableResource {
        return when (id) {
            "SpecImage_COWL1" -> Res.drawable.SpecImage_COWL1
            "SpecImage_COWL3" -> Res.drawable.SpecImage_COWL3
            "SpecImage_COWL2" -> Res.drawable.SpecImage_COWL2
            "SpecImage_COWL5" -> Res.drawable.SpecImage_COWL5
            "SpecImage_COWL6" -> Res.drawable.SpecImage_COWL6
            "SpecImage_COWL7" -> Res.drawable.SpecImage_COWL7
            "SpecImage_COWL4" -> Res.drawable.SpecImage_COWL4
            else -> Res.drawable.error_emoji
        }
    }

    private fun getHeadArmorIconStr(id: String): DrawableResource {
        return when (id) {
            "SpecImage_HELMET3" -> Res.drawable.SpecImage_HELMET3
            "SpecImage_HELMET6" -> Res.drawable.SpecImage_HELMET6
            "SpecImage_HELMET2" -> Res.drawable.SpecImage_HELMET2
            "SpecImage_HELMET4" -> Res.drawable.SpecImage_HELMET4
            "SpecImage_HELMET1" -> Res.drawable.SpecImage_HELMET1
            "SpecImage_HELMET5" -> Res.drawable.SpecImage_HELMET5
            "SpecImage_HELMET7" -> Res.drawable.SpecImage_HELMET7
            "SpecImage_HELMET8" -> Res.drawable.SpecImage_HELMET8
            else -> Res.drawable.error_emoji
        }
    }


}
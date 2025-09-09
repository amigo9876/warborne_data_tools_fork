package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Spear
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpearAttack_2
import com.elkite.warborn.resources.SpearAttack_3
import com.elkite.warborn.resources.SpearAttack_4
import com.elkite.warborn.resources.Spear_Bright
import com.elkite.warborn.resources.Spear_Common_Skill_1
import com.elkite.warborn.resources.Spear_Common_Skill_2
import com.elkite.warborn.resources.Spear_Common_Skill_3
import com.elkite.warborn.resources.Spear_Common_Skill_4
import com.elkite.warborn.resources.Spear_Common_Skill_5
import com.elkite.warborn.resources.Spear_DragonBack
import com.elkite.warborn.resources.Spear_Fling
import com.elkite.warborn.resources.Spear_Passive
import com.elkite.warborn.resources.Spear_SpearDance
import com.elkite.warborn.resources.Spear_SpiritHunter
import com.elkite.warborn.resources.Spear_Sweep
import com.elkite.warborn.resources.Spear_Trinity
import com.elkite.warborn.resources.SpecImage_SPEAR1
import com.elkite.warborn.resources.SpecImage_SPEAR2
import com.elkite.warborn.resources.SpecImage_SPEAR3
import com.elkite.warborn.resources.SpecImage_SPEAR4
import com.elkite.warborn.resources.SpecImage_SPEAR6
import com.elkite.warborn.resources.SpecImage_SPEAR7
import com.elkite.warborn.resources.SpecImage_SPEAR8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object SpearResources {
    fun getSpearWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Sharspike" -> Res.drawable.SpecImage_SPEAR6
            "Sentinel's Lance" -> Res.drawable.SpecImage_SPEAR3
            "Stormfang Lance" -> Res.drawable.SpecImage_SPEAR1
            "Storm Spear" -> Res.drawable.SpecImage_SPEAR7
            "Drakespike" -> Res.drawable.SpecImage_SPEAR8
            "Corrosive Piercer" -> Res.drawable.SpecImage_SPEAR4
            "Phantom Spear" -> Res.drawable.SpecImage_SPEAR2
            else -> Res.drawable.error_emoji
        }
    }

    fun getSpearSkillIcon(id: String): DrawableResource {
        return when (id) {
            "SpearAttack_4" -> Res.drawable.SpearAttack_4
            "SpearAttack_2" -> Res.drawable.SpearAttack_2
            "SpearAttack_3" -> Res.drawable.SpearAttack_3
            "Spear_Common_Skill_1" -> Res.drawable.Spear_Common_Skill_1
            "Spear_Common_Skill_4" -> Res.drawable.Spear_Common_Skill_4
            "Spear_Common_Skill_3" -> Res.drawable.Spear_Common_Skill_3
            "Spear_Common_Skill_2" -> Res.drawable.Spear_Common_Skill_2
            "Spear_Common_Skill_5" -> Res.drawable.Spear_Common_Skill_5
            "Spear_SpearDance" -> Res.drawable.Spear_SpearDance
            "Spear_Passive" -> Res.drawable.Spear_Passive
            "Spear_Trinity" -> Res.drawable.Spear_Trinity
            "Spear_Fling" -> Res.drawable.Spear_Fling
            "Spear_Sweep" -> Res.drawable.Spear_Sweep
            "Spear_DragonBack" -> Res.drawable.Spear_DragonBack
            "Spear_SpiritHunter" -> Res.drawable.Spear_SpiritHunter
            "Spear_Bright" -> Res.drawable.Spear_Bright
            else -> Res.drawable.error_emoji
        }
    }

    fun getSpearSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Spear
    }
}
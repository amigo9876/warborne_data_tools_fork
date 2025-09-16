package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Dagger
import com.elkite.warborn.resources.DaggerAttack_2
import com.elkite.warborn.resources.DaggerAttack_3
import com.elkite.warborn.resources.DaggerAttack_4
import com.elkite.warborn.resources.Dagger_BloodDagger
import com.elkite.warborn.resources.Dagger_Common_Skill_1
import com.elkite.warborn.resources.Dagger_Common_Skill_2
import com.elkite.warborn.resources.Dagger_Common_Skill_3
import com.elkite.warborn.resources.Dagger_Common_Skill_4
import com.elkite.warborn.resources.Dagger_Common_Skill_5
import com.elkite.warborn.resources.Dagger_Dagger
import com.elkite.warborn.resources.Dagger_DeathDagger
import com.elkite.warborn.resources.Dagger_FastDagger
import com.elkite.warborn.resources.Dagger_LongDagger
import com.elkite.warborn.resources.Dagger_Passive
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_DAGGER1
import com.elkite.warborn.resources.SpecImage_DAGGER2
import com.elkite.warborn.resources.SpecImage_DAGGER3
import com.elkite.warborn.resources.SpecImage_DAGGER4
import com.elkite.warborn.resources.SpecImage_DAGGER5
import com.elkite.warborn.resources.SpecImage_DAGGER6
import com.elkite.warborn.resources.SpecImage_DAGGER7
import com.elkite.warborn.resources.TwinDagger_BladeWind
import com.elkite.warborn.resources.TwinDagger_HungerBlood
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object DaggerResources {
    fun getDaggerWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "SpecImage_DAGGER7" -> Res.drawable.SpecImage_DAGGER7
            "SpecImage_DAGGER1" -> Res.drawable.SpecImage_DAGGER1
            "SpecImage_DAGGER2" -> Res.drawable.SpecImage_DAGGER2
            "SpecImage_DAGGER5" -> Res.drawable.SpecImage_DAGGER5
            "SpecImage_DAGGER4" -> Res.drawable.SpecImage_DAGGER4
            "SpecImage_DAGGER6" -> Res.drawable.SpecImage_DAGGER6
            "SpecImage_DAGGER3" -> Res.drawable.SpecImage_DAGGER3
            else -> Res.drawable.error_emoji
        }
    }

    fun getDaggerSkillIcon(id: String): DrawableResource {
        return when (id) {
            "DaggerAttack_2" -> Res.drawable.DaggerAttack_2
            "DaggerAttack_4" -> Res.drawable.DaggerAttack_4
            "DaggerAttack_3" -> Res.drawable.DaggerAttack_3
            "Dagger_Passive" -> Res.drawable.Dagger_Passive
            "Dagger_Common_Skill_1" -> Res.drawable.Dagger_Common_Skill_1
            "Dagger_Common_Skill_3" -> Res.drawable.Dagger_Common_Skill_3
            "Dagger_Common_Skill_2" -> Res.drawable.Dagger_Common_Skill_2
            "Dagger_Common_Skill_4" -> Res.drawable.Dagger_Common_Skill_4
            "Dagger_Common_Skill_5" -> Res.drawable.Dagger_Common_Skill_5
            "Dagger_LongDagger" -> Res.drawable.Dagger_LongDagger
            "Dagger_BloodDagger" -> Res.drawable.Dagger_BloodDagger
            "Dagger_DeathDagger" -> Res.drawable.Dagger_DeathDagger
            "Dagger_Dagger" -> Res.drawable.Dagger_Dagger
            "TwinDagger_BladeWind" -> Res.drawable.TwinDagger_BladeWind
            "TwinDagger_HungerBlood" -> Res.drawable.TwinDagger_HungerBlood
            "Dagger_FastDagger" -> Res.drawable.Dagger_FastDagger
            else -> Res.drawable.error_emoji
        }
    }

    fun getDaggerSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Dagger
    }
}
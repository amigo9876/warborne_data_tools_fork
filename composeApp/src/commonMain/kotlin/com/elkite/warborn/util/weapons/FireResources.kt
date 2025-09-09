package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Fire
import com.elkite.warborn.resources.FireStaffAttack_1
import com.elkite.warborn.resources.FireStaffAttack_2
import com.elkite.warborn.resources.FireStaffAttack_3
import com.elkite.warborn.resources.FireStaff_1HandStaff
import com.elkite.warborn.resources.FireStaff_Blazing
import com.elkite.warborn.resources.FireStaff_Brimstone
import com.elkite.warborn.resources.FireStaff_Common_Skill_1
import com.elkite.warborn.resources.FireStaff_Common_Skill_2
import com.elkite.warborn.resources.FireStaff_Common_Skill_3
import com.elkite.warborn.resources.FireStaff_Common_Skill_4
import com.elkite.warborn.resources.FireStaff_Common_Skill_5
import com.elkite.warborn.resources.FireStaff_Dawnsong
import com.elkite.warborn.resources.FireStaff_Fanning
import com.elkite.warborn.resources.FireStaff_Flare
import com.elkite.warborn.resources.FireStaff_LavaCannonade
import com.elkite.warborn.resources.FireStaff_Passive
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_FIRE1
import com.elkite.warborn.resources.SpecImage_FIRE2
import com.elkite.warborn.resources.SpecImage_FIRE3
import com.elkite.warborn.resources.SpecImage_FIRE4
import com.elkite.warborn.resources.SpecImage_FIRE5
import com.elkite.warborn.resources.SpecImage_FIRE6
import com.elkite.warborn.resources.SpecImage_FIRE7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object FireResources {
    fun getFireWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Flame Maw" -> Res.drawable.SpecImage_FIRE1
            "Blazing Catalyst" -> Res.drawable.SpecImage_FIRE2
            "Doomfire" -> Res.drawable.SpecImage_FIRE3
            "Inferno Core" -> Res.drawable.SpecImage_FIRE4
            "Solarflare" -> Res.drawable.SpecImage_FIRE5
            "Blazruptor" -> Res.drawable.SpecImage_FIRE6
            "Molten Mortar" -> Res.drawable.SpecImage_FIRE7
            else -> Res.drawable.error_emoji
        }
    }

    fun getFireSkillIcon(id: String): DrawableResource {
        return when (id) {
            "FireStaffAttack_1" -> Res.drawable.FireStaffAttack_1
            "FireStaffAttack_2" -> Res.drawable.FireStaffAttack_2
            "FireStaffAttack_3" -> Res.drawable.FireStaffAttack_3
            "FireStaff_Common_Skill_1" -> Res.drawable.FireStaff_Common_Skill_1
            "FireStaff_Common_Skill_2" -> Res.drawable.FireStaff_Common_Skill_2
            "FireStaff_Common_Skill_3" -> Res.drawable.FireStaff_Common_Skill_3
            "FireStaff_Common_Skill_4" -> Res.drawable.FireStaff_Common_Skill_4
            "FireStaff_Common_Skill_5" -> Res.drawable.FireStaff_Common_Skill_5
            "FireStaff_Passive" -> Res.drawable.FireStaff_Passive
            "FireStaff_Blazing" -> Res.drawable.FireStaff_Blazing
            "FireStaff_1HandStaff" -> Res.drawable.FireStaff_1HandStaff
            "FireStaff_Brimstone" -> Res.drawable.FireStaff_Brimstone
            "FireStaff_Flare" -> Res.drawable.FireStaff_Flare
            "FireStaff_Fanning" -> Res.drawable.FireStaff_Fanning
            "FireStaff_Dawnsong" -> Res.drawable.FireStaff_Dawnsong
            "FireStaff_LavaCannonade" -> Res.drawable.FireStaff_LavaCannonade
            else -> Res.drawable.error_emoji
        }
    }

    fun getFireSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Fire
    }
}
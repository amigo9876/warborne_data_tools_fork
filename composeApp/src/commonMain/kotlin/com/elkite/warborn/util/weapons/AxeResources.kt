package com.elkite.warborn.util.weapons

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
import com.elkite.warborn.resources.Com_Weapon_Axe
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_AXE1
import com.elkite.warborn.resources.SpecImage_AXE2
import com.elkite.warborn.resources.SpecImage_AXE3
import com.elkite.warborn.resources.SpecImage_AXE4
import com.elkite.warborn.resources.SpecImage_AXE5
import com.elkite.warborn.resources.SpecImage_AXE6
import com.elkite.warborn.resources.SpecImage_AXE7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object AxeResources {
    fun getAxeWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Berserker's Fury" -> Res.drawable.SpecImage_AXE2
            "Emerald Edge" -> Res.drawable.SpecImage_AXE1
            "Ravager's Cleave" -> Res.drawable.SpecImage_AXE6
            "Bonefang Reaper" -> Res.drawable.SpecImage_AXE7
            "Cyclone Cleave" -> Res.drawable.SpecImage_AXE4
            "Wreckingsaw" -> Res.drawable.SpecImage_AXE5
            "Wingblade" -> Res.drawable.SpecImage_AXE3
            else -> Res.drawable.error_emoji
        }
    }

    fun getAxeSkillIcon(id: String): DrawableResource {
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

    fun getAxeSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Axe
    }
}
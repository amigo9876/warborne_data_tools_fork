package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Mace
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
import com.elkite.warborn.resources.Mace_Paladin_Shield
import com.elkite.warborn.resources.Mace_Passive
import com.elkite.warborn.resources.Mace_ShieldMace_2
import com.elkite.warborn.resources.Mace_ThunderMace
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_MACE1
import com.elkite.warborn.resources.SpecImage_MACE2
import com.elkite.warborn.resources.SpecImage_MACE3
import com.elkite.warborn.resources.SpecImage_MACE4
import com.elkite.warborn.resources.SpecImage_MACE5
import com.elkite.warborn.resources.SpecImage_MACE6
import com.elkite.warborn.resources.SpecImage_MACE7
import com.elkite.warborn.resources.SpecImage_MACE8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object MaceResources {
    fun getMaceWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Breaker's Resolve" -> Res.drawable.SpecImage_MACE1
            "Gravity Hammer" -> Res.drawable.SpecImage_MACE2
            "Voidbreaker" -> Res.drawable.SpecImage_MACE3
            "Ripper's Grasp" -> Res.drawable.SpecImage_MACE4
            "Bulwark Core" -> Res.drawable.SpecImage_MACE6
            "Abyssal Conduit" -> Res.drawable.SpecImage_MACE5
            "Thunderlord's Wrath" -> Res.drawable.SpecImage_MACE7
            "Paladin's Mace" -> Res.drawable.SpecImage_MACE8
            else -> Res.drawable.error_emoji
        }
    }

    fun getMaceSkillIcon(id: String): DrawableResource {
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
            "Mace_Paladin_Shield" -> Res.drawable.Mace_Paladin_Shield
            else -> Res.drawable.error_emoji
        }
    }

    fun getMaceSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Mace
    }
}
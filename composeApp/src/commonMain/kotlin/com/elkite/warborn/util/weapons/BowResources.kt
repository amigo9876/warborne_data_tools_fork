package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.BowAttack_1
import com.elkite.warborn.resources.BowAttack_2
import com.elkite.warborn.resources.BowAttack_3
import com.elkite.warborn.resources.Bow_ArrowRain
import com.elkite.warborn.resources.Bow_Common_Skill_1
import com.elkite.warborn.resources.Bow_Common_Skill_2
import com.elkite.warborn.resources.Bow_Common_Skill_3
import com.elkite.warborn.resources.Bow_Common_Skill_4
import com.elkite.warborn.resources.Bow_Common_Skill_5
import com.elkite.warborn.resources.Bow_Eighteen
import com.elkite.warborn.resources.Bow_GravityArrow
import com.elkite.warborn.resources.Bow_Light
import com.elkite.warborn.resources.Bow_Passive
import com.elkite.warborn.resources.Bow_Thunder
import com.elkite.warborn.resources.Bow_War
import com.elkite.warborn.resources.Bow_WindArrow
import com.elkite.warborn.resources.Com_Weapon_Bow
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_BOW1
import com.elkite.warborn.resources.SpecImage_BOW2
import com.elkite.warborn.resources.SpecImage_BOW3
import com.elkite.warborn.resources.SpecImage_BOW4
import com.elkite.warborn.resources.SpecImage_BOW5
import com.elkite.warborn.resources.SpecImage_BOW6
import com.elkite.warborn.resources.SpecImage_BOW7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object BowResources {
    fun getBowWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Hailfire" -> Res.drawable.SpecImage_BOW4
            "Kinetic Arc" -> Res.drawable.SpecImage_BOW1
            "Predator's Splitbow" -> Res.drawable.SpecImage_BOW2
            "Thunderstrike" -> Res.drawable.SpecImage_BOW5
            "Windbreaker" -> Res.drawable.SpecImage_BOW6
            "Mender's Ruin" -> Res.drawable.SpecImage_BOW3
            "Eclypse Bow" -> Res.drawable.SpecImage_BOW7
            else -> Res.drawable.error_emoji
        }
    }

    fun getBowSkillIcon(id: String): DrawableResource {
        return when (id) {
            "BowAttack_2" -> Res.drawable.BowAttack_2
            "BowAttack_1" -> Res.drawable.BowAttack_1
            "BowAttack_3" -> Res.drawable.BowAttack_3
            "Bow_Common_Skill_5" -> Res.drawable.Bow_Common_Skill_5
            "Bow_Common_Skill_3" -> Res.drawable.Bow_Common_Skill_3
            "Bow_Common_Skill_1" -> Res.drawable.Bow_Common_Skill_1
            "Bow_Common_Skill_2" -> Res.drawable.Bow_Common_Skill_2
            "Bow_Common_Skill_4" -> Res.drawable.Bow_Common_Skill_4
            "Bow_ArrowRain" -> Res.drawable.Bow_ArrowRain
            "Bow_Passive" -> Res.drawable.Bow_Passive
            "Bow_Eighteen" -> Res.drawable.Bow_Eighteen
            "Bow_War" -> Res.drawable.Bow_War
            "Bow_Thunder" -> Res.drawable.Bow_Thunder
            "Bow_WindArrow" -> Res.drawable.Bow_WindArrow
            "Bow_Light" -> Res.drawable.Bow_Light
            "Bow_GravityArrow" -> Res.drawable.Bow_GravityArrow
            else -> Res.drawable.error_emoji
        }
    }

    fun getBowSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Bow
    }
}
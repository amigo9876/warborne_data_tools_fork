package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Curse
import com.elkite.warborn.resources.CurseAttack_1
import com.elkite.warborn.resources.CurseAttack_2
import com.elkite.warborn.resources.CurseAttack_3
import com.elkite.warborn.resources.Curse_AntiMagic
import com.elkite.warborn.resources.Curse_Cloud
import com.elkite.warborn.resources.Curse_Common_Skill_1
import com.elkite.warborn.resources.Curse_Common_Skill_2
import com.elkite.warborn.resources.Curse_Common_Skill_3
import com.elkite.warborn.resources.Curse_Common_Skill_4
import com.elkite.warborn.resources.Curse_Common_Skill_5
import com.elkite.warborn.resources.Curse_Cripple
import com.elkite.warborn.resources.Curse_DeathDisease
import com.elkite.warborn.resources.Curse_Flower
import com.elkite.warborn.resources.Curse_Infect
import com.elkite.warborn.resources.Curse_Passive
import com.elkite.warborn.resources.Curse_Worm
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_CURSE1
import com.elkite.warborn.resources.SpecImage_CURSE2
import com.elkite.warborn.resources.SpecImage_CURSE3
import com.elkite.warborn.resources.SpecImage_CURSE4
import com.elkite.warborn.resources.SpecImage_CURSE5
import com.elkite.warborn.resources.SpecImage_CURSE6
import com.elkite.warborn.resources.SpecImage_CURSE7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object CurseResources {
    fun getCurseWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Rotten Breath" -> Res.drawable.SpecImage_CURSE1
            "Hexlock" -> Res.drawable.SpecImage_CURSE2
            "Plaguespread" -> Res.drawable.SpecImage_CURSE3
            "Infestor's Staff" -> Res.drawable.SpecImage_CURSE4
            "Necromist" -> Res.drawable.SpecImage_CURSE5
            "Nihilstaff" -> Res.drawable.SpecImage_CURSE6
            "Withermaul" -> Res.drawable.SpecImage_CURSE7
            else -> Res.drawable.error_emoji
        }
    }

    fun getCurseSkillIcon(id: String): DrawableResource {
        return when (id) {
            "CurseAttack_1" -> Res.drawable.CurseAttack_1
            "CurseAttack_2" -> Res.drawable.CurseAttack_2
            "CurseAttack_3" -> Res.drawable.CurseAttack_3
            "Curse_Common_Skill_1" -> Res.drawable.Curse_Common_Skill_1
            "Curse_Common_Skill_2" -> Res.drawable.Curse_Common_Skill_2
            "Curse_Common_Skill_3" -> Res.drawable.Curse_Common_Skill_3
            "Curse_Common_Skill_4" -> Res.drawable.Curse_Common_Skill_4
            "Curse_Common_Skill_5" -> Res.drawable.Curse_Common_Skill_5
            "Curse_Passive" -> Res.drawable.Curse_Passive
            "Curse_DeathDisease" -> Res.drawable.Curse_DeathDisease
            "Curse_AntiMagic" -> Res.drawable.Curse_AntiMagic
            "Curse_Infect" -> Res.drawable.Curse_Infect
            "Curse_Worm" -> Res.drawable.Curse_Worm
            "Curse_Clipple" -> Res.drawable.Curse_Cripple
            "Curse_Cloud" -> Res.drawable.Curse_Cloud
            "Curse_Flower" -> Res.drawable.Curse_Flower
            else -> Res.drawable.error_emoji
        }
    }

    fun getCurseSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Curse
    }
}
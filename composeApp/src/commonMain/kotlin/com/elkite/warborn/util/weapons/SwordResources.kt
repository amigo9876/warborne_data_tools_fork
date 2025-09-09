package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Sword
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_SWORD1
import com.elkite.warborn.resources.SpecImage_SWORD2
import com.elkite.warborn.resources.SpecImage_SWORD3
import com.elkite.warborn.resources.SpecImage_SWORD4
import com.elkite.warborn.resources.SpecImage_SWORD5
import com.elkite.warborn.resources.SpecImage_SWORD6
import com.elkite.warborn.resources.SpecImage_SWORD7
import com.elkite.warborn.resources.SwordAttack_1
import com.elkite.warborn.resources.SwordAttack_2
import com.elkite.warborn.resources.SwordAttack_3
import com.elkite.warborn.resources.Sword_Carving
import com.elkite.warborn.resources.Sword_Clarent
import com.elkite.warborn.resources.Sword_Claymore
import com.elkite.warborn.resources.Sword_Common_Skill_1
import com.elkite.warborn.resources.Sword_Common_Skill_2
import com.elkite.warborn.resources.Sword_Common_Skill_3
import com.elkite.warborn.resources.Sword_Common_Skill_4
import com.elkite.warborn.resources.Sword_Common_Skill_5
import com.elkite.warborn.resources.Sword_KingSlash
import com.elkite.warborn.resources.Sword_Knight
import com.elkite.warborn.resources.Sword_Passive
import com.elkite.warborn.resources.Sword_ThousandBlade
import com.elkite.warborn.resources.Sword_ZeroSlash
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object SwordResources {
    fun getSwordWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Storm Cleaver" -> Res.drawable.SpecImage_SWORD4
            "Hellcore Cleaver" -> Res.drawable.SpecImage_SWORD1
            "Voidblade" -> Res.drawable.SpecImage_SWORD3
            "Lordbreaker" -> Res.drawable.SpecImage_SWORD5
            "Titan's Spineblade" -> Res.drawable.SpecImage_SWORD6
            "Judicator" -> Res.drawable.SpecImage_SWORD2
            "Sovereign's Radiance" -> Res.drawable.SpecImage_SWORD7
            else -> Res.drawable.error_emoji
        }
    }

    fun getSwordSkillIcon(id: String): DrawableResource {
        return when (id) {
            "SwordAttack_1" -> Res.drawable.SwordAttack_1
            "SwordAttack_2" -> Res.drawable.SwordAttack_2
            "SwordAttack_3" -> Res.drawable.SwordAttack_3
            "Sword_Common_Skill_1" -> Res.drawable.Sword_Common_Skill_1
            "Sword_Common_Skill_3" -> Res.drawable.Sword_Common_Skill_3
            "Sword_Common_Skill_4" -> Res.drawable.Sword_Common_Skill_4
            "Sword_Common_Skill_5" -> Res.drawable.Sword_Common_Skill_5
            "Sword_Common_Skill_2" -> Res.drawable.Sword_Common_Skill_2
            "Sword_ZeroSlash" -> Res.drawable.Sword_ZeroSlash
            "Sword_Passive" -> Res.drawable.Sword_Passive
            "Sword_Claymore" -> Res.drawable.Sword_Claymore
            "Sword_Clarent" -> Res.drawable.Sword_Clarent
            "Sword_KingSlash" -> Res.drawable.Sword_KingSlash
            "Sword_Knight" -> Res.drawable.Sword_Knight
            "Sword_Carving" -> Res.drawable.Sword_Carving
            "Sword_ThousandBlade" -> Res.drawable.Sword_ThousandBlade
            else -> Res.drawable.error_emoji
        }
    }

    fun getSwordSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Sword
    }
}
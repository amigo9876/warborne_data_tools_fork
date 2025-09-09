package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Nature
import com.elkite.warborn.resources.NatureAttack_1
import com.elkite.warborn.resources.NatureAttack_3
import com.elkite.warborn.resources.Nature_Common_Attack2
import com.elkite.warborn.resources.Nature_Common_Skill2
import com.elkite.warborn.resources.Nature_Common_Skill3
import com.elkite.warborn.resources.Nature_Common_Skill5
import com.elkite.warborn.resources.Nature_Common_Skill_1
import com.elkite.warborn.resources.Nature_Common_Skill_4
import com.elkite.warborn.resources.Nature_GodTree
import com.elkite.warborn.resources.Nature_HealRain
import com.elkite.warborn.resources.Nature_HolyDeer
import com.elkite.warborn.resources.Nature_MoonFire
import com.elkite.warborn.resources.Nature_Passive
import com.elkite.warborn.resources.Nature_Tranquility
import com.elkite.warborn.resources.Nature_TreeSkin
import com.elkite.warborn.resources.Nature_TwineSeed
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_NATURE1
import com.elkite.warborn.resources.SpecImage_NATURE2
import com.elkite.warborn.resources.SpecImage_NATURE3
import com.elkite.warborn.resources.SpecImage_NATURE4
import com.elkite.warborn.resources.SpecImage_NATURE5
import com.elkite.warborn.resources.SpecImage_NATURE6
import com.elkite.warborn.resources.SpecImage_NATURE7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object NatureResources {
    fun getNatureWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Eclipse Conduit" -> Res.drawable.SpecImage_NATURE1
            "Thornward Staff" -> Res.drawable.SpecImage_NATURE2
            "Harmony's Staff" -> Res.drawable.SpecImage_NATURE3
            "Verdant Embrace" -> Res.drawable.SpecImage_NATURE4
            "Tendril's Grasp" -> Res.drawable.SpecImage_NATURE6
            "Spirit's Call" -> Res.drawable.SpecImage_NATURE5
            "Sanctuary of Growth" -> Res.drawable.SpecImage_NATURE7
            else -> Res.drawable.error_emoji
        }
    }

    fun getNatureSkillIcon(id: String): DrawableResource {
        return when (id) {
            "NatureAttack_1" -> Res.drawable.NatureAttack_1
            "Nature_Common_Attack2" -> Res.drawable.Nature_Common_Attack2
            "NatureAttack_3" -> Res.drawable.NatureAttack_3
            "Nature_Common_Skill_1" -> Res.drawable.Nature_Common_Skill_1
            "Nature_Common_Skill_2" -> Res.drawable.Nature_Common_Skill2
            "Nature_Common_Skill_3" -> Res.drawable.Nature_Common_Skill3
            "Nature_Common_Skill_5" -> Res.drawable.Nature_Common_Skill5
            "Nature_Common_Skill_4" -> Res.drawable.Nature_Common_Skill_4
            "Nature_Passive" -> Res.drawable.Nature_Passive
            "Nature_MoonFire" -> Res.drawable.Nature_MoonFire
            "Nature_TreeSkin" -> Res.drawable.Nature_TreeSkin
            "Nature_HealRain" -> Res.drawable.Nature_HealRain
            "Nature_Tranquility" -> Res.drawable.Nature_Tranquility
            "Nature_TwineSeed" -> Res.drawable.Nature_TwineSeed
            "Nature_HolyDeer" -> Res.drawable.Nature_HolyDeer
            "Nature_GodTree" -> Res.drawable.Nature_GodTree
            else -> Res.drawable.error_emoji
        }
    }

    fun getNatureSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Nature
    }
}
package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Frost
import com.elkite.warborn.resources.IceStaffAttack_1
import com.elkite.warborn.resources.IceStaffAttack_2
import com.elkite.warborn.resources.IceStaffAttack_3
import com.elkite.warborn.resources.IceStaff_Chillhowl
import com.elkite.warborn.resources.IceStaff_Common_Skill_2
import com.elkite.warborn.resources.IceStaff_Common_Skill_3
import com.elkite.warborn.resources.IceStaff_Common_Skill_4
import com.elkite.warborn.resources.IceStaff_Common_Skill_5
import com.elkite.warborn.resources.IceStaff_Common_Skill_6
import com.elkite.warborn.resources.IceStaff_Frost
import com.elkite.warborn.resources.IceStaff_GreatFrost
import com.elkite.warborn.resources.IceStaff_IceAvatar
import com.elkite.warborn.resources.IceStaff_IcePhase
import com.elkite.warborn.resources.IceStaff_Icicle
import com.elkite.warborn.resources.IceStaff_Passive
import com.elkite.warborn.resources.IceStaff_Permafrost
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_FROST1
import com.elkite.warborn.resources.SpecImage_FROST2
import com.elkite.warborn.resources.SpecImage_FROST3
import com.elkite.warborn.resources.SpecImage_FROST4
import com.elkite.warborn.resources.SpecImage_FROST5
import com.elkite.warborn.resources.SpecImage_FROST6
import com.elkite.warborn.resources.SpecImage_FROST7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object FrostResources {
    fun getFrostWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Glacier Prism" -> Res.drawable.SpecImage_FROST1
            "Frost Matrix" -> Res.drawable.SpecImage_FROST2
            "Glacier Spark" -> Res.drawable.SpecImage_FROST3
            "Cryoshard Mask" -> Res.drawable.SpecImage_FROST4
            "Iceshard Comet" -> Res.drawable.SpecImage_FROST5
            "Frozen Conduit" -> Res.drawable.SpecImage_FROST6
            "Frost's Caller" -> Res.drawable.SpecImage_FROST7
            else -> Res.drawable.error_emoji
        }
    }

    fun getFrostSkillIcon(id: String): DrawableResource {
        return when (id) {
            "IceStaffAttack_1" -> Res.drawable.IceStaffAttack_1
            "IceStaffAttack_2" -> Res.drawable.IceStaffAttack_2
            "IceStaffAttack_3" -> Res.drawable.IceStaffAttack_3
            "IceStaff_Common_Skill_6" -> Res.drawable.IceStaff_Common_Skill_6
            "IceStaff_Common_Skill_2" -> Res.drawable.IceStaff_Common_Skill_2
            "IceStaff_Common_Skill_3" -> Res.drawable.IceStaff_Common_Skill_3
            "IceStaff_Common_Skill_4" -> Res.drawable.IceStaff_Common_Skill_4
            "IceStaff_Common_Skill_5" -> Res.drawable.IceStaff_Common_Skill_5
            "IceStaff_Passive" -> Res.drawable.IceStaff_Passive
            "IceStaff_Frost" -> Res.drawable.IceStaff_Frost
            "IceStaff_Icicle" -> Res.drawable.IceStaff_Icicle
            "IceStaff_Chillhowl" -> Res.drawable.IceStaff_Chillhowl
            "IceStaff_GreatFrost" -> Res.drawable.IceStaff_GreatFrost
            "IceStaff_IcePhase" -> Res.drawable.IceStaff_IcePhase
            "IceStaff_Permafrost" -> Res.drawable.IceStaff_Permafrost
            "IceStaff_IceAvatar" -> Res.drawable.IceStaff_IceAvatar
            else -> Res.drawable.error_emoji
        }
    }

    fun getFrostSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Frost
    }
}
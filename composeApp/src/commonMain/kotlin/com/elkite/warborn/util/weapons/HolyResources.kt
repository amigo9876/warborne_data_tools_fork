package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Staff
import com.elkite.warborn.resources.HolyStaffAttack_1
import com.elkite.warborn.resources.HolyStaffAttack_2
import com.elkite.warborn.resources.HolyStaffAttack_3
import com.elkite.warborn.resources.HolyStaff_Common_Skill_1
import com.elkite.warborn.resources.HolyStaff_Common_Skill_2
import com.elkite.warborn.resources.HolyStaff_Common_Skill_3
import com.elkite.warborn.resources.HolyStaff_Common_Skill_4
import com.elkite.warborn.resources.HolyStaff_Common_Skill_5
import com.elkite.warborn.resources.HolyStaff_Fallen
import com.elkite.warborn.resources.HolyStaff_Fulgent
import com.elkite.warborn.resources.HolyStaff_HolyGuardian
import com.elkite.warborn.resources.HolyStaff_HolyShine
import com.elkite.warborn.resources.HolyStaff_LeapFaith
import com.elkite.warborn.resources.HolyStaff_Passive
import com.elkite.warborn.resources.HolyStaff_Redemption
import com.elkite.warborn.resources.HolyStaff_Shield
import com.elkite.warborn.resources.HolyStaff_SingleHoly
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_STAFF1
import com.elkite.warborn.resources.SpecImage_STAFF2
import com.elkite.warborn.resources.SpecImage_STAFF3
import com.elkite.warborn.resources.SpecImage_STAFF4
import com.elkite.warborn.resources.SpecImage_STAFF5
import com.elkite.warborn.resources.SpecImage_STAFF6
import com.elkite.warborn.resources.SpecImage_STAFF7
import com.elkite.warborn.resources.SpecImage_STAFF8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object HolyResources {
    fun getHolyWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Guardian's Embrace" -> Res.drawable.SpecImage_STAFF1
            "Celestial Redeemer" -> Res.drawable.SpecImage_STAFF2
            "Luminous Ward" -> Res.drawable.SpecImage_STAFF3
            "Judgement's Staff" -> Res.drawable.SpecImage_STAFF4
            "Divine Resonator" -> Res.drawable.SpecImage_STAFF5
            "Radiant Nova" -> Res.drawable.SpecImage_STAFF6
            "Sol Protector" -> Res.drawable.SpecImage_STAFF7
            "Fulgent Staff" -> Res.drawable.SpecImage_STAFF8
            else -> Res.drawable.error_emoji
        }
    }

    fun getHolySkillIcon(id: String): DrawableResource {
        return when (id) {
            "HolyStaffAttack_1" -> Res.drawable.HolyStaffAttack_1
            "HolyStaffAttack_2" -> Res.drawable.HolyStaffAttack_2
            "HolyStaffAttack_3" -> Res.drawable.HolyStaffAttack_3
            "HolyStaff_Common_Skill_1" -> Res.drawable.HolyStaff_Common_Skill_1
            "HolyStaff_Common_Skill_2" -> Res.drawable.HolyStaff_Common_Skill_2
            "HolyStaff_Common_Skill_3" -> Res.drawable.HolyStaff_Common_Skill_3
            "HolyStaff_Common_Skill_4" -> Res.drawable.HolyStaff_Common_Skill_4
            "HolyStaff_Common_Skill_5" -> Res.drawable.HolyStaff_Common_Skill_5
            "HolyStaff_Shield" -> Res.drawable.HolyStaff_Shield
            "HolyStaff_LeapFaith" -> Res.drawable.HolyStaff_LeapFaith
            "HolyStaff_Redemption" -> Res.drawable.HolyStaff_Redemption
            "HolyStaff_SingleHoly" -> Res.drawable.HolyStaff_SingleHoly
            "HolyStaff_HolyShine" -> Res.drawable.HolyStaff_HolyShine
            "HolyStaff_Fallen" -> Res.drawable.HolyStaff_Fallen
            "HolyStaff_HolyGuardian" -> Res.drawable.HolyStaff_HolyGuardian
            "HolyStaff_Passive" -> Res.drawable.HolyStaff_Passive
            "HolyStaff_Fulgent" -> Res.drawable.HolyStaff_Fulgent
            else -> Res.drawable.error_emoji
        }
    }

    fun getHolySlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Staff
    }
}
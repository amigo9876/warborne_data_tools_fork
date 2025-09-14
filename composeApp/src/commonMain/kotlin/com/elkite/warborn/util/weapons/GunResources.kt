package com.elkite.warborn.util.weapons

import com.elkite.warborn.resources.Com_Weapon_Gun
import com.elkite.warborn.resources.GunAttack_1
import com.elkite.warborn.resources.GunAttack_2
import com.elkite.warborn.resources.GunAttack_3
import com.elkite.warborn.resources.Gun_BulletCharge
import com.elkite.warborn.resources.Gun_Common_Skill_1
import com.elkite.warborn.resources.Gun_Common_Skill_3
import com.elkite.warborn.resources.Gun_Common_Skill_4
import com.elkite.warborn.resources.Gun_Common_Skill_5
import com.elkite.warborn.resources.Gun_Common_Skill_6
import com.elkite.warborn.resources.Gun_Flashbang
import com.elkite.warborn.resources.Gun_GatlinGun
import com.elkite.warborn.resources.Gun_Grenade
import com.elkite.warborn.resources.Gun_PrismGun
import com.elkite.warborn.resources.Gun_RayGun
import com.elkite.warborn.resources.Gun_RifleGun
import com.elkite.warborn.resources.Gun_ShotGun
import com.elkite.warborn.resources.Gun_ThreeGun
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_GUN1
import com.elkite.warborn.resources.SpecImage_GUN2
import com.elkite.warborn.resources.SpecImage_GUN3
import com.elkite.warborn.resources.SpecImage_GUN4
import com.elkite.warborn.resources.SpecImage_GUN5
import com.elkite.warborn.resources.SpecImage_GUN6
import com.elkite.warborn.resources.SpecImage_GUN7
import com.elkite.warborn.resources.SpecImage_GUN8
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object GunResources {
    fun getGunWeaponIcon(id: String): DrawableResource {
        return when (id) {
            "Shattercoil" -> Res.drawable.SpecImage_GUN1
            "Sentinel Barrage" -> Res.drawable.SpecImage_GUN2
            "Burstfire Rifle" -> Res.drawable.SpecImage_GUN3
            "Blightspitter" -> Res.drawable.SpecImage_GUN4
            "Voideye" -> Res.drawable.SpecImage_GUN5
            "Shadowhunter Rifle" -> Res.drawable.SpecImage_GUN6
            "Prism Cloak" -> Res.drawable.SpecImage_GUN7
            "Photonic Rifle" -> Res.drawable.SpecImage_GUN8
            else -> Res.drawable.error_emoji
        }
    }

    fun getGunSkillIcon(id: String): DrawableResource {
        return when (id) {
            "GunAttack_1" -> Res.drawable.GunAttack_1
            "GunAttack_2" -> Res.drawable.GunAttack_2
            "GunAttack_3" -> Res.drawable.GunAttack_3
            "Gun_Common_Skill_1" -> Res.drawable.Gun_Common_Skill_1
            "Gun_Common_Skill_6" -> Res.drawable.Gun_Common_Skill_6
            "Gun_Common_Skill_4" -> Res.drawable.Gun_Common_Skill_4
            "Gun_Flashbang" -> Res.drawable.Gun_Flashbang
            "Gun_Common_Skill_3" -> Res.drawable.Gun_Common_Skill_3
            "Gun_ShotGun" -> Res.drawable.Gun_ShotGun
            "Gun_BulletCharge" -> Res.drawable.Gun_BulletCharge
            "Gun_GatlinGun" -> Res.drawable.Gun_GatlinGun
            "Gun_ThreeGun" -> Res.drawable.Gun_ThreeGun
            "Gun_Grenade" -> Res.drawable.Gun_Grenade
            "Gun_Common_Skill_5" -> Res.drawable.Gun_Common_Skill_5
            "Gun_RifleGun" -> Res.drawable.Gun_RifleGun
            "Gun_PrismGun" -> Res.drawable.Gun_PrismGun
            "Gun_RayGun" -> Res.drawable.Gun_RayGun
            else -> Res.drawable.error_emoji
        }
    }

    fun getGunSlotIcon(): DrawableResource {
        return Res.drawable.Com_Weapon_Gun
    }
}
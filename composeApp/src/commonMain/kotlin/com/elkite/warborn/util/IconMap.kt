package com.elkite.warborn.util

import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.domain.entities.old.drifter.Drifter
import com.elkite.warborn.resources.ArmorEpic1
import com.elkite.warborn.resources.ArmorEpic2
import com.elkite.warborn.resources.ArmorEpic3
import com.elkite.warborn.resources.ArmorEpic4
import com.elkite.warborn.resources.ArmorEpic5
import com.elkite.warborn.resources.ArmorEpic6
import com.elkite.warborn.resources.ArmorEpic7
import com.elkite.warborn.resources.ArmorEpic8
import com.elkite.warborn.resources.ArmorEpic9
import com.elkite.warborn.resources.ArmorExclusiveLgdr1
import com.elkite.warborn.resources.ArmorExclusiveLgdr2
import com.elkite.warborn.resources.ArmorExclusiveLgdr3
import com.elkite.warborn.resources.ArmorExclusiveLgdr4
import com.elkite.warborn.resources.ArmorExclusiveLgdr5
import com.elkite.warborn.resources.ArmorExclusiveLgdr6
import com.elkite.warborn.resources.ArmorLgdr1
import com.elkite.warborn.resources.ArmorLgdr2
import com.elkite.warborn.resources.ArmorLgdr3
import com.elkite.warborn.resources.ArmorRare1
import com.elkite.warborn.resources.ArmorRare2
import com.elkite.warborn.resources.ArmorRare3
import com.elkite.warborn.resources.ArmorRare4
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
import com.elkite.warborn.resources.Cloth_Dex_1
import com.elkite.warborn.resources.Cloth_Dex_2
import com.elkite.warborn.resources.Cloth_Dex_3
import com.elkite.warborn.resources.Cloth_Dex_4
import com.elkite.warborn.resources.Cloth_Dex_5
import com.elkite.warborn.resources.Cloth_Dex_6
import com.elkite.warborn.resources.Cloth_Dex_7
import com.elkite.warborn.resources.Cloth_Int_1
import com.elkite.warborn.resources.Cloth_Int_2
import com.elkite.warborn.resources.Cloth_Int_3
import com.elkite.warborn.resources.Cloth_Int_5
import com.elkite.warborn.resources.Cloth_Int_7
import com.elkite.warborn.resources.Cloth_Int_8
import com.elkite.warborn.resources.Cloth_Str_1
import com.elkite.warborn.resources.Cloth_Str_2
import com.elkite.warborn.resources.Cloth_Str_3
import com.elkite.warborn.resources.Cloth_Str_4
import com.elkite.warborn.resources.Cloth_Str_5
import com.elkite.warborn.resources.Cloth_Str_6
import com.elkite.warborn.resources.Cloth_Str_8
import com.elkite.warborn.resources.Com_Weapon_Axe
import com.elkite.warborn.resources.Com_Weapon_Bow
import com.elkite.warborn.resources.Com_Weapon_Curse
import com.elkite.warborn.resources.Com_Weapon_Dagger
import com.elkite.warborn.resources.Com_Weapon_Fire
import com.elkite.warborn.resources.Com_Weapon_Frost
import com.elkite.warborn.resources.Com_Weapon_Gun
import com.elkite.warborn.resources.Com_Weapon_Mace
import com.elkite.warborn.resources.Com_Weapon_Nature
import com.elkite.warborn.resources.Com_Weapon_Spear
import com.elkite.warborn.resources.Com_Weapon_Staff
import com.elkite.warborn.resources.Com_Weapon_Sword
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
import com.elkite.warborn.resources.DaggerAttack_2
import com.elkite.warborn.resources.DaggerAttack_3
import com.elkite.warborn.resources.DaggerAttack_4
import com.elkite.warborn.resources.Dagger_BloodDagger
import com.elkite.warborn.resources.Dagger_Common_Skill_1
import com.elkite.warborn.resources.Dagger_Common_Skill_2
import com.elkite.warborn.resources.Dagger_Common_Skill_3
import com.elkite.warborn.resources.Dagger_Common_Skill_4
import com.elkite.warborn.resources.Dagger_Common_Skill_5
import com.elkite.warborn.resources.Dagger_Dagger
import com.elkite.warborn.resources.Dagger_DeathDagger
import com.elkite.warborn.resources.Dagger_FastDagger
import com.elkite.warborn.resources.Dagger_LongDagger
import com.elkite.warborn.resources.Dagger_Passive
import com.elkite.warborn.resources.EnhancementItem_ARMOR1
import com.elkite.warborn.resources.EnhancementItem_ARMOR2
import com.elkite.warborn.resources.EnhancementItem_ARMOR3
import com.elkite.warborn.resources.EnhancementItem_ARMOR4
import com.elkite.warborn.resources.EnhancementItem_ARMOR5
import com.elkite.warborn.resources.EnhancementItem_ARMOR6
import com.elkite.warborn.resources.EnhancementItem_ARMOR7
import com.elkite.warborn.resources.EnhancementItem_AXE1
import com.elkite.warborn.resources.EnhancementItem_AXE2
import com.elkite.warborn.resources.EnhancementItem_AXE3
import com.elkite.warborn.resources.EnhancementItem_AXE4
import com.elkite.warborn.resources.EnhancementItem_AXE5
import com.elkite.warborn.resources.EnhancementItem_AXE6
import com.elkite.warborn.resources.EnhancementItem_AXE7
import com.elkite.warborn.resources.EnhancementItem_BOOTS1
import com.elkite.warborn.resources.EnhancementItem_BOOTS2
import com.elkite.warborn.resources.EnhancementItem_BOOTS3
import com.elkite.warborn.resources.EnhancementItem_BOOTS4
import com.elkite.warborn.resources.EnhancementItem_BOOTS5
import com.elkite.warborn.resources.EnhancementItem_BOOTS6
import com.elkite.warborn.resources.EnhancementItem_BOOTS7
import com.elkite.warborn.resources.EnhancementItem_BOW1
import com.elkite.warborn.resources.EnhancementItem_BOW2
import com.elkite.warborn.resources.EnhancementItem_BOW3
import com.elkite.warborn.resources.EnhancementItem_BOW4
import com.elkite.warborn.resources.EnhancementItem_BOW5
import com.elkite.warborn.resources.EnhancementItem_BOW6
import com.elkite.warborn.resources.EnhancementItem_BOW7
import com.elkite.warborn.resources.EnhancementItem_COWL1
import com.elkite.warborn.resources.EnhancementItem_COWL2
import com.elkite.warborn.resources.EnhancementItem_COWL3
import com.elkite.warborn.resources.EnhancementItem_COWL4
import com.elkite.warborn.resources.EnhancementItem_COWL5
import com.elkite.warborn.resources.EnhancementItem_COWL6
import com.elkite.warborn.resources.EnhancementItem_COWL7
import com.elkite.warborn.resources.EnhancementItem_CURSE1
import com.elkite.warborn.resources.EnhancementItem_CURSE2
import com.elkite.warborn.resources.EnhancementItem_CURSE3
import com.elkite.warborn.resources.EnhancementItem_CURSE4
import com.elkite.warborn.resources.EnhancementItem_CURSE5
import com.elkite.warborn.resources.EnhancementItem_CURSE6
import com.elkite.warborn.resources.EnhancementItem_CURSE7
import com.elkite.warborn.resources.EnhancementItem_DAGGER1
import com.elkite.warborn.resources.EnhancementItem_DAGGER2
import com.elkite.warborn.resources.EnhancementItem_DAGGER3
import com.elkite.warborn.resources.EnhancementItem_DAGGER4
import com.elkite.warborn.resources.EnhancementItem_DAGGER5
import com.elkite.warborn.resources.EnhancementItem_DAGGER6
import com.elkite.warborn.resources.EnhancementItem_DAGGER7
import com.elkite.warborn.resources.EnhancementItem_FIRE1
import com.elkite.warborn.resources.EnhancementItem_FIRE2
import com.elkite.warborn.resources.EnhancementItem_FIRE3
import com.elkite.warborn.resources.EnhancementItem_FIRE4
import com.elkite.warborn.resources.EnhancementItem_FIRE5
import com.elkite.warborn.resources.EnhancementItem_FIRE6
import com.elkite.warborn.resources.EnhancementItem_FIRE7
import com.elkite.warborn.resources.EnhancementItem_FROST1
import com.elkite.warborn.resources.EnhancementItem_FROST2
import com.elkite.warborn.resources.EnhancementItem_FROST3
import com.elkite.warborn.resources.EnhancementItem_FROST4
import com.elkite.warborn.resources.EnhancementItem_FROST5
import com.elkite.warborn.resources.EnhancementItem_FROST6
import com.elkite.warborn.resources.EnhancementItem_FROST7
import com.elkite.warborn.resources.EnhancementItem_GUN1
import com.elkite.warborn.resources.EnhancementItem_GUN2
import com.elkite.warborn.resources.EnhancementItem_GUN3
import com.elkite.warborn.resources.EnhancementItem_GUN4
import com.elkite.warborn.resources.EnhancementItem_GUN5
import com.elkite.warborn.resources.EnhancementItem_GUN6
import com.elkite.warborn.resources.EnhancementItem_GUN7
import com.elkite.warborn.resources.EnhancementItem_HELMET1
import com.elkite.warborn.resources.EnhancementItem_HELMET2
import com.elkite.warborn.resources.EnhancementItem_HELMET3
import com.elkite.warborn.resources.EnhancementItem_HELMET4
import com.elkite.warborn.resources.EnhancementItem_HELMET5
import com.elkite.warborn.resources.EnhancementItem_HELMET6
import com.elkite.warborn.resources.EnhancementItem_HELMET7
import com.elkite.warborn.resources.EnhancementItem_HOOD1
import com.elkite.warborn.resources.EnhancementItem_HOOD2
import com.elkite.warborn.resources.EnhancementItem_HOOD3
import com.elkite.warborn.resources.EnhancementItem_HOOD4
import com.elkite.warborn.resources.EnhancementItem_HOOD5
import com.elkite.warborn.resources.EnhancementItem_HOOD6
import com.elkite.warborn.resources.EnhancementItem_HOOD7
import com.elkite.warborn.resources.EnhancementItem_JACKET1
import com.elkite.warborn.resources.EnhancementItem_JACKET2
import com.elkite.warborn.resources.EnhancementItem_JACKET3
import com.elkite.warborn.resources.EnhancementItem_JACKET4
import com.elkite.warborn.resources.EnhancementItem_JACKET5
import com.elkite.warborn.resources.EnhancementItem_JACKET6
import com.elkite.warborn.resources.EnhancementItem_JACKET7
import com.elkite.warborn.resources.EnhancementItem_MACE1
import com.elkite.warborn.resources.EnhancementItem_MACE2
import com.elkite.warborn.resources.EnhancementItem_MACE3
import com.elkite.warborn.resources.EnhancementItem_MACE4
import com.elkite.warborn.resources.EnhancementItem_MACE5
import com.elkite.warborn.resources.EnhancementItem_MACE6
import com.elkite.warborn.resources.EnhancementItem_MACE7
import com.elkite.warborn.resources.EnhancementItem_NATURE1
import com.elkite.warborn.resources.EnhancementItem_NATURE2
import com.elkite.warborn.resources.EnhancementItem_NATURE3
import com.elkite.warborn.resources.EnhancementItem_NATURE4
import com.elkite.warborn.resources.EnhancementItem_NATURE5
import com.elkite.warborn.resources.EnhancementItem_NATURE6
import com.elkite.warborn.resources.EnhancementItem_NATURE7
import com.elkite.warborn.resources.EnhancementItem_ROBE1
import com.elkite.warborn.resources.EnhancementItem_ROBE2
import com.elkite.warborn.resources.EnhancementItem_ROBE3
import com.elkite.warborn.resources.EnhancementItem_ROBE4
import com.elkite.warborn.resources.EnhancementItem_ROBE5
import com.elkite.warborn.resources.EnhancementItem_ROBE6
import com.elkite.warborn.resources.EnhancementItem_ROBE7
import com.elkite.warborn.resources.EnhancementItem_SANDALS1
import com.elkite.warborn.resources.EnhancementItem_SANDALS2
import com.elkite.warborn.resources.EnhancementItem_SANDALS3
import com.elkite.warborn.resources.EnhancementItem_SANDALS4
import com.elkite.warborn.resources.EnhancementItem_SANDALS5
import com.elkite.warborn.resources.EnhancementItem_SANDALS6
import com.elkite.warborn.resources.EnhancementItem_SANDALS7
import com.elkite.warborn.resources.EnhancementItem_SHOES1
import com.elkite.warborn.resources.EnhancementItem_SHOES2
import com.elkite.warborn.resources.EnhancementItem_SHOES3
import com.elkite.warborn.resources.EnhancementItem_SHOES4
import com.elkite.warborn.resources.EnhancementItem_SHOES5
import com.elkite.warborn.resources.EnhancementItem_SHOES6
import com.elkite.warborn.resources.EnhancementItem_SHOES7
import com.elkite.warborn.resources.EnhancementItem_SPEAR1
import com.elkite.warborn.resources.EnhancementItem_SPEAR2
import com.elkite.warborn.resources.EnhancementItem_SPEAR3
import com.elkite.warborn.resources.EnhancementItem_SPEAR4
import com.elkite.warborn.resources.EnhancementItem_SPEAR6
import com.elkite.warborn.resources.EnhancementItem_SPEAR7
import com.elkite.warborn.resources.EnhancementItem_SPEAR8
import com.elkite.warborn.resources.EnhancementItem_STAFF1
import com.elkite.warborn.resources.EnhancementItem_STAFF2
import com.elkite.warborn.resources.EnhancementItem_STAFF3
import com.elkite.warborn.resources.EnhancementItem_STAFF4
import com.elkite.warborn.resources.EnhancementItem_STAFF5
import com.elkite.warborn.resources.EnhancementItem_STAFF6
import com.elkite.warborn.resources.EnhancementItem_STAFF7
import com.elkite.warborn.resources.EnhancementItem_SWORD1
import com.elkite.warborn.resources.EnhancementItem_SWORD2
import com.elkite.warborn.resources.EnhancementItem_SWORD3
import com.elkite.warborn.resources.EnhancementItem_SWORD4
import com.elkite.warborn.resources.EnhancementItem_SWORD5
import com.elkite.warborn.resources.EnhancementItem_SWORD6
import com.elkite.warborn.resources.EnhancementItem_SWORD7
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
import com.elkite.warborn.resources.Gun_RifleGun
import com.elkite.warborn.resources.Gun_ShotGun
import com.elkite.warborn.resources.Gun_ThreeGun
import com.elkite.warborn.resources.Helm_Dex_1
import com.elkite.warborn.resources.Helm_Dex_2
import com.elkite.warborn.resources.Helm_Dex_3
import com.elkite.warborn.resources.Helm_Dex_4
import com.elkite.warborn.resources.Helm_Dex_5
import com.elkite.warborn.resources.Helm_Dex_7
import com.elkite.warborn.resources.Helm_Dex_8
import com.elkite.warborn.resources.Helm_Int_1
import com.elkite.warborn.resources.Helm_Int_2
import com.elkite.warborn.resources.Helm_Int_3
import com.elkite.warborn.resources.Helm_Int_4
import com.elkite.warborn.resources.Helm_Int_5
import com.elkite.warborn.resources.Helm_Int_7
import com.elkite.warborn.resources.Helm_Int_8
import com.elkite.warborn.resources.Helm_Str_1
import com.elkite.warborn.resources.Helm_Str_3
import com.elkite.warborn.resources.Helm_Str_4
import com.elkite.warborn.resources.Helm_Str_5
import com.elkite.warborn.resources.Helm_Str_6
import com.elkite.warborn.resources.Helm_Str_7
import com.elkite.warborn.resources.Helm_Str_8
import com.elkite.warborn.resources.HolyStaffAttack_1
import com.elkite.warborn.resources.HolyStaffAttack_2
import com.elkite.warborn.resources.HolyStaffAttack_3
import com.elkite.warborn.resources.HolyStaff_Common_Skill_1
import com.elkite.warborn.resources.HolyStaff_Common_Skill_2
import com.elkite.warborn.resources.HolyStaff_Common_Skill_3
import com.elkite.warborn.resources.HolyStaff_Common_Skill_4
import com.elkite.warborn.resources.HolyStaff_Common_Skill_5
import com.elkite.warborn.resources.HolyStaff_Fallen
import com.elkite.warborn.resources.HolyStaff_HolyGuardian
import com.elkite.warborn.resources.HolyStaff_HolyShine
import com.elkite.warborn.resources.HolyStaff_LeapFaith
import com.elkite.warborn.resources.HolyStaff_Passive
import com.elkite.warborn.resources.HolyStaff_Redemption
import com.elkite.warborn.resources.HolyStaff_Shield
import com.elkite.warborn.resources.HolyStaff_SingleHoly
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
import com.elkite.warborn.resources.Mace_Passive
import com.elkite.warborn.resources.Mace_ShieldMace_2
import com.elkite.warborn.resources.Mace_ThunderMace
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
import com.elkite.warborn.resources.ParagonCard_Dex_1
import com.elkite.warborn.resources.ParagonCard_Dex_2
import com.elkite.warborn.resources.ParagonCard_Dex_3
import com.elkite.warborn.resources.ParagonCard_Dex_4
import com.elkite.warborn.resources.ParagonCard_Dex_5
import com.elkite.warborn.resources.ParagonCard_Dex_6
import com.elkite.warborn.resources.ParagonCard_Dex_7
import com.elkite.warborn.resources.ParagonCard_Dex_8
import com.elkite.warborn.resources.ParagonCard_Dex_9
import com.elkite.warborn.resources.ParagonCard_Int_1
import com.elkite.warborn.resources.ParagonCard_Int_10
import com.elkite.warborn.resources.ParagonCard_Int_11
import com.elkite.warborn.resources.ParagonCard_Int_13
import com.elkite.warborn.resources.ParagonCard_Int_2
import com.elkite.warborn.resources.ParagonCard_Int_3
import com.elkite.warborn.resources.ParagonCard_Int_4
import com.elkite.warborn.resources.ParagonCard_Int_6
import com.elkite.warborn.resources.ParagonCard_Int_7
import com.elkite.warborn.resources.ParagonCard_Int_9
import com.elkite.warborn.resources.ParagonCard_Nonepng
import com.elkite.warborn.resources.ParagonCard_Str_1
import com.elkite.warborn.resources.ParagonCard_Str_2
import com.elkite.warborn.resources.ParagonCard_Str_3
import com.elkite.warborn.resources.ParagonCard_Str_4
import com.elkite.warborn.resources.ParagonCard_Str_5
import com.elkite.warborn.resources.ParagonCard_Str_6
import com.elkite.warborn.resources.ParagonCard_Str_7
import com.elkite.warborn.resources.ParagonCard_Str_8
import com.elkite.warborn.resources.ParagonCard_Str_9
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_1
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_2
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_3
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_4
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_5
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_6
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_7
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_8
import com.elkite.warborn.resources.ParagonFullBodyBg_Dex_9
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_1
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_10
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_11
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_13
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_2
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_3
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_4
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_6
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_7
import com.elkite.warborn.resources.ParagonFullBodyBg_Int_9
import com.elkite.warborn.resources.ParagonFullBodyBg_None
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_1
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_2
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_3
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_4
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_5
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_6
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_7
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_8
import com.elkite.warborn.resources.ParagonFullBodyBg_Str_9
import com.elkite.warborn.resources.ParagonFullBody_Dex_1
import com.elkite.warborn.resources.ParagonFullBody_Dex_2
import com.elkite.warborn.resources.ParagonFullBody_Dex_3
import com.elkite.warborn.resources.ParagonFullBody_Dex_4
import com.elkite.warborn.resources.ParagonFullBody_Dex_5
import com.elkite.warborn.resources.ParagonFullBody_Dex_6
import com.elkite.warborn.resources.ParagonFullBody_Dex_7
import com.elkite.warborn.resources.ParagonFullBody_Dex_8
import com.elkite.warborn.resources.ParagonFullBody_Dex_9
import com.elkite.warborn.resources.ParagonFullBody_Int_1
import com.elkite.warborn.resources.ParagonFullBody_Int_10
import com.elkite.warborn.resources.ParagonFullBody_Int_11
import com.elkite.warborn.resources.ParagonFullBody_Int_13
import com.elkite.warborn.resources.ParagonFullBody_Int_2
import com.elkite.warborn.resources.ParagonFullBody_Int_3
import com.elkite.warborn.resources.ParagonFullBody_Int_4
import com.elkite.warborn.resources.ParagonFullBody_Int_6
import com.elkite.warborn.resources.ParagonFullBody_Int_7
import com.elkite.warborn.resources.ParagonFullBody_Int_9
import com.elkite.warborn.resources.ParagonFullBody_None
import com.elkite.warborn.resources.ParagonFullBody_Str_1
import com.elkite.warborn.resources.ParagonFullBody_Str_2
import com.elkite.warborn.resources.ParagonFullBody_Str_3
import com.elkite.warborn.resources.ParagonFullBody_Str_4
import com.elkite.warborn.resources.ParagonFullBody_Str_5
import com.elkite.warborn.resources.ParagonFullBody_Str_6
import com.elkite.warborn.resources.ParagonFullBody_Str_7
import com.elkite.warborn.resources.ParagonFullBody_Str_8
import com.elkite.warborn.resources.ParagonFullBody_Str_9
import com.elkite.warborn.resources.ParagonPortrait_Dex_1
import com.elkite.warborn.resources.ParagonPortrait_Dex_2
import com.elkite.warborn.resources.ParagonPortrait_Dex_3
import com.elkite.warborn.resources.ParagonPortrait_Dex_4
import com.elkite.warborn.resources.ParagonPortrait_Dex_5
import com.elkite.warborn.resources.ParagonPortrait_Dex_6
import com.elkite.warborn.resources.ParagonPortrait_Dex_7
import com.elkite.warborn.resources.ParagonPortrait_Dex_8
import com.elkite.warborn.resources.ParagonPortrait_Dex_9
import com.elkite.warborn.resources.ParagonPortrait_Int_1
import com.elkite.warborn.resources.ParagonPortrait_Int_10
import com.elkite.warborn.resources.ParagonPortrait_Int_11
import com.elkite.warborn.resources.ParagonPortrait_Int_13
import com.elkite.warborn.resources.ParagonPortrait_Int_2
import com.elkite.warborn.resources.ParagonPortrait_Int_3
import com.elkite.warborn.resources.ParagonPortrait_Int_4
import com.elkite.warborn.resources.ParagonPortrait_Int_6
import com.elkite.warborn.resources.ParagonPortrait_Int_7
import com.elkite.warborn.resources.ParagonPortrait_Int_9
import com.elkite.warborn.resources.ParagonPortrait_None
import com.elkite.warborn.resources.ParagonPortrait_Str_1
import com.elkite.warborn.resources.ParagonPortrait_Str_2
import com.elkite.warborn.resources.ParagonPortrait_Str_3
import com.elkite.warborn.resources.ParagonPortrait_Str_4
import com.elkite.warborn.resources.ParagonPortrait_Str_5
import com.elkite.warborn.resources.ParagonPortrait_Str_6
import com.elkite.warborn.resources.ParagonPortrait_Str_7
import com.elkite.warborn.resources.ParagonPortrait_Str_8
import com.elkite.warborn.resources.ParagonPortrait_Str_9
import com.elkite.warborn.resources.Paragon_Skill_Dex_1
import com.elkite.warborn.resources.Paragon_Skill_Dex_1_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_2
import com.elkite.warborn.resources.Paragon_Skill_Dex_2_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_3
import com.elkite.warborn.resources.Paragon_Skill_Dex_3_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_4
import com.elkite.warborn.resources.Paragon_Skill_Dex_4_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_5
import com.elkite.warborn.resources.Paragon_Skill_Dex_5_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_6
import com.elkite.warborn.resources.Paragon_Skill_Dex_6_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_7
import com.elkite.warborn.resources.Paragon_Skill_Dex_7_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_8
import com.elkite.warborn.resources.Paragon_Skill_Dex_8_Passive
import com.elkite.warborn.resources.Paragon_Skill_Dex_9
import com.elkite.warborn.resources.Paragon_Skill_Dex_9_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_1
import com.elkite.warborn.resources.Paragon_Skill_Int_10
import com.elkite.warborn.resources.Paragon_Skill_Int_10_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_11
import com.elkite.warborn.resources.Paragon_Skill_Int_11_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_13_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_13
import com.elkite.warborn.resources.Paragon_Skill_Int_1_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_2
import com.elkite.warborn.resources.Paragon_Skill_Int_2_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_3
import com.elkite.warborn.resources.Paragon_Skill_Int_3_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_4
import com.elkite.warborn.resources.Paragon_Skill_Int_4_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_6
import com.elkite.warborn.resources.Paragon_Skill_Int_6_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_7
import com.elkite.warborn.resources.Paragon_Skill_Int_7_Passive
import com.elkite.warborn.resources.Paragon_Skill_Int_9
import com.elkite.warborn.resources.Paragon_Skill_Int_9_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_1
import com.elkite.warborn.resources.Paragon_Skill_Str_1_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_2
import com.elkite.warborn.resources.Paragon_Skill_Str_2_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_3
import com.elkite.warborn.resources.Paragon_Skill_Str_3_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_4
import com.elkite.warborn.resources.Paragon_Skill_Str_4_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_5
import com.elkite.warborn.resources.Paragon_Skill_Str_5_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_6
import com.elkite.warborn.resources.Paragon_Skill_Str_6_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_7
import com.elkite.warborn.resources.Paragon_Skill_Str_7_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_8
import com.elkite.warborn.resources.Paragon_Skill_Str_8_Passive
import com.elkite.warborn.resources.Paragon_Skill_Str_9
import com.elkite.warborn.resources.Paragon_Skill_Str_9_Passive
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.Shoes_Dex_1
import com.elkite.warborn.resources.Shoes_Dex_2
import com.elkite.warborn.resources.Shoes_Dex_3
import com.elkite.warborn.resources.Shoes_Dex_4
import com.elkite.warborn.resources.Shoes_Dex_5
import com.elkite.warborn.resources.Shoes_Dex_7
import com.elkite.warborn.resources.Shoes_Dex_8
import com.elkite.warborn.resources.Shoes_Int_1
import com.elkite.warborn.resources.Shoes_Int_2
import com.elkite.warborn.resources.Shoes_Int_3
import com.elkite.warborn.resources.Shoes_Int_4
import com.elkite.warborn.resources.Shoes_Int_5
import com.elkite.warborn.resources.Shoes_Int_6
import com.elkite.warborn.resources.Shoes_Int_7
import com.elkite.warborn.resources.Shoes_Str_1
import com.elkite.warborn.resources.Shoes_Str_2
import com.elkite.warborn.resources.Shoes_Str_3
import com.elkite.warborn.resources.Shoes_Str_4
import com.elkite.warborn.resources.Shoes_Str_5
import com.elkite.warborn.resources.Shoes_Str_6
import com.elkite.warborn.resources.Shoes_Str_7
import com.elkite.warborn.resources.SpearAttack_2
import com.elkite.warborn.resources.SpearAttack_3
import com.elkite.warborn.resources.SpearAttack_4
import com.elkite.warborn.resources.Spear_Bright
import com.elkite.warborn.resources.Spear_Common_Skill_1
import com.elkite.warborn.resources.Spear_Common_Skill_2
import com.elkite.warborn.resources.Spear_Common_Skill_3
import com.elkite.warborn.resources.Spear_Common_Skill_4
import com.elkite.warborn.resources.Spear_Common_Skill_5
import com.elkite.warborn.resources.Spear_DragonBack
import com.elkite.warborn.resources.Spear_Fling
import com.elkite.warborn.resources.Spear_Passive
import com.elkite.warborn.resources.Spear_SpearDance
import com.elkite.warborn.resources.Spear_SpiritHunter
import com.elkite.warborn.resources.Spear_Sweep
import com.elkite.warborn.resources.Spear_Trinity
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
import com.elkite.warborn.resources.TwinDagger_BladeWind
import com.elkite.warborn.resources.TwinDagger_HungerBlood
import com.elkite.warborn.resources.WeaponEpic1
import com.elkite.warborn.resources.WeaponEpic2
import com.elkite.warborn.resources.WeaponEpic3
import com.elkite.warborn.resources.WeaponEpic4
import com.elkite.warborn.resources.WeaponEpic5
import com.elkite.warborn.resources.WeaponEpic6
import com.elkite.warborn.resources.WeaponEpic7
import com.elkite.warborn.resources.WeaponEpic8
import com.elkite.warborn.resources.WeaponEpic9
import com.elkite.warborn.resources.WeaponExclusiveLgdr1
import com.elkite.warborn.resources.WeaponExclusiveLgdr10
import com.elkite.warborn.resources.WeaponExclusiveLgdr11
import com.elkite.warborn.resources.WeaponExclusiveLgdr12
import com.elkite.warborn.resources.WeaponExclusiveLgdr2
import com.elkite.warborn.resources.WeaponExclusiveLgdr3
import com.elkite.warborn.resources.WeaponExclusiveLgdr4
import com.elkite.warborn.resources.WeaponExclusiveLgdr5
import com.elkite.warborn.resources.WeaponExclusiveLgdr6
import com.elkite.warborn.resources.WeaponExclusiveLgdr7
import com.elkite.warborn.resources.WeaponExclusiveLgdr8
import com.elkite.warborn.resources.WeaponExclusiveLgdr9
import com.elkite.warborn.resources.WeaponLgdr1
import com.elkite.warborn.resources.WeaponLgdr2
import com.elkite.warborn.resources.WeaponLgdr3
import com.elkite.warborn.resources.WeaponRare1
import com.elkite.warborn.resources.WeaponRare2
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource


object IconMap {

    fun getDrifterIcon(gameId: String?): DrawableResource {
        return when (gameId) {
            "paragon_str_1" -> Res.drawable.ParagonPortrait_Str_1
            "paragon_str_2" -> Res.drawable.ParagonPortrait_Str_2
            "paragon_str_3" -> Res.drawable.ParagonPortrait_Str_3
            "paragon_str_4" -> Res.drawable.ParagonPortrait_Str_4
            "paragon_str_5" -> Res.drawable.ParagonPortrait_Str_5
            "paragon_str_6" -> Res.drawable.ParagonPortrait_Str_6
            "paragon_str_7" -> Res.drawable.ParagonPortrait_Str_7
            "paragon_str_8" -> Res.drawable.ParagonPortrait_Str_8
            "paragon_str_9" -> Res.drawable.ParagonPortrait_Str_9
            "paragon_int_1" -> Res.drawable.ParagonPortrait_Int_1
            "paragon_int_2" -> Res.drawable.ParagonPortrait_Int_2
            "paragon_int_3" -> Res.drawable.ParagonPortrait_Int_3
            "paragon_int_4" -> Res.drawable.ParagonPortrait_Int_4
            "paragon_int_9" -> Res.drawable.ParagonPortrait_Int_9
            "paragon_int_6" -> Res.drawable.ParagonPortrait_Int_6
            "paragon_int_7" -> Res.drawable.ParagonPortrait_Int_7
            "paragon_int_11" -> Res.drawable.ParagonPortrait_Int_11
            "paragon_int_10" -> Res.drawable.ParagonPortrait_Int_10
            "paragon_int_13" -> Res.drawable.ParagonPortrait_Int_13
            "paragon_dex_1" -> Res.drawable.ParagonPortrait_Dex_1
            "paragon_dex_2" -> Res.drawable.ParagonPortrait_Dex_2
            "paragon_dex_3" -> Res.drawable.ParagonPortrait_Dex_3
            "paragon_dex_4" -> Res.drawable.ParagonPortrait_Dex_4
            "paragon_dex_5" -> Res.drawable.ParagonPortrait_Dex_5
            "paragon_dex_6" -> Res.drawable.ParagonPortrait_Dex_6
            "paragon_dex_7" -> Res.drawable.ParagonPortrait_Dex_7
            "paragon_dex_8" -> Res.drawable.ParagonPortrait_Dex_8
            "paragon_dex_9" -> Res.drawable.ParagonPortrait_Dex_9
            null -> Res.drawable.ParagonPortrait_None
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterFullBodyBg(drifter: Drifter?): DrawableResource {
        return when (drifter?.gameId) {
            "paragon_str_1" -> Res.drawable.ParagonFullBodyBg_Str_1
            "paragon_str_2" -> Res.drawable.ParagonFullBodyBg_Str_2
            "paragon_str_3" -> Res.drawable.ParagonFullBodyBg_Str_3
            "paragon_str_4" -> Res.drawable.ParagonFullBodyBg_Str_4
            "paragon_str_5" -> Res.drawable.ParagonFullBodyBg_Str_5
            "paragon_str_6" -> Res.drawable.ParagonFullBodyBg_Str_6
            "paragon_str_7" -> Res.drawable.ParagonFullBodyBg_Str_7
            "paragon_str_8" -> Res.drawable.ParagonFullBodyBg_Str_8
            "paragon_str_9" -> Res.drawable.ParagonFullBodyBg_Str_9
            "paragon_int_1" -> Res.drawable.ParagonFullBodyBg_Int_1
            "paragon_int_2" -> Res.drawable.ParagonFullBodyBg_Int_2
            "paragon_int_3" -> Res.drawable.ParagonFullBodyBg_Int_3
            "paragon_int_4" -> Res.drawable.ParagonFullBodyBg_Int_4
            "paragon_int_10" -> Res.drawable.ParagonFullBodyBg_Int_10
            "paragon_int_13" -> Res.drawable.ParagonFullBodyBg_Int_13
            "paragon_int_6" -> Res.drawable.ParagonFullBodyBg_Int_6
            "paragon_int_7" -> Res.drawable.ParagonFullBodyBg_Int_7
            "paragon_int_11" -> Res.drawable.ParagonFullBodyBg_Int_11
            "paragon_int_9" -> Res.drawable.ParagonFullBodyBg_Int_9
            "paragon_dex_1" -> Res.drawable.ParagonFullBodyBg_Dex_1
            "paragon_dex_2" -> Res.drawable.ParagonFullBodyBg_Dex_2
            "paragon_dex_3" -> Res.drawable.ParagonFullBodyBg_Dex_3
            "paragon_dex_4" -> Res.drawable.ParagonFullBodyBg_Dex_4
            "paragon_dex_5" -> Res.drawable.ParagonFullBodyBg_Dex_5
            "paragon_dex_6" -> Res.drawable.ParagonFullBodyBg_Dex_6
            "paragon_dex_7" -> Res.drawable.ParagonFullBodyBg_Dex_7
            "paragon_dex_8" -> Res.drawable.ParagonFullBodyBg_Dex_8
            "paragon_dex_9" -> Res.drawable.ParagonFullBodyBg_Dex_9
            null -> Res.drawable.ParagonFullBodyBg_None
            else -> Res.drawable.error_emoji
        }
    }


    fun getDrifterFullBody(drifter: Drifter?): DrawableResource {
        return when (drifter?.gameId) {
            "paragon_str_1" -> Res.drawable.ParagonFullBody_Str_1
            "paragon_str_2" -> Res.drawable.ParagonFullBody_Str_2
            "paragon_str_3" -> Res.drawable.ParagonFullBody_Str_3
            "paragon_str_4" -> Res.drawable.ParagonFullBody_Str_4
            "paragon_str_5" -> Res.drawable.ParagonFullBody_Str_5
            "paragon_str_6" -> Res.drawable.ParagonFullBody_Str_6
            "paragon_str_7" -> Res.drawable.ParagonFullBody_Str_7
            "paragon_str_8" -> Res.drawable.ParagonFullBody_Str_8
            "paragon_str_9" -> Res.drawable.ParagonFullBody_Str_9
            "paragon_int_1" -> Res.drawable.ParagonFullBody_Int_1
            "paragon_int_2" -> Res.drawable.ParagonFullBody_Int_2
            "paragon_int_3" -> Res.drawable.ParagonFullBody_Int_3
            "paragon_int_4" -> Res.drawable.ParagonFullBody_Int_4
            "paragon_int_10" -> Res.drawable.ParagonFullBody_Int_10
            "paragon_int_13" -> Res.drawable.ParagonFullBody_Int_13
            "paragon_int_6" -> Res.drawable.ParagonFullBody_Int_6
            "paragon_int_7" -> Res.drawable.ParagonFullBody_Int_7
            "paragon_int_11" -> Res.drawable.ParagonFullBody_Int_11
            "paragon_int_9" -> Res.drawable.ParagonFullBody_Int_9
            "paragon_dex_1" -> Res.drawable.ParagonFullBody_Dex_1
            "paragon_dex_2" -> Res.drawable.ParagonFullBody_Dex_2
            "paragon_dex_3" -> Res.drawable.ParagonFullBody_Dex_3
            "paragon_dex_4" -> Res.drawable.ParagonFullBody_Dex_4
            "paragon_dex_5" -> Res.drawable.ParagonFullBody_Dex_5
            "paragon_dex_6" -> Res.drawable.ParagonFullBody_Dex_6
            "paragon_dex_7" -> Res.drawable.ParagonFullBody_Dex_7
            "paragon_dex_8" -> Res.drawable.ParagonFullBody_Dex_8
            "paragon_dex_9" -> Res.drawable.ParagonFullBody_Dex_9
            null -> Res.drawable.ParagonFullBody_None
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterCard(drifter: Drifter?): DrawableResource {
        return when (drifter?.gameId) {
            "paragon_str_1" -> Res.drawable.ParagonCard_Str_1
            "paragon_str_2" -> Res.drawable.ParagonCard_Str_2
            "paragon_str_3" -> Res.drawable.ParagonCard_Str_3
            "paragon_str_4" -> Res.drawable.ParagonCard_Str_4
            "paragon_str_5" -> Res.drawable.ParagonCard_Str_5
            "paragon_str_6" -> Res.drawable.ParagonCard_Str_6
            "paragon_str_7" -> Res.drawable.ParagonCard_Str_7
            "paragon_str_8" -> Res.drawable.ParagonCard_Str_8
            "paragon_str_9" -> Res.drawable.ParagonCard_Str_9
            "paragon_int_1" -> Res.drawable.ParagonCard_Int_1
            "paragon_int_2" -> Res.drawable.ParagonCard_Int_2
            "paragon_int_3" -> Res.drawable.ParagonCard_Int_3
            "paragon_int_4" -> Res.drawable.ParagonCard_Int_4
            "paragon_int_10" -> Res.drawable.ParagonCard_Int_10
            "paragon_int_6" -> Res.drawable.ParagonCard_Int_6
            "paragon_int_7" -> Res.drawable.ParagonCard_Int_7
            "paragon_int_11" -> Res.drawable.ParagonCard_Int_11
            "paragon_int_13" -> Res.drawable.ParagonCard_Int_13
            "paragon_int_9" -> Res.drawable.ParagonCard_Int_9
            "paragon_dex_1" -> Res.drawable.ParagonCard_Dex_1
            "paragon_dex_2" -> Res.drawable.ParagonCard_Dex_2
            "paragon_dex_3" -> Res.drawable.ParagonCard_Dex_3
            "paragon_dex_4" -> Res.drawable.ParagonCard_Dex_4
            "paragon_dex_5" -> Res.drawable.ParagonCard_Dex_5
            "paragon_dex_6" -> Res.drawable.ParagonCard_Dex_6
            "paragon_dex_7" -> Res.drawable.ParagonCard_Dex_7
            "paragon_dex_8" -> Res.drawable.ParagonCard_Dex_8
            "paragon_dex_9" -> Res.drawable.ParagonCard_Dex_9
            null -> Res.drawable.ParagonCard_Nonepng
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterSpell(drifterId: String): DrawableResource {
        return when (drifterId) {
            "Paragon_Skill_Str_1" -> Res.drawable.Paragon_Skill_Str_1
            "Paragon_Skill_Str_2" -> Res.drawable.Paragon_Skill_Str_2
            "Paragon_Skill_Str_3" -> Res.drawable.Paragon_Skill_Str_3
            "Paragon_Skill_Str_4" -> Res.drawable.Paragon_Skill_Str_4
            "Paragon_Skill_Str_5" -> Res.drawable.Paragon_Skill_Str_5
            "Paragon_Skill_Str_6" -> Res.drawable.Paragon_Skill_Str_6
            "Paragon_Skill_Str_7" -> Res.drawable.Paragon_Skill_Str_7
            "Paragon_Skill_Str_8" -> Res.drawable.Paragon_Skill_Str_8
            "Paragon_Skill_Str_9" -> Res.drawable.Paragon_Skill_Str_9
            "Paragon_Skill_Dex_1" -> Res.drawable.Paragon_Skill_Dex_1
            "Paragon_Skill_Dex_2" -> Res.drawable.Paragon_Skill_Dex_2
            "Paragon_Skill_Dex_3" -> Res.drawable.Paragon_Skill_Dex_3
            "Paragon_Skill_Dex_4" -> Res.drawable.Paragon_Skill_Dex_4
            "Paragon_Skill_Dex_5" -> Res.drawable.Paragon_Skill_Dex_5
            "Paragon_Skill_Dex_6" -> Res.drawable.Paragon_Skill_Dex_6
            "Paragon_Skill_Dex_7" -> Res.drawable.Paragon_Skill_Dex_7
            "Paragon_Skill_Dex_8" -> Res.drawable.Paragon_Skill_Dex_8
            "Paragon_Skill_Dex_9" -> Res.drawable.Paragon_Skill_Dex_9
            "Paragon_Skill_Int_1" -> Res.drawable.Paragon_Skill_Int_1
            "Paragon_Skill_Int_2" -> Res.drawable.Paragon_Skill_Int_2
            "Paragon_Skill_Int_3" -> Res.drawable.Paragon_Skill_Int_3
            "Paragon_Skill_Int_4" -> Res.drawable.Paragon_Skill_Int_4
            "Paragon_Skill_Int_10" -> Res.drawable.Paragon_Skill_Int_10
            "Paragon_Skill_Int_13" -> Res.drawable.Paragon_Skill_Int_13
            "Paragon_Skill_Int_6" -> Res.drawable.Paragon_Skill_Int_6
            "Paragon_Skill_Int_7" -> Res.drawable.Paragon_Skill_Int_7
            "Paragon_Skill_Int_11" -> Res.drawable.Paragon_Skill_Int_11
            "Paragon_Skill_Int_9" -> Res.drawable.Paragon_Skill_Int_9
            else -> Res.drawable.error_emoji
        }
    }

    fun getDrifterPassive(drifterId: String): DrawableResource {
        return when (drifterId) {
            "Paragon_Skill_Str_1_Passive" -> Res.drawable.Paragon_Skill_Str_1_Passive
            "Paragon_Skill_Str_2_Passive" -> Res.drawable.Paragon_Skill_Str_2_Passive
            "Paragon_Skill_Str_3_Passive" -> Res.drawable.Paragon_Skill_Str_3_Passive
            "Paragon_Skill_Str_4_Passive" -> Res.drawable.Paragon_Skill_Str_4_Passive
            "Paragon_Skill_Str_5_Passive" -> Res.drawable.Paragon_Skill_Str_5_Passive
            "Paragon_Skill_Str_6_Passive" -> Res.drawable.Paragon_Skill_Str_6_Passive
            "Paragon_Skill_Str_7_Passive" -> Res.drawable.Paragon_Skill_Str_7_Passive
            "Paragon_Skill_Str_8_Passive" -> Res.drawable.Paragon_Skill_Str_8_Passive
            "Paragon_Skill_Str_9_Passive" -> Res.drawable.Paragon_Skill_Str_9_Passive
            "Paragon_Skill_Dex_1_Passive" -> Res.drawable.Paragon_Skill_Dex_1_Passive
            "Paragon_Skill_Dex_2_Passive" -> Res.drawable.Paragon_Skill_Dex_2_Passive
            "Paragon_Skill_Dex_3_Passive" -> Res.drawable.Paragon_Skill_Dex_3_Passive
            "Paragon_Skill_Dex_4_Passive" -> Res.drawable.Paragon_Skill_Dex_4_Passive
            "Paragon_Skill_Dex_5_Passive" -> Res.drawable.Paragon_Skill_Dex_5_Passive
            "Paragon_Skill_Dex_6_Passive" -> Res.drawable.Paragon_Skill_Dex_6_Passive
            "Paragon_Skill_Dex_7_Passive" -> Res.drawable.Paragon_Skill_Dex_7_Passive
            "Paragon_Skill_Dex_8_Passive" -> Res.drawable.Paragon_Skill_Dex_8_Passive
            "Paragon_Skill_Dex_9_Passive" -> Res.drawable.Paragon_Skill_Dex_9_Passive
            "Paragon_Skill_Int_1_Passive" -> Res.drawable.Paragon_Skill_Int_1_Passive
            "Paragon_Skill_Int_2_Passive" -> Res.drawable.Paragon_Skill_Int_2_Passive
            "Paragon_Skill_Int_3_Passive" -> Res.drawable.Paragon_Skill_Int_3_Passive
            "Paragon_Skill_Int_4_Passive" -> Res.drawable.Paragon_Skill_Int_4_Passive
            "Paragon_Skill_Int_10_Passive" -> Res.drawable.Paragon_Skill_Int_10_Passive
            "Paragon_Skill_Int_13_Passive" -> Res.drawable.Paragon_Skill_Int_13_Passive
            "Paragon_Skill_Int_6_Passive" -> Res.drawable.Paragon_Skill_Int_6_Passive
            "Paragon_Skill_Int_7_Passive" -> Res.drawable.Paragon_Skill_Int_7_Passive
            "Paragon_Skill_Int_11_Passive" -> Res.drawable.Paragon_Skill_Int_11_Passive
            "Paragon_Skill_Int_9_Passive" -> Res.drawable.Paragon_Skill_Int_9_Passive
            else -> Res.drawable.error_emoji
        }
    }

    fun getSkillIcon(gearType: GearType, id: String): DrawableResource {
        return when (gearType) {
            GearType.HEAD -> getSkillHeadIcon(id)
            GearType.CHEST -> getSkillChestIcon(id)
            GearType.BOOTS -> getSkillBootsIcon(id)
            GearType.SWORD -> getSkillSwordIcon(id)
            GearType.GUN -> getSkillGunIcon(id)
            GearType.AXE -> getSkillAxeIcon(id)
            GearType.MACE -> getSkillMaceIcon(id)
            GearType.BOW -> getSkillBowIcon(id)
            GearType.NATURE -> getSkillNatureIcon(id)
            GearType.DAGGER -> getSkillDaggerIcon(id)
            GearType.SPEAR -> getSkillSpearIcon(id)
            GearType.FIRE -> getSkillFireIcon(id)
            GearType.FROST -> getSkillFrostIcon(id)
            GearType.CURSE -> getSkillCurseIcon(id)
            GearType.HOLY -> getSkillHolyIcon(id)
            else -> Res.drawable.error_emoji
        }
    }

    fun getWeaponIcon(gearType: GearType): DrawableResource {
        return when (gearType) {
            GearType.SWORD -> Res.drawable.Com_Weapon_Sword
            GearType.GUN -> Res.drawable.Com_Weapon_Gun
            GearType.AXE -> Res.drawable.Com_Weapon_Axe
            GearType.MACE -> Res.drawable.Com_Weapon_Mace
            GearType.BOW -> Res.drawable.Com_Weapon_Bow
            GearType.NATURE -> Res.drawable.Com_Weapon_Nature
            GearType.DAGGER -> Res.drawable.Com_Weapon_Dagger
            GearType.SPEAR -> Res.drawable.Com_Weapon_Frost
            GearType.FIRE -> Res.drawable.Com_Weapon_Fire
            GearType.FROST -> Res.drawable.Com_Weapon_Spear
            GearType.CURSE -> Res.drawable.Com_Weapon_Curse
            GearType.HOLY -> Res.drawable.Com_Weapon_Staff
            else -> Res.drawable.error_emoji
        }
    }

    fun getArmorIcon(gearType: GearType, id: String): DrawableResource {
        return when (gearType) {
            GearType.HEAD -> getArmorHeadIcon(id)
            GearType.CHEST -> getArmorChestIcon(id)
            GearType.BOOTS -> getArmorBootsIcon(id)
            GearType.SWORD -> getArmorSwordIcon(id)
            GearType.GUN -> getArmorGunIcon(id)
            GearType.AXE -> getArmorAxeIcon(id)
            GearType.MACE -> getArmorMaceIcon(id)
            GearType.BOW -> getArmorBowIcon(id)
            GearType.NATURE -> getArmorNatureIcon(id)
            GearType.DAGGER -> getArmorDaggerIcon(id)
            GearType.SPEAR -> getArmorSpearIcon(id)
            GearType.FIRE -> getArmorFireIcon(id)
            GearType.FROST -> getArmorFrostIcon(id)
            GearType.CURSE -> getArmorCurseIcon(id)
            GearType.HOLY -> getArmorHolyIcon(id)
            else -> Res.drawable.error_emoji
        }
    }

    fun getModIcon(modId: String?) : DrawableResource {
        return when(modId) {
            "ArmorRare1" -> Res.drawable.ArmorRare1
            "ArmorRare2" -> Res.drawable.ArmorRare2
            "ArmorRare3" -> Res.drawable.ArmorRare3
            "ArmorRare4" -> Res.drawable.ArmorRare4
            "WeaponRare1" -> Res.drawable.WeaponRare1
            "WeaponRare2" -> Res.drawable.WeaponRare2
            "ArmorEpic1" -> Res.drawable.ArmorEpic1
            "ArmorEpic2" -> Res.drawable.ArmorEpic2
            "ArmorEpic3" -> Res.drawable.ArmorEpic3
            "ArmorEpic4" -> Res.drawable.ArmorEpic4
            "ArmorEpic5" -> Res.drawable.ArmorEpic5
            "ArmorEpic6" -> Res.drawable.ArmorEpic6
            "ArmorEpic7" -> Res.drawable.ArmorEpic7
            "ArmorEpic8" -> Res.drawable.ArmorEpic8
            "ArmorEpic9" -> Res.drawable.ArmorEpic9
            "ArmorLgdr1" -> Res.drawable.ArmorLgdr1
            "ArmorLgdr2" -> Res.drawable.ArmorLgdr2
            "ArmorLgdr3" -> Res.drawable.ArmorLgdr3
            "ArmorExclusiveLgdr1" -> Res.drawable.ArmorExclusiveLgdr1
            "ArmorExclusiveLgdr2" -> Res.drawable.ArmorExclusiveLgdr2
            "ArmorExclusiveLgdr3" -> Res.drawable.ArmorExclusiveLgdr3
            "ArmorExclusiveLgdr4" -> Res.drawable.ArmorExclusiveLgdr4
            "ArmorExclusiveLgdr5" -> Res.drawable.ArmorExclusiveLgdr5
            "ArmorExclusiveLgdr6" -> Res.drawable.ArmorExclusiveLgdr6
            "WeaponEpic1" -> Res.drawable.WeaponEpic1
            "WeaponEpic2" -> Res.drawable.WeaponEpic2
            "WeaponEpic3" -> Res.drawable.WeaponEpic3
            "WeaponEpic4" -> Res.drawable.WeaponEpic4
            "WeaponEpic5" -> Res.drawable.WeaponEpic5
            "WeaponEpic6" -> Res.drawable.WeaponEpic6
            "WeaponEpic7" -> Res.drawable.WeaponEpic7
            "WeaponEpic8" -> Res.drawable.WeaponEpic8
            "WeaponEpic9" -> Res.drawable.WeaponEpic9
            "WeaponExclusiveLgdr1" -> Res.drawable.WeaponExclusiveLgdr1
            "WeaponExclusiveLgdr2" -> Res.drawable.WeaponExclusiveLgdr2
            "WeaponExclusiveLgdr3" -> Res.drawable.WeaponExclusiveLgdr3
            "WeaponExclusiveLgdr4" -> Res.drawable.WeaponExclusiveLgdr4
            "WeaponExclusiveLgdr5" -> Res.drawable.WeaponExclusiveLgdr5
            "WeaponExclusiveLgdr6" -> Res.drawable.WeaponExclusiveLgdr6
            "WeaponExclusiveLgdr7" -> Res.drawable.WeaponExclusiveLgdr7
            "WeaponExclusiveLgdr8" -> Res.drawable.WeaponExclusiveLgdr8
            "WeaponExclusiveLgdr9" -> Res.drawable.WeaponExclusiveLgdr9
            "WeaponExclusiveLgdr10" -> Res.drawable.WeaponExclusiveLgdr10
            "WeaponExclusiveLgdr11" -> Res.drawable.WeaponExclusiveLgdr11
            "WeaponExclusiveLgdr12" -> Res.drawable.WeaponExclusiveLgdr12
            "WeaponLgdr1" -> Res.drawable.WeaponLgdr1
            "WeaponLgdr2" -> Res.drawable.WeaponLgdr2
            "WeaponLgdr3" -> Res.drawable.WeaponLgdr3
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorHeadIcon(id: String): DrawableResource {
        return when (id) {
            "Furor's Helm" -> Res.drawable.EnhancementItem_HELMET3
            "Ironclad Helm" -> Res.drawable.EnhancementItem_HELMET6
            "Hellfire Visor" -> Res.drawable.EnhancementItem_HELMET2
            "Reptilian Helm" -> Res.drawable.EnhancementItem_HELMET4
            "Savage Helm" -> Res.drawable.EnhancementItem_HELMET1
            "Stormveil Mask" -> Res.drawable.EnhancementItem_HELMET5
            "Warden's Gaze" -> Res.drawable.EnhancementItem_HELMET7

            "Vital Mantle" -> Res.drawable.EnhancementItem_HOOD2
            "Stormcaller's Hood" -> Res.drawable.EnhancementItem_HOOD1
            "Shadeveil Mask" -> Res.drawable.EnhancementItem_HOOD5
            "Wrathveil Shade" -> Res.drawable.EnhancementItem_HOOD6
            "Purifier's Shroud" -> Res.drawable.EnhancementItem_HOOD7
            "Ironwill veil" -> Res.drawable.EnhancementItem_HOOD3
            "Folly Helm" -> Res.drawable.EnhancementItem_HOOD4

            "Breezeweaver" -> Res.drawable.EnhancementItem_COWL1
            "Healer's Hood" -> Res.drawable.EnhancementItem_COWL3
            "Mystic Surge" -> Res.drawable.EnhancementItem_COWL2
            "Earth Vein Hood" -> Res.drawable.EnhancementItem_COWL5
            "Crimson Breeze" -> Res.drawable.EnhancementItem_COWL6
            "Twilight Mantle" -> Res.drawable.EnhancementItem_COWL7
            "Sanctum Shroud" -> Res.drawable.EnhancementItem_COWL4
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorChestIcon(id: String): DrawableResource {
        return when (id) {
            "Guardian's Blessing" -> Res.drawable.EnhancementItem_ARMOR4
            "Aegis Plate" -> Res.drawable.EnhancementItem_ARMOR1
            "Dazzling Guard" -> Res.drawable.EnhancementItem_ARMOR2
            "Tempest Charge" -> Res.drawable.EnhancementItem_ARMOR6
            "Tangle Guard" -> Res.drawable.EnhancementItem_ARMOR7
            "Warden's Shell" -> Res.drawable.EnhancementItem_ARMOR3
            "Magsurge Armor" -> Res.drawable.EnhancementItem_ARMOR5

            "Cleansing Robe" -> Res.drawable.EnhancementItem_ROBE1
            "Repulsor Mantle" -> Res.drawable.EnhancementItem_ROBE2
            "Vigorcloak" -> Res.drawable.EnhancementItem_ROBE3
            "Archaneweaver" -> Res.drawable.EnhancementItem_ROBE4
            "Dreadcloak" -> Res.drawable.EnhancementItem_ROBE5
            "Exorcist's Robe" -> Res.drawable.EnhancementItem_ROBE6
            "Warding Shroud" -> Res.drawable.EnhancementItem_ROBE7

            "Ranger's Hide" -> Res.drawable.EnhancementItem_JACKET1
            "Beastcaller's Coat" -> Res.drawable.EnhancementItem_JACKET2
            "Deathmantle" -> Res.drawable.EnhancementItem_JACKET3
            "Retaliation Coat" -> Res.drawable.EnhancementItem_JACKET4
            "Hero's Embrace" -> Res.drawable.EnhancementItem_JACKET5
            "Recovery Vest" -> Res.drawable.EnhancementItem_JACKET6
            "Mistshroud" -> Res.drawable.EnhancementItem_JACKET7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorBootsIcon(id: String): DrawableResource {
        return when (id) {
            "Energizer Boots" -> Res.drawable.EnhancementItem_BOOTS4
            "Wrathstep" -> Res.drawable.EnhancementItem_BOOTS5
            "Bulwark Striders" -> Res.drawable.EnhancementItem_BOOTS1
            "Titan Walkers" -> Res.drawable.EnhancementItem_BOOTS2
            "Vanguard's March" -> Res.drawable.EnhancementItem_BOOTS6
            "Impact Heavy Boots" -> Res.drawable.EnhancementItem_BOOTS3
            "Avalanche Boots" -> Res.drawable.EnhancementItem_BOOTS7

            "Blinkstep Boots" -> Res.drawable.EnhancementItem_SANDALS1
            "Arcaneflow Boots" -> Res.drawable.EnhancementItem_SANDALS2
            "Savagefoot Boots" -> Res.drawable.EnhancementItem_SANDALS3
            "Frostwalker Boots" -> Res.drawable.EnhancementItem_SANDALS4
            "Miasma Stompers" -> Res.drawable.EnhancementItem_SANDALS5
            "Shifter's Strides" -> Res.drawable.EnhancementItem_SANDALS6
            "Phantomstep Boots" -> Res.drawable.EnhancementItem_SANDALS7

            "Fleeting Steps" -> Res.drawable.EnhancementItem_SHOES1
            "Swiftstride Boots" -> Res.drawable.EnhancementItem_SHOES2
            "Deathwalker Boots" -> Res.drawable.EnhancementItem_SHOES3
            "Evasion Striders" -> Res.drawable.EnhancementItem_SHOES4
            "Rallystep Boots" -> Res.drawable.EnhancementItem_SHOES5
            "Shadeveil Slippers" -> Res.drawable.EnhancementItem_SHOES6
            "Exodrift Slippers" -> Res.drawable.EnhancementItem_SHOES7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorSwordIcon(id: String): DrawableResource {
        return when (id) {
            "Storm Cleaver" -> Res.drawable.EnhancementItem_SWORD4
            "Hellcore Cleaver" -> Res.drawable.EnhancementItem_SWORD1
            "Voidblade" -> Res.drawable.EnhancementItem_SWORD3
            "Lordbreaker" -> Res.drawable.EnhancementItem_SWORD5
            "Titan's Spineblade" -> Res.drawable.EnhancementItem_SWORD6
            "Judicator" -> Res.drawable.EnhancementItem_SWORD2
            "Sovereign's Radiance" -> Res.drawable.EnhancementItem_SWORD7
            else -> Res.drawable.error_emoji
        }
    }


    private fun getArmorHolyIcon(id: String): DrawableResource {
        return when (id) {
            "Guardian's Embrace" -> Res.drawable.EnhancementItem_STAFF1
            "Celestial Redeemer" -> Res.drawable.EnhancementItem_STAFF2
            "Luminous Ward" -> Res.drawable.EnhancementItem_STAFF3
            "Judgement's Staff" -> Res.drawable.EnhancementItem_STAFF4
            "Divine Resonator" -> Res.drawable.EnhancementItem_STAFF5
            "Radiant Nova" -> Res.drawable.EnhancementItem_STAFF6
            "Sol Protector" -> Res.drawable.EnhancementItem_STAFF7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorCurseIcon(id: String): DrawableResource {
        return when (id) {
            "Rotten Breath" -> Res.drawable.EnhancementItem_CURSE1
            "Hexlock" -> Res.drawable.EnhancementItem_CURSE2
            "Plaguespread" -> Res.drawable.EnhancementItem_CURSE3
            "Infestor's Staff" -> Res.drawable.EnhancementItem_CURSE4
            "Necromist" -> Res.drawable.EnhancementItem_CURSE5
            "Nihilstaff" -> Res.drawable.EnhancementItem_CURSE6
            "Withermaul" -> Res.drawable.EnhancementItem_CURSE7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorFrostIcon(id: String): DrawableResource {
        return when (id) {
            "Glacier Prism" -> Res.drawable.EnhancementItem_FROST1
            "Frost Matrix" -> Res.drawable.EnhancementItem_FROST2
            "Glacier Spark" -> Res.drawable.EnhancementItem_FROST3
            "Cryoshard Mask" -> Res.drawable.EnhancementItem_FROST4
            "Iceshard Comet" -> Res.drawable.EnhancementItem_FROST5
            "Frozen Conduit" -> Res.drawable.EnhancementItem_FROST6
            "Frost's Caller" -> Res.drawable.EnhancementItem_FROST7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorFireIcon(id: String): DrawableResource {
        return when (id) {
            "Flame Maw" -> Res.drawable.EnhancementItem_FIRE1
            "Blazing Catalyst" -> Res.drawable.EnhancementItem_FIRE2
            "Doomfire" -> Res.drawable.EnhancementItem_FIRE3
            "Inferno Core" -> Res.drawable.EnhancementItem_FIRE4
            "Solarflare" -> Res.drawable.EnhancementItem_FIRE5
            "Blazruptor" -> Res.drawable.EnhancementItem_FIRE6
            "Molten Mortar" -> Res.drawable.EnhancementItem_FIRE7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorSpearIcon(id: String): DrawableResource {
        return when (id) {
            "Sharspike" -> Res.drawable.EnhancementItem_SPEAR6
            "Sentinel's Lance" -> Res.drawable.EnhancementItem_SPEAR3
            "Stormfang Lance" -> Res.drawable.EnhancementItem_SPEAR1
            "Storm Spear" -> Res.drawable.EnhancementItem_SPEAR7
            "Drakespike" -> Res.drawable.EnhancementItem_SPEAR8
            "Corrosive Piercer" -> Res.drawable.EnhancementItem_SPEAR4
            "Phantom Spear" -> Res.drawable.EnhancementItem_SPEAR2
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorDaggerIcon(id: String): DrawableResource {
        return when (id) {
            "Hemoblades" -> Res.drawable.EnhancementItem_DAGGER7
            "Twilight Blades" -> Res.drawable.EnhancementItem_DAGGER1
            "Soulfangs" -> Res.drawable.EnhancementItem_DAGGER2
            "Bloodpiercers" -> Res.drawable.EnhancementItem_DAGGER5
            "Bloodfury Blades" -> Res.drawable.EnhancementItem_DAGGER4
            "Bloodthirst" -> Res.drawable.EnhancementItem_DAGGER6
            "Scarlet Hunger" -> Res.drawable.EnhancementItem_DAGGER3
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorNatureIcon(id: String): DrawableResource {
        return when (id) {
            "Eclipse Conduit" -> Res.drawable.EnhancementItem_NATURE1
            "Thornward Staff" -> Res.drawable.EnhancementItem_NATURE2
            "Harmony's Staff" -> Res.drawable.EnhancementItem_NATURE3
            "Verdant Embrace" -> Res.drawable.EnhancementItem_NATURE4
            "Tendril's Grasp" -> Res.drawable.EnhancementItem_NATURE6
            "Spirit's Call" -> Res.drawable.EnhancementItem_NATURE5
            "Sanctuary of Growth" -> Res.drawable.EnhancementItem_NATURE7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorGunIcon(id: String): DrawableResource {
        return when (id) {
            "Shattercoil" -> Res.drawable.EnhancementItem_GUN1
            "Sentinel Barrage" -> Res.drawable.EnhancementItem_GUN2
            "Spectral Assault" -> Res.drawable.EnhancementItem_GUN3
            "Blightspitter" -> Res.drawable.EnhancementItem_GUN4
            "Luminet Cannon" -> Res.drawable.EnhancementItem_GUN6
            "Voideye" -> Res.drawable.EnhancementItem_GUN5
            "Prism Cloak" -> Res.drawable.EnhancementItem_GUN7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorAxeIcon(id: String): DrawableResource {
        return when (id) {
            "Berserker's Fury" -> Res.drawable.EnhancementItem_AXE2
            "Emerald Edge" -> Res.drawable.EnhancementItem_AXE1
            "Ravager's Cleave" -> Res.drawable.EnhancementItem_AXE6
            "Bonefang Reaper" -> Res.drawable.EnhancementItem_AXE7
            "Cyclone Cleave" -> Res.drawable.EnhancementItem_AXE4
            "Wreckingsaw" -> Res.drawable.EnhancementItem_AXE5
            "Wingblade" -> Res.drawable.EnhancementItem_AXE3
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorMaceIcon(id: String): DrawableResource {
        return when (id) {
            "Breaker's Resolve" -> Res.drawable.EnhancementItem_MACE1
            "Gravity Hammer" -> Res.drawable.EnhancementItem_MACE2
            "Voidbreaker" -> Res.drawable.EnhancementItem_MACE3
            "Ripper's Grasp" -> Res.drawable.EnhancementItem_MACE4
            "Bulwark Core" -> Res.drawable.EnhancementItem_MACE6
            "Abyssal Conduit" -> Res.drawable.EnhancementItem_MACE5
            "Thunderlord's Wrath" -> Res.drawable.EnhancementItem_MACE7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorBowIcon(id: String): DrawableResource {
        return when (id) {
            "Hailfire" -> Res.drawable.EnhancementItem_BOW4
            "Kinetic Arc" -> Res.drawable.EnhancementItem_BOW1
            "Predator's Splitbow" -> Res.drawable.EnhancementItem_BOW2
            "Thunderstrike" -> Res.drawable.EnhancementItem_BOW5
            "Windbreaker" -> Res.drawable.EnhancementItem_BOW6
            "Mender's Ruin" -> Res.drawable.EnhancementItem_BOW3
            "Eclypse Bow" -> Res.drawable.EnhancementItem_BOW7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillHeadIcon(id: String): DrawableResource {
        return when (id) {
            "Helm_Str_8" -> Res.drawable.Helm_Str_8
            "Helm_Str_7" -> Res.drawable.Helm_Str_7
            "Helm_Str_6" -> Res.drawable.Helm_Str_6
            "Helm_Str_5" -> Res.drawable.Helm_Str_5
            "Helm_Str_4" -> Res.drawable.Helm_Str_4
            "Helm_Str_3" -> Res.drawable.Helm_Str_3
            "Helm_Str_1" -> Res.drawable.Helm_Str_1

            "Helm_Int_8" -> Res.drawable.Helm_Int_8
            "Helm_Int_7" -> Res.drawable.Helm_Int_7
            "Helm_Int_2" -> Res.drawable.Helm_Int_2
            "Helm_Int_5" -> Res.drawable.Helm_Int_5
            "Helm_Int_4" -> Res.drawable.Helm_Int_4
            "Helm_Int_3" -> Res.drawable.Helm_Int_3
            "Helm_Int_1" -> Res.drawable.Helm_Int_1

            "Helm_Dex_8" -> Res.drawable.Helm_Dex_8
            "Helm_Dex_7" -> Res.drawable.Helm_Dex_7
            "Helm_Dex_2" -> Res.drawable.Helm_Dex_2
            "Helm_Dex_5" -> Res.drawable.Helm_Dex_5
            "Helm_Dex_4" -> Res.drawable.Helm_Dex_4
            "Helm_Dex_3" -> Res.drawable.Helm_Dex_3
            "Helm_Dex_1" -> Res.drawable.Helm_Dex_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillChestIcon(id: String): DrawableResource {
        return when (id) {
            "Cloth_Str_8" -> Res.drawable.Cloth_Str_8
            "Cloth_Str_6" -> Res.drawable.Cloth_Str_6
            "Cloth_Str_5" -> Res.drawable.Cloth_Str_5
            "Cloth_Str_4" -> Res.drawable.Cloth_Str_4
            "Cloth_Str_3" -> Res.drawable.Cloth_Str_3
            "Cloth_Str_2" -> Res.drawable.Cloth_Str_2
            "Cloth_Str_1" -> Res.drawable.Cloth_Str_1

            "Cloth_Dex_7" -> Res.drawable.Cloth_Dex_7
            "Cloth_Dex_6" -> Res.drawable.Cloth_Dex_6
            "Cloth_Dex_5" -> Res.drawable.Cloth_Dex_5
            "Cloth_Dex_4" -> Res.drawable.Cloth_Dex_4
            "Cloth_Dex_3" -> Res.drawable.Cloth_Dex_3
            "Cloth_Dex_2" -> Res.drawable.Cloth_Dex_2
            "Cloth_Dex_1" -> Res.drawable.Cloth_Dex_1

            "Cloth_Int_7" -> Res.drawable.Cloth_Int_7
            "Cloth_Int_8" -> Res.drawable.Cloth_Int_8
            "Cloth_Int_5" -> Res.drawable.Cloth_Int_5
            "Cloth_Int_4" -> Res.drawable.Cloth_Int_2
            "Cloth_Int_3" -> Res.drawable.Cloth_Int_3
            "Cloth_Int_2" -> Res.drawable.Cloth_Int_2
            "Cloth_Int_1" -> Res.drawable.Cloth_Int_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillBootsIcon(id: String): DrawableResource {
        return when (id) {
            "Shoes_Str_7" -> Res.drawable.Shoes_Str_7
            "Shoes_Str_6" -> Res.drawable.Shoes_Str_6
            "Shoes_Str_5" -> Res.drawable.Shoes_Str_5
            "Shoes_Str_4" -> Res.drawable.Shoes_Str_4
            "Shoes_Str_3" -> Res.drawable.Shoes_Str_3
            "Shoes_Str_2" -> Res.drawable.Shoes_Str_2
            "Shoes_Str_1" -> Res.drawable.Shoes_Str_1

            "Shoes_Dex_7" -> Res.drawable.Shoes_Dex_7
            "Shoes_Dex_8" -> Res.drawable.Shoes_Dex_8
            "Shoes_Dex_5" -> Res.drawable.Shoes_Dex_5
            "Shoes_Dex_4" -> Res.drawable.Shoes_Dex_4
            "Shoes_Dex_3" -> Res.drawable.Shoes_Dex_3
            "Shoes_Dex_2" -> Res.drawable.Shoes_Dex_2
            "Shoes_Dex_1" -> Res.drawable.Shoes_Dex_1

            "Shoes_Int_7" -> Res.drawable.Shoes_Int_7
            "Shoes_Int_6" -> Res.drawable.Shoes_Int_6
            "Shoes_Int_5" -> Res.drawable.Shoes_Int_5
            "Shoes_Int_4" -> Res.drawable.Shoes_Int_4
            "Shoes_Int_3" -> Res.drawable.Shoes_Int_3
            "Shoes_Int_2" -> Res.drawable.Shoes_Int_2
            "Shoes_Int_1" -> Res.drawable.Shoes_Int_1
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillSwordIcon(id: String): DrawableResource {
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

    private fun getSkillGunIcon(id: String): DrawableResource {
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
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillAxeIcon(id: String): DrawableResource {
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

    private fun getSkillBowIcon(id: String): DrawableResource {
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

    private fun getSkillMaceIcon(id: String): DrawableResource {
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
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillSpearIcon(id: String): DrawableResource {
        return when (id) {
            "SpearAttack_4" -> Res.drawable.SpearAttack_4
            "SpearAttack_2" -> Res.drawable.SpearAttack_2
            "SpearAttack_3" -> Res.drawable.SpearAttack_3
            "Spear_Common_Skill_1" -> Res.drawable.Spear_Common_Skill_1
            "Spear_Common_Skill_4" -> Res.drawable.Spear_Common_Skill_4
            "Spear_Common_Skill_3" -> Res.drawable.Spear_Common_Skill_3
            "Spear_Common_Skill_2" -> Res.drawable.Spear_Common_Skill_2
            "Spear_Common_Skill_5" -> Res.drawable.Spear_Common_Skill_5
            "Spear_SpearDance" -> Res.drawable.Spear_SpearDance
            "Spear_Passive" -> Res.drawable.Spear_Passive
            "Spear_Trinity" -> Res.drawable.Spear_Trinity
            "Spear_Fling" -> Res.drawable.Spear_Fling
            "Spear_Sweep" -> Res.drawable.Spear_Sweep
            "Spear_DragonBack" -> Res.drawable.Spear_DragonBack
            "Spear_SpiritHunter" -> Res.drawable.Spear_SpiritHunter
            "Spear_Bright" -> Res.drawable.Spear_Bright
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillDaggerIcon(id: String): DrawableResource {
        return when (id) {
            "DaggerAttack_2" -> Res.drawable.DaggerAttack_2
            "DaggerAttack_4" -> Res.drawable.DaggerAttack_4
            "DaggerAttack_3" -> Res.drawable.DaggerAttack_3
            "Dagger_Passive" -> Res.drawable.Dagger_Passive
            "Dagger_Common_Skill_1" -> Res.drawable.Dagger_Common_Skill_1
            "Dagger_Common_Skill_3" -> Res.drawable.Dagger_Common_Skill_3
            "Dagger_Common_Skill_2" -> Res.drawable.Dagger_Common_Skill_2
            "Dagger_Common_Skill_4" -> Res.drawable.Dagger_Common_Skill_4
            "Dagger_Common_Skill_5" -> Res.drawable.Dagger_Common_Skill_5
            "Dagger_LongDagger" -> Res.drawable.Dagger_LongDagger
            "Dagger_BloodDagger" -> Res.drawable.Dagger_BloodDagger
            "Dagger_DeathDagger" -> Res.drawable.Dagger_DeathDagger
            "Dagger_Dagger" -> Res.drawable.Dagger_Dagger
            "TwinDagger_BladeWind" -> Res.drawable.TwinDagger_BladeWind
            "TwinDagger_HungerBlood" -> Res.drawable.TwinDagger_HungerBlood
            "Dagger_FastDagger" -> Res.drawable.Dagger_FastDagger
            else -> Res.drawable.error_emoji
        }
    }

    private fun getSkillNatureIcon(id: String): DrawableResource {
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

    private fun getSkillFireIcon(id: String): DrawableResource {
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

    private fun getSkillFrostIcon(id: String): DrawableResource {
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

    private fun getSkillCurseIcon(id: String): DrawableResource {
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

    private fun getSkillHolyIcon(id: String): DrawableResource {
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
            else -> Res.drawable.error_emoji
        }
    }
}



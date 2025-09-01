package com.elkite.warborn.util

import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.SpecImage_ARMOR1
import com.elkite.warborn.resources.SpecImage_ARMOR2
import com.elkite.warborn.resources.SpecImage_ARMOR3
import com.elkite.warborn.resources.SpecImage_ARMOR4
import com.elkite.warborn.resources.SpecImage_ARMOR5
import com.elkite.warborn.resources.SpecImage_ARMOR6
import com.elkite.warborn.resources.SpecImage_ARMOR7
import com.elkite.warborn.resources.SpecImage_AXE1
import com.elkite.warborn.resources.SpecImage_AXE2
import com.elkite.warborn.resources.SpecImage_AXE3
import com.elkite.warborn.resources.SpecImage_AXE4
import com.elkite.warborn.resources.SpecImage_AXE5
import com.elkite.warborn.resources.SpecImage_AXE6
import com.elkite.warborn.resources.SpecImage_AXE7
import com.elkite.warborn.resources.SpecImage_BOOTS1
import com.elkite.warborn.resources.SpecImage_BOOTS2
import com.elkite.warborn.resources.SpecImage_BOOTS3
import com.elkite.warborn.resources.SpecImage_BOOTS4
import com.elkite.warborn.resources.SpecImage_BOOTS5
import com.elkite.warborn.resources.SpecImage_BOOTS6
import com.elkite.warborn.resources.SpecImage_BOOTS7
import com.elkite.warborn.resources.SpecImage_BOW1
import com.elkite.warborn.resources.SpecImage_BOW2
import com.elkite.warborn.resources.SpecImage_BOW3
import com.elkite.warborn.resources.SpecImage_BOW4
import com.elkite.warborn.resources.SpecImage_BOW5
import com.elkite.warborn.resources.SpecImage_BOW6
import com.elkite.warborn.resources.SpecImage_BOW7
import com.elkite.warborn.resources.SpecImage_COWL1
import com.elkite.warborn.resources.SpecImage_COWL2
import com.elkite.warborn.resources.SpecImage_COWL3
import com.elkite.warborn.resources.SpecImage_COWL4
import com.elkite.warborn.resources.SpecImage_COWL5
import com.elkite.warborn.resources.SpecImage_COWL6
import com.elkite.warborn.resources.SpecImage_COWL7
import com.elkite.warborn.resources.SpecImage_CURSE1
import com.elkite.warborn.resources.SpecImage_CURSE2
import com.elkite.warborn.resources.SpecImage_CURSE3
import com.elkite.warborn.resources.SpecImage_CURSE4
import com.elkite.warborn.resources.SpecImage_CURSE5
import com.elkite.warborn.resources.SpecImage_CURSE6
import com.elkite.warborn.resources.SpecImage_CURSE7
import com.elkite.warborn.resources.SpecImage_DAGGER1
import com.elkite.warborn.resources.SpecImage_DAGGER2
import com.elkite.warborn.resources.SpecImage_DAGGER3
import com.elkite.warborn.resources.SpecImage_DAGGER4
import com.elkite.warborn.resources.SpecImage_DAGGER5
import com.elkite.warborn.resources.SpecImage_DAGGER6
import com.elkite.warborn.resources.SpecImage_DAGGER7
import com.elkite.warborn.resources.SpecImage_FIRE1
import com.elkite.warborn.resources.SpecImage_FIRE2
import com.elkite.warborn.resources.SpecImage_FIRE3
import com.elkite.warborn.resources.SpecImage_FIRE4
import com.elkite.warborn.resources.SpecImage_FIRE5
import com.elkite.warborn.resources.SpecImage_FIRE6
import com.elkite.warborn.resources.SpecImage_FIRE7
import com.elkite.warborn.resources.SpecImage_FROST1
import com.elkite.warborn.resources.SpecImage_FROST2
import com.elkite.warborn.resources.SpecImage_FROST3
import com.elkite.warborn.resources.SpecImage_FROST4
import com.elkite.warborn.resources.SpecImage_FROST5
import com.elkite.warborn.resources.SpecImage_FROST6
import com.elkite.warborn.resources.SpecImage_FROST7
import com.elkite.warborn.resources.SpecImage_GUN1
import com.elkite.warborn.resources.SpecImage_GUN2
import com.elkite.warborn.resources.SpecImage_GUN3
import com.elkite.warborn.resources.SpecImage_GUN4
import com.elkite.warborn.resources.SpecImage_GUN5
import com.elkite.warborn.resources.SpecImage_GUN6
import com.elkite.warborn.resources.SpecImage_GUN7
import com.elkite.warborn.resources.SpecImage_HELMET1
import com.elkite.warborn.resources.SpecImage_HELMET2
import com.elkite.warborn.resources.SpecImage_HELMET3
import com.elkite.warborn.resources.SpecImage_HELMET4
import com.elkite.warborn.resources.SpecImage_HELMET5
import com.elkite.warborn.resources.SpecImage_HELMET6
import com.elkite.warborn.resources.SpecImage_HELMET7
import com.elkite.warborn.resources.SpecImage_HOOD1
import com.elkite.warborn.resources.SpecImage_HOOD2
import com.elkite.warborn.resources.SpecImage_HOOD3
import com.elkite.warborn.resources.SpecImage_HOOD4
import com.elkite.warborn.resources.SpecImage_HOOD5
import com.elkite.warborn.resources.SpecImage_HOOD6
import com.elkite.warborn.resources.SpecImage_HOOD7
import com.elkite.warborn.resources.SpecImage_JACKET1
import com.elkite.warborn.resources.SpecImage_JACKET2
import com.elkite.warborn.resources.SpecImage_JACKET3
import com.elkite.warborn.resources.SpecImage_JACKET4
import com.elkite.warborn.resources.SpecImage_JACKET5
import com.elkite.warborn.resources.SpecImage_JACKET6
import com.elkite.warborn.resources.SpecImage_JACKET7
import com.elkite.warborn.resources.SpecImage_MACE1
import com.elkite.warborn.resources.SpecImage_MACE2
import com.elkite.warborn.resources.SpecImage_MACE3
import com.elkite.warborn.resources.SpecImage_MACE4
import com.elkite.warborn.resources.SpecImage_MACE5
import com.elkite.warborn.resources.SpecImage_MACE6
import com.elkite.warborn.resources.SpecImage_MACE7
import com.elkite.warborn.resources.SpecImage_NATURE1
import com.elkite.warborn.resources.SpecImage_NATURE2
import com.elkite.warborn.resources.SpecImage_NATURE3
import com.elkite.warborn.resources.SpecImage_NATURE4
import com.elkite.warborn.resources.SpecImage_NATURE5
import com.elkite.warborn.resources.SpecImage_NATURE6
import com.elkite.warborn.resources.SpecImage_NATURE7
import com.elkite.warborn.resources.SpecImage_ROBE1
import com.elkite.warborn.resources.SpecImage_ROBE2
import com.elkite.warborn.resources.SpecImage_ROBE3
import com.elkite.warborn.resources.SpecImage_ROBE4
import com.elkite.warborn.resources.SpecImage_ROBE5
import com.elkite.warborn.resources.SpecImage_ROBE6
import com.elkite.warborn.resources.SpecImage_ROBE7
import com.elkite.warborn.resources.SpecImage_SANDALS1
import com.elkite.warborn.resources.SpecImage_SANDALS2
import com.elkite.warborn.resources.SpecImage_SANDALS3
import com.elkite.warborn.resources.SpecImage_SANDALS4
import com.elkite.warborn.resources.SpecImage_SANDALS5
import com.elkite.warborn.resources.SpecImage_SANDALS6
import com.elkite.warborn.resources.SpecImage_SANDALS7
import com.elkite.warborn.resources.SpecImage_SHOES1
import com.elkite.warborn.resources.SpecImage_SHOES2
import com.elkite.warborn.resources.SpecImage_SHOES3
import com.elkite.warborn.resources.SpecImage_SHOES4
import com.elkite.warborn.resources.SpecImage_SHOES5
import com.elkite.warborn.resources.SpecImage_SHOES6
import com.elkite.warborn.resources.SpecImage_SHOES7
import com.elkite.warborn.resources.SpecImage_SPEAR1
import com.elkite.warborn.resources.SpecImage_SPEAR2
import com.elkite.warborn.resources.SpecImage_SPEAR3
import com.elkite.warborn.resources.SpecImage_SPEAR4
import com.elkite.warborn.resources.SpecImage_SPEAR6
import com.elkite.warborn.resources.SpecImage_SPEAR7
import com.elkite.warborn.resources.SpecImage_SPEAR8
import com.elkite.warborn.resources.SpecImage_STAFF1
import com.elkite.warborn.resources.SpecImage_STAFF2
import com.elkite.warborn.resources.SpecImage_STAFF3
import com.elkite.warborn.resources.SpecImage_STAFF4
import com.elkite.warborn.resources.SpecImage_STAFF5
import com.elkite.warborn.resources.SpecImage_STAFF6
import com.elkite.warborn.resources.SpecImage_STAFF7
import com.elkite.warborn.resources.SpecImage_SWORD1
import com.elkite.warborn.resources.SpecImage_SWORD2
import com.elkite.warborn.resources.SpecImage_SWORD3
import com.elkite.warborn.resources.SpecImage_SWORD4
import com.elkite.warborn.resources.SpecImage_SWORD5
import com.elkite.warborn.resources.SpecImage_SWORD6
import com.elkite.warborn.resources.SpecImage_SWORD7
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object GearIconMap {

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

    private fun getArmorHeadIcon(id: String): DrawableResource {
        return when (id) {
            "Furor's Helm" -> Res.drawable.SpecImage_HELMET3
            "Ironclad Helm" -> Res.drawable.SpecImage_HELMET6
            "Hellfire Visor" -> Res.drawable.SpecImage_HELMET2
            "Reptilian Helm" -> Res.drawable.SpecImage_HELMET4
            "Savage Helm" -> Res.drawable.SpecImage_HELMET1
            "Stormveil Mask" -> Res.drawable.SpecImage_HELMET5
            "Warden's Gaze" -> Res.drawable.SpecImage_HELMET7

            "Vital Mantle" -> Res.drawable.SpecImage_HOOD2
            "Stormcaller's Hood" -> Res.drawable.SpecImage_HOOD1
            "Shadeveil Mask" -> Res.drawable.SpecImage_HOOD5
            "Wrathveil Shade" -> Res.drawable.SpecImage_HOOD6
            "Purifier's Shroud" -> Res.drawable.SpecImage_HOOD7
            "Ironwill veil" -> Res.drawable.SpecImage_HOOD3
            "Folly Helm" -> Res.drawable.SpecImage_HOOD4

            "Breezeweaver" -> Res.drawable.SpecImage_COWL1
            "Healer's Hood" -> Res.drawable.SpecImage_COWL3
            "Mystic Surge" -> Res.drawable.SpecImage_COWL2
            "Earth Vein Hood" -> Res.drawable.SpecImage_COWL5
            "Crimson Breeze" -> Res.drawable.SpecImage_COWL6
            "Twilight Mantle" -> Res.drawable.SpecImage_COWL7
            "Sanctum Shroud" -> Res.drawable.SpecImage_COWL4
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorChestIcon(id: String): DrawableResource {
        return when (id) {
            "Guardian's Blessing" -> Res.drawable.SpecImage_ARMOR4
            "Aegis Plate" -> Res.drawable.SpecImage_ARMOR1
            "Dazzling Guard" -> Res.drawable.SpecImage_ARMOR2
            "Tempest Charge" -> Res.drawable.SpecImage_ARMOR6
            "Tangle Guard" -> Res.drawable.SpecImage_ARMOR7
            "Warden's Shell" -> Res.drawable.SpecImage_ARMOR3
            "Magsurge Armor" -> Res.drawable.SpecImage_ARMOR5

            "Cleansing Robe" -> Res.drawable.SpecImage_ROBE1
            "Repulsor Mantle" -> Res.drawable.SpecImage_ROBE2
            "Vigorcloak" -> Res.drawable.SpecImage_ROBE3
            "Archaneweaver" -> Res.drawable.SpecImage_ROBE4
            "Dreadcloak" -> Res.drawable.SpecImage_ROBE5
            "Exorcist's Robe" -> Res.drawable.SpecImage_ROBE6
            "Warding Shroud" -> Res.drawable.SpecImage_ROBE7

            "Ranger's Hide" -> Res.drawable.SpecImage_JACKET1
            "Beastcaller's Coat" -> Res.drawable.SpecImage_JACKET2
            "Deathmantle" -> Res.drawable.SpecImage_JACKET3
            "Retaliation Coat" -> Res.drawable.SpecImage_JACKET4
            "Hero's Embrace" -> Res.drawable.SpecImage_JACKET5
            "Recovery Vest" -> Res.drawable.SpecImage_JACKET6
            "Mistshroud" -> Res.drawable.SpecImage_JACKET7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorBootsIcon(id: String): DrawableResource {
        return when (id) {
            "Energizer Boots" -> Res.drawable.SpecImage_BOOTS4
            "Wrathstep" -> Res.drawable.SpecImage_BOOTS5
            "Bulwark Striders" -> Res.drawable.SpecImage_BOOTS1
            "Titan Walkers" -> Res.drawable.SpecImage_BOOTS2
            "Vanguard's March" -> Res.drawable.SpecImage_BOOTS6
            "Impact Heavy Boots" -> Res.drawable.SpecImage_BOOTS3
            "Avalanche Boots" -> Res.drawable.SpecImage_BOOTS7

            "Blinkstep Boots" -> Res.drawable.SpecImage_SANDALS1
            "Arcaneflow Boots" -> Res.drawable.SpecImage_SANDALS2
            "Savagefoot Boots" -> Res.drawable.SpecImage_SANDALS3
            "Frostwalker Boots" -> Res.drawable.SpecImage_SANDALS4
            "Miasma Stompers" -> Res.drawable.SpecImage_SANDALS5
            "Shifter's Strides" -> Res.drawable.SpecImage_SANDALS6
            "Phantomstep Boots" -> Res.drawable.SpecImage_SANDALS7

            "Fleeting Steps" -> Res.drawable.SpecImage_SHOES1
            "Swiftstride Boots" -> Res.drawable.SpecImage_SHOES2
            "Deathwalker Boots" -> Res.drawable.SpecImage_SHOES3
            "Evasion Striders" -> Res.drawable.SpecImage_SHOES4
            "Rallystep Boots" -> Res.drawable.SpecImage_SHOES5
            "Shadeveil Slippers" -> Res.drawable.SpecImage_SHOES6
            "Exodrift Slippers" -> Res.drawable.SpecImage_SHOES7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorSwordIcon(id: String): DrawableResource {
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


    private fun getArmorHolyIcon(id: String): DrawableResource {
        return when (id) {
            "Guardian's Embrace" -> Res.drawable.SpecImage_STAFF1
            "Celestial Redeemer" -> Res.drawable.SpecImage_STAFF2
            "Luminous Ward" -> Res.drawable.SpecImage_STAFF3
            "Judgement's Staff" -> Res.drawable.SpecImage_STAFF4
            "Divine Resonator" -> Res.drawable.SpecImage_STAFF5
            "Radiant Nova" -> Res.drawable.SpecImage_STAFF6
            "Sol Protector" -> Res.drawable.SpecImage_STAFF7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorCurseIcon(id: String): DrawableResource {
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

    private fun getArmorFrostIcon(id: String): DrawableResource {
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

    private fun getArmorFireIcon(id: String): DrawableResource {
        return when (id) {
            "Flame Maw" -> Res.drawable.SpecImage_FIRE1
            "Blazing Catalyst" -> Res.drawable.SpecImage_FIRE2
            "Doomfire" -> Res.drawable.SpecImage_FIRE3
            "Inferno Core" -> Res.drawable.SpecImage_FIRE4
            "Solarflare" -> Res.drawable.SpecImage_FIRE5
            "Blazruptor" -> Res.drawable.SpecImage_FIRE6
            "Molten Mortar" -> Res.drawable.SpecImage_FIRE7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorSpearIcon(id: String): DrawableResource {
        return when (id) {
            "Sharspike" -> Res.drawable.SpecImage_SPEAR6
            "Sentinel's Lance" -> Res.drawable.SpecImage_SPEAR3
            "Stormfang Lance" -> Res.drawable.SpecImage_SPEAR1
            "Storm Spear" -> Res.drawable.SpecImage_SPEAR7
            "Drakespike" -> Res.drawable.SpecImage_SPEAR8
            "Corrosive Piercer" -> Res.drawable.SpecImage_SPEAR4
            "Phantom Spear" -> Res.drawable.SpecImage_SPEAR2
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorDaggerIcon(id: String): DrawableResource {
        return when (id) {
            "Hemoblades" -> Res.drawable.SpecImage_DAGGER7
            "Twilight Blades" -> Res.drawable.SpecImage_DAGGER1
            "Soulfangs" -> Res.drawable.SpecImage_DAGGER2
            "Bloodpiercers" -> Res.drawable.SpecImage_DAGGER5
            "Bloodfury Blades" -> Res.drawable.SpecImage_DAGGER4
            "Bloodthirst" -> Res.drawable.SpecImage_DAGGER6
            "Scarlet Hunger" -> Res.drawable.SpecImage_DAGGER3
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorNatureIcon(id: String): DrawableResource {
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

    private fun getArmorGunIcon(id: String): DrawableResource {
        return when (id) {
            "Shattercoil" -> Res.drawable.SpecImage_GUN1
            "Sentinel Barrage" -> Res.drawable.SpecImage_GUN2
            "Spectral Assault" -> Res.drawable.SpecImage_GUN3
            "Blightspitter" -> Res.drawable.SpecImage_GUN4
            "Luminet Cannon" -> Res.drawable.SpecImage_GUN6
            "Voideye" -> Res.drawable.SpecImage_GUN5
            "Prism Cloak" -> Res.drawable.SpecImage_GUN7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorAxeIcon(id: String): DrawableResource {
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

    private fun getArmorMaceIcon(id: String): DrawableResource {
        return when (id) {
            "Breaker's Resolve" -> Res.drawable.SpecImage_MACE1
            "Gravity Hammer" -> Res.drawable.SpecImage_MACE2
            "Voidbreaker" -> Res.drawable.SpecImage_MACE3
            "Ripper's Grasp" -> Res.drawable.SpecImage_MACE4
            "Bulwark Core" -> Res.drawable.SpecImage_MACE6
            "Abyssal Conduit" -> Res.drawable.SpecImage_MACE5
            "Thunderlord's Wrath" -> Res.drawable.SpecImage_MACE7
            else -> Res.drawable.error_emoji
        }
    }

    private fun getArmorBowIcon(id: String): DrawableResource {
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
}
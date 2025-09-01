package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.GearSlot
import com.elkite.warborn.domain.entities.gear.HeadGear

data class Boots(
    val strBoots: List<BootsGear>,
    val dexBoots: List<BootsGear>,
    val intBoots: List<BootsGear>,
    val gearSlot: GearSlot = GearSlot.BOOTS
)

data class Chest(
    val strChest: List<ChestGear>,
    val dexChest: List<ChestGear>,
    val intChest: List<ChestGear>,
    val gearSlot: GearSlot = GearSlot.CHEST
)

data class Head(
    val strHead: List<HeadGear>,
    val dexHead: List<HeadGear>,
    val intHead: List<HeadGear>,
    val gearSlot: GearSlot = GearSlot.HEAD
)

data class DataArmors(
    val boots: Boots,
    val chest: Chest,
    val head: Head
)
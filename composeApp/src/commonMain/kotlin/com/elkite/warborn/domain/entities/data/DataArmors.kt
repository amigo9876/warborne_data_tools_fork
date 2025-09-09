package com.elkite.warborn.domain.entities.data

import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.GearSlot
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.IGear

data class Boots(
    val strBoots: List<BootsGear>,
    val dexBoots: List<BootsGear>,
    val intBoots: List<BootsGear>,
) : IDataGears(
    str = strBoots,
    dex = dexBoots,
    int = intBoots,
    gearSlot = GearSlot.BOOTS
)

data class Chest(
    val strChest: List<ChestGear>,
    val dexChest: List<ChestGear>,
    val intChest: List<ChestGear>,
) : IDataGears(
    str = strChest,
    dex = dexChest,
    int = intChest,
    gearSlot = GearSlot.CHEST
)

data class Head(
    val strHead: List<HeadGear>,
    val dexHead: List<HeadGear>,
    val intHead: List<HeadGear>,
) : IDataGears(
    str = strHead,
    dex = dexHead,
    int = intHead,
    gearSlot = GearSlot.HEAD
)

data class DataArmors(
    val boots: Boots,
    val chest: Chest,
    val head: Head
)

open class IDataGears(
    val str: List<IGear>,
    val dex: List<IGear>,
    val int: List<IGear>,
    val gearSlot: GearSlot
)
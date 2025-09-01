package com.elkite.warborn.domain.entities.loadout

import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.spells.BasicSpell
import com.elkite.warborn.domain.entities.spells.CommonSpell
import com.elkite.warborn.domain.entities.spells.PassiveSpell

data class WeaponLoadout(
    val weapon: WeaponGear,
    val passive: PassiveSpell,
    val basic: BasicSpell,
    val common: CommonSpell,
)
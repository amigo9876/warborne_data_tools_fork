package com.elkite.warborn.domain.entities.gear

import kotlinx.serialization.Serializable

@Serializable
enum class GearLevel(val textValue: String) {
    TIER_0 ("TIER 0"),
    TIER_I("TIER I"),
    TIER_II("TIER II"),
    TIER_III("TIER III"),
    TIER_IV("TIER IV"),
    TIER_V("TIER V"),
    TIER_VI("TIER VI"),
    TIER_VII("TIER VII"),
    TIER_VIII("TIER VIII"),
    TIER_IX("TIER IX"),
    TIER_X("TIER X"),
    TIER_X_("TIER XI"),
}
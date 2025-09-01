package com.elkite.warborn.domain.entities.spells

import kotlinx.serialization.Serializable

internal interface ISpell {
    val spellId: String
    val spellName: String
    val description: String
    val type: SpellType
    val manaCost: String
    val cooldown: String
    val castingRange: String
    val tierUnlock: TierUnlock
}

@Serializable
enum class SpellType {
    passive,
    basic,
    common,
    skill
}

@Serializable
enum class TierUnlock(tier: Int) {
    T0(0),
    T1(1),
    T2(2),
    T3(3),
    T4(4),
    T5(5),
    T6(6),
    T7(7),
    T8(8),
    T9(9),
    T10(10),
    T11(11),
}
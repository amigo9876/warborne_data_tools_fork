package com.elkite.warborn.domain.entities.spells

import kotlinx.serialization.Serializable

interface ISpell {
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
enum class TierUnlock(val tier: String) {
    T0("0"),
    T1("1"),
    TII("2"),
    TIII("3"),
    TIV("4"),
    TV("5"),
    TVI("6"),
    TVII("7"),
    TVIII("8"),
    TIX("9"),
    TX("10"),
    TXI("11"),
}
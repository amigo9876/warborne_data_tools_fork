package com.elkite.warborn.domain.entities.spells

import kotlinx.serialization.Serializable

@Serializable
data class PassiveSpell(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,
    override val type: SpellType = SpellType.passive,
) : ISpell

@Serializable
data class BasicSpell(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,
    override val type: SpellType = SpellType.basic,
    ) : ISpell

@Serializable
data class CommonSpell(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,
    override val type: SpellType = SpellType.common,
) : ISpell

@Serializable
data class SkillSpell(
    override val spellId: String,
    override val spellName: String,
    override val description: String,
    override val manaCost: String,
    override val cooldown: String,
    override val castingRange: String,
    override val tierUnlock: TierUnlock,
    override val type: SpellType = SpellType.skill,
) : ISpell
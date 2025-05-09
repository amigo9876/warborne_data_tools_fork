package com.elkite.warborn.presentation.screen.build_loadout

import cafe.adriel.voyager.core.model.ScreenModel
import com.elkite.warborn.data.repository.DataRepository
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.spell.Spell
import com.elkite.warborn.domain.entities.spell.SpellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BuildScreenModel : ScreenModel {

    private val _spellsState = MutableStateFlow<SpellsState>(SpellsState.Loading)
    val spellsState: StateFlow<SpellsState> = _spellsState

    private val _loadout = MutableStateFlow(Loadout())
    val loadout: StateFlow<Loadout> = _loadout

    private val _currentSpells = MutableStateFlow<List<Spell>>(emptyList())
    val currentSpells: StateFlow<List<Spell>> = _currentSpells

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        loadSpells()
    }

    fun resetSpellsList() {
        _currentSpells.value = emptyList()
    }

    fun updateSpellsList(gearType: GearType, spellType: SpellType? = null) {
        _currentSpells.value = when (val state = _spellsState.value) {
            is SpellsState.Success -> {
                when (gearType) {
                    GearType.HEAD -> state.head
                    GearType.CHEST -> state.chest
                    GearType.BOOTS -> state.boots
                    GearType.SWORD -> state.sword
                    GearType.GUN -> state.gun
                    GearType.AXE -> state.axe
                    GearType.MACE -> state.mace
                    else -> emptyList()
                }.filter {
                    if (spellType != null) {
                        it.type == spellType
                    } else {
                        true
                    }
                }
            }

            else -> emptyList()
        }
    }

    fun updatePassive(gearType: GearType) {
        val passive = when (val state = _spellsState.value) {
            is SpellsState.Success -> {
                when (gearType) {
                    GearType.SWORD -> state.sword.first { it.type == SpellType.PASSIVE }
                    GearType.GUN -> state.gun.first { it.type == SpellType.PASSIVE }
                    GearType.AXE -> state.axe.first { it.type == SpellType.PASSIVE }
                    GearType.MACE -> state.mace.first { it.type == SpellType.PASSIVE }
                    else -> null
                }
            }

            else -> null
        }

        _loadout.value = _loadout.value.copy(
            passive = passive,
            commonSkill = null,
            basicAttack = null,
            weapon = null
        )
    }

    fun updateLoadout(newSpell: Spell) {
        _loadout.value = when (newSpell.getLoadoutType()) {
            LoadoutType.HEAD -> _loadout.value.copy(head = newSpell)
            LoadoutType.CHEST -> _loadout.value.copy(chest = newSpell)
            LoadoutType.BOOTS -> _loadout.value.copy(boots = newSpell)
            LoadoutType.WEAPON -> _loadout.value.copy(weapon = newSpell)
            LoadoutType.PASSIVE -> _loadout.value.copy(passive = newSpell)
            LoadoutType.COMMON_SKILL -> _loadout.value.copy(commonSkill = newSpell)
            LoadoutType.BASIC_ATTACK -> _loadout.value.copy(basicAttack = newSpell)
        }
    }

    //TODO SET SPELLS FROM THIS
    // HEAD LOADOUT CARD ONCLICK (UPDATE SPELL LIST -> IF LIST NOT EMPTY SHOW SPELLS
    // CHEST ``
    // BOOTS``
    // WEAPON (SHOW WEAPON -> LOADOUT CARD) ONCLICK (UPDATE SPELL LIST -> IF LIST NOT EMPTY SHOW SPELLS

    private fun loadSpells() {
        coroutineScope.launch {
            try {
                val spells = DataRepository.getData()
                _spellsState.update {
                    SpellsState.Success(
                        head = spells.filter { it.associatedGearType == GearType.HEAD },
                        chest = spells.filter { it.associatedGearType == GearType.CHEST },
                        boots = spells.filter { it.associatedGearType == GearType.BOOTS },
                        sword = spells.filter { it.associatedGearType == GearType.SWORD },
                        gun = spells.filter { it.associatedGearType == GearType.GUN },
                        axe = spells.filter { it.associatedGearType == GearType.AXE },
                        mace = spells.filter { it.associatedGearType == GearType.MACE }
                    )
                }
            } catch (e: Exception) {
                _spellsState.update { SpellsState.Error(e.message ?: "Unknown error") }
            }
        }
    }

    sealed class SpellsState {
        data object Loading : SpellsState()
        data class Success(
            val head: List<Spell>,
            val chest: List<Spell>,
            val boots: List<Spell>,
            val sword: List<Spell>,
            val gun: List<Spell>,
            val axe: List<Spell>,
            val mace: List<Spell>,
        ) : SpellsState()

        data class Error(val message: String) : SpellsState()
    }
}
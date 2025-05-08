package com.elkite.warborn.presentation.screen.buidloadout

import cafe.adriel.voyager.core.model.ScreenModel
import com.elkite.warborn.data.repository.DataRepository
import com.elkite.warborn.domain.entities.gear.Boots
import com.elkite.warborn.domain.entities.gear.Chest
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Head
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.Weapon
import com.elkite.warborn.domain.entities.spell.Spell
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

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        loadSpells()
    }

    fun updateLoadout(newSpell: Spell) {
        _loadout.value = when (newSpell.associatedGearType) {
            GearType.HEAD -> _loadout.value.copy(head = Head(
                id = newSpell.id,
                name = newSpell.name,
                spell = newSpell
            ))
            GearType.CHEST -> _loadout.value.copy(chest = Chest(
                id = newSpell.id,
                name = newSpell.name,
                spell = newSpell
            ))
            GearType.BOOTS -> _loadout.value.copy(boots = Boots(
                id = newSpell.id,
                name = newSpell.name,
                spell = newSpell
            ))
            else  -> _loadout.value.copy(weapon = Weapon(
                id = newSpell.id,
                name = newSpell.name,
                spell = newSpell,
                type = newSpell.associatedGearType,
                passive = newSpell, //TODO GET WEAPON PASSIVE FROM STATE LIST
                basicAttack = null, //TSET NULL AND CHOOSE LATER
                commonSkill = null, //SET NULL AND CJOOSE LASTER
                ))
        }
    }

    private fun loadSpells() {
        coroutineScope.launch {
            try {
                val spells = DataRepository.getData()
                _spellsState.update { SpellsState.Success(
                    head = spells.filter { it.associatedGearType == GearType.HEAD },
                    chest = spells.filter { it.associatedGearType == GearType.CHEST },
                    boots = spells.filter { it.associatedGearType == GearType.BOOTS },
                    sword = spells.filter { it.associatedGearType == GearType.SWORD },
                    gun = spells.filter { it.associatedGearType == GearType.GUN },
                    axe = spells.filter { it.associatedGearType == GearType.AXE },
                    mace = spells.filter { it.associatedGearType == GearType.MACE }
                ) }
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
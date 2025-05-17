package com.elkite.warborn.presentation.screen.main

import cafe.adriel.voyager.core.model.ScreenModel
import com.elkite.warborn.data.repository.DataRepository
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.Loadout
import com.elkite.warborn.domain.entities.gear.LoadoutType
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.domain.entities.gear.spell.SpellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenModel : ScreenModel {

    private val _screenState = MutableStateFlow<BuildScreenState>(BuildScreenState.Loading)
    val buildScreenState: StateFlow<BuildScreenState> = _screenState

    private val _loadout = MutableStateFlow(Loadout())
    val loadout: StateFlow<Loadout> = _loadout

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        loadSpells()
    }

    fun updatePassive(gearType: GearType) {
       _loadout.value = when (val state = _screenState.value) {
            is BuildScreenState.Success -> {
                if (_loadout.value.weapon?.associatedGearType != gearType)
                _loadout.value.copy(
                    passive = state.weapons[gearType]?.first { it.type == SpellType.PASSIVE },
                    basicAttack = state.weapons[gearType]?.first { it.type == SpellType.BASIC_ATTACK },
                    commonSkill = state.weapons[gearType]?.first { it.type == SpellType.COMMON_SKILL },
                    weapon = state.weapons[gearType]?.first { it.type == SpellType.SKILL },
                ) else
                    _loadout.value.copy(passive = state.weapons[gearType]?.first { it.type == SpellType.PASSIVE },)
            }

            else -> _loadout.value
        }
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
            LoadoutType.DRIFTER -> {
                _loadout.value
            }
        }
    }

    fun updateDrifter(drifter: Drifter) {
        _loadout.value = _loadout.value.copy(drifter = drifter)
    }

    private fun loadSpells() {
        coroutineScope.launch {
            try {
                val spells = DataRepository.getData()
                val drifters = DataRepository.getDrifters()
                val lastDataUpdate = DataRepository.getLastUpdateData()

                _screenState.update {
                    BuildScreenState.Success(
                        lastDataUpdate = lastDataUpdate,
                        head = HashMap(
                            mapOf(
                                GearStats.STR to spells.filter { it.associatedGearType == GearType.HEAD && it.gearStats == GearStats.STR },
                                GearStats.AGI to spells.filter { it.associatedGearType == GearType.HEAD && it.gearStats == GearStats.AGI },
                                GearStats.INT to spells.filter { it.associatedGearType == GearType.HEAD && it.gearStats == GearStats.INT }
                            )
                        ),
                        chest = HashMap(
                            mapOf(
                                GearStats.STR to spells.filter { it.associatedGearType == GearType.CHEST && it.gearStats == GearStats.STR },
                                GearStats.AGI to spells.filter { it.associatedGearType == GearType.CHEST && it.gearStats == GearStats.AGI },
                                GearStats.INT to spells.filter { it.associatedGearType == GearType.CHEST && it.gearStats == GearStats.INT }
                            )
                        ),
                        boots = HashMap(
                            mapOf(
                                GearStats.STR to spells.filter { it.associatedGearType == GearType.BOOTS && it.gearStats == GearStats.STR },
                                GearStats.AGI to spells.filter { it.associatedGearType == GearType.BOOTS && it.gearStats == GearStats.AGI },
                                GearStats.INT to spells.filter { it.associatedGearType == GearType.BOOTS && it.gearStats == GearStats.INT }
                            )
                        ),
                        weapons = HashMap(
                            mapOf(
                                GearType.SWORD to spells.filter { it.associatedGearType == GearType.SWORD },
                                GearType.GUN to spells.filter { it.associatedGearType == GearType.GUN },
                                GearType.AXE to spells.filter { it.associatedGearType == GearType.AXE },
                                GearType.MACE to spells.filter { it.associatedGearType == GearType.MACE },
                                GearType.BOW to spells.filter { it.associatedGearType == GearType.BOW },
                                GearType.SPEAR to spells.filter { it.associatedGearType == GearType.SPEAR },
                                GearType.NATURE to spells.filter { it.associatedGearType == GearType.NATURE },
                                GearType.DAGGER to spells.filter { it.associatedGearType == GearType.DAGGER },
                                GearType.FIRE to spells.filter { it.associatedGearType == GearType.FIRE },
                                GearType.FROST to spells.filter { it.associatedGearType == GearType.FROST },
                                GearType.CURSE to spells.filter { it.associatedGearType == GearType.CURSE },
                                GearType.HOLY to spells.filter { it.associatedGearType == GearType.HOLY }
                            )
                        ),
                        drifters = drifters
                    )
                }
            } catch (e: Exception) {
                _screenState.update { BuildScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }

    fun updateLoadoutFromUrl(url: String?) {
        val queryParams = parseQueryParams(url)

        coroutineScope.launch {
            val spells = DataRepository.getData()
            val drifters = DataRepository.getDrifters()

            val newLoadout = Loadout(
                head = queryParams["head"]?.let { gameId -> spells.find { it.gameId == gameId } },
                chest = queryParams["chest"]?.let { gameId -> spells.find { it.gameId == gameId } },
                boots = queryParams["boots"]?.let { gameId -> spells.find { it.gameId == gameId } },
                weapon = queryParams["weapon"]?.let { gameId -> spells.find { it.gameId == gameId } },
                passive = queryParams["passive"]?.let { gameId -> spells.find { it.gameId == gameId } },
                commonSkill = queryParams["commonSkill"]?.let { gameId -> spells.find { it.gameId == gameId } },
                basicAttack = queryParams["basicAttack"]?.let { gameId -> spells.find { it.gameId == gameId } },
                drifter = queryParams["drifter"]?.let { gameId -> drifters.find { it.gameId == gameId } }
            )

            if (_loadout.value != newLoadout) {
                _loadout.value = newLoadout
            }
        }
    }

    private fun parseQueryParams(url: String?): Map<String, String> {
        return url?.substringAfter("?")
            ?.split("&")
            ?.mapNotNull {
                val parts = it.split("=")
                if (parts.size == 2) parts[0] to parts[1] else null
            }?.toMap() ?: emptyMap()
    }

    sealed class BuildScreenState {
        data object Loading : BuildScreenState()
        data class Success(
            val lastDataUpdate: String,
            val head: HashMap<GearStats, List<Spell>>,
            val chest: HashMap<GearStats, List<Spell>>,
            val boots: HashMap<GearStats, List<Spell>>,
            val weapons: HashMap<GearType, List<Spell>>,
            val drifters: List<Drifter>,
        ) : BuildScreenState()

        data class Error(val message: String) : BuildScreenState()
    }
}
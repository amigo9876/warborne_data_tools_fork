package com.elkite.warborn.presentation.screen.main

import cafe.adriel.voyager.core.model.ScreenModel
import com.elkite.warborn.data.repository.DataRepository
import com.elkite.warborn.data.repository.DataaRespository
import com.elkite.warborn.domain.entities.data.Data
import com.elkite.warborn.domain.entities.old.GearStats
import com.elkite.warborn.domain.entities.old.GearType
import com.elkite.warborn.domain.entities.old.Loadout
import com.elkite.warborn.domain.entities.old.LoadoutType
import com.elkite.warborn.domain.entities.old.drifter.Drifter
import com.elkite.warborn.domain.entities.old.mods.Mod
import com.elkite.warborn.domain.entities.old.spell.Spell
import com.elkite.warborn.domain.entities.old.spell.SpellType
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

    fun updateModWeapon(mod: Mod) {
        _loadout.value = _loadout.value.copy(modWeapon = mod)
    }

    fun updateModHead(mod: Mod) {
        if (_loadout.value.modChest?.name == mod.name)
            _loadout.value = _loadout.value.copy(modChest = null)
        if (_loadout.value.modBoots?.name == mod.name)
            _loadout.value = _loadout.value.copy(modBoots = null)
        _loadout.value = _loadout.value.copy(modHead = mod)
    }

    fun updateModChest(mod: Mod) {
        if (_loadout.value.modHead?.name == mod.name)
            _loadout.value = _loadout.value.copy(modHead = null)
        if (_loadout.value.modBoots?.name == mod.name)
            _loadout.value = _loadout.value.copy(modBoots = null)
        _loadout.value = _loadout.value.copy(modChest = mod)
    }

    fun updateModBoots(mod: Mod) {
        if (_loadout.value.modChest?.name == mod.name)
            _loadout.value = _loadout.value.copy(modChest = null)
        if (_loadout.value.modHead?.name == mod.name)
            _loadout.value = _loadout.value.copy(modHead = null)
        _loadout.value = _loadout.value.copy(modBoots = mod)
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
    //TODO switch to gear with cast
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
            else -> {
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
                val data = DataRepository.getData()
                val newData = DataaRespository.getData()

                _screenState.update {
                    BuildScreenState.Success(
                        lastDataUpdate = data.lastUpdate,
                        newData = newData,
                        head = HashMap(
                            mapOf(
                                GearStats.STR to data.spells.filter { it.associatedGearType == GearType.HEAD && it.gearStats == GearStats.STR },
                                GearStats.AGI to data.spells.filter { it.associatedGearType == GearType.HEAD && it.gearStats == GearStats.AGI },
                                GearStats.INT to data.spells.filter { it.associatedGearType == GearType.HEAD && it.gearStats == GearStats.INT }
                            )
                        ),
                        chest = HashMap(
                            mapOf(
                                GearStats.STR to data.spells.filter { it.associatedGearType == GearType.CHEST && it.gearStats == GearStats.STR },
                                GearStats.AGI to data.spells.filter { it.associatedGearType == GearType.CHEST && it.gearStats == GearStats.AGI },
                                GearStats.INT to data.spells.filter { it.associatedGearType == GearType.CHEST && it.gearStats == GearStats.INT }
                            )
                        ),
                        boots = HashMap(
                            mapOf(
                                GearStats.STR to data.spells.filter { it.associatedGearType == GearType.BOOTS && it.gearStats == GearStats.STR },
                                GearStats.AGI to data.spells.filter { it.associatedGearType == GearType.BOOTS && it.gearStats == GearStats.AGI },
                                GearStats.INT to data.spells.filter { it.associatedGearType == GearType.BOOTS && it.gearStats == GearStats.INT }
                            )
                        ),
                        weapons = HashMap(
                            mapOf(
                                GearType.SWORD to data.spells.filter { it.associatedGearType == GearType.SWORD },
                                GearType.GUN to data.spells.filter { it.associatedGearType == GearType.GUN },
                                GearType.AXE to data.spells.filter { it.associatedGearType == GearType.AXE },
                                GearType.MACE to data.spells.filter { it.associatedGearType == GearType.MACE },
                                GearType.BOW to data.spells.filter { it.associatedGearType == GearType.BOW },
                                GearType.SPEAR to data.spells.filter { it.associatedGearType == GearType.SPEAR },
                                GearType.NATURE to data.spells.filter { it.associatedGearType == GearType.NATURE },
                                GearType.DAGGER to data.spells.filter { it.associatedGearType == GearType.DAGGER },
                                GearType.FIRE to data.spells.filter { it.associatedGearType == GearType.FIRE },
                                GearType.FROST to data.spells.filter { it.associatedGearType == GearType.FROST },
                                GearType.CURSE to data.spells.filter { it.associatedGearType == GearType.CURSE },
                                GearType.HOLY to data.spells.filter { it.associatedGearType == GearType.HOLY }
                            )
                        ),
                        drifters = data.drifters,
                        mods = data.mods
                    )
                }
            } catch (e: Exception) {
                _screenState.update { BuildScreenState.Error(e.message ?: "Unknown error") }
            }
        }
    }

    fun updateLoadoutFromUrl(url: String?, state: BuildScreenState.Success) {
        val queryParams = parseQueryParams(url)

        val newLoadout = Loadout(
            head = queryParams["head"]?.let { gameId -> state.head.values.flatten().find { it.gameId == gameId } },
            chest = queryParams["chest"]?.let { gameId -> state.chest.values.flatten().find { it.gameId == gameId } },
            boots = queryParams["boots"]?.let { gameId -> state.boots.values.flatten().find { it.gameId == gameId } },
            weapon = queryParams["weapon"]?.let { gameId -> state.weapons.values.flatten().find { it.gameId == gameId } },
            passive = queryParams["passive"]?.let { gameId -> state.weapons.values.flatten().find { it.gameId == gameId } },
            commonSkill = queryParams["commonSkill"]?.let { gameId -> state.weapons.values.flatten().find { it.gameId == gameId } },
            basicAttack = queryParams["basicAttack"]?.let { gameId -> state.weapons.values.flatten().find { it.gameId == gameId } },
            drifter = queryParams["drifter"]?.let { gameId -> state.drifters.find { it.gameId == gameId } },
            modWeapon = queryParams["modWeapon"]?.let { id -> state.mods.find { it.gameId == id } },
            modHead = queryParams["modHead"]?.let { id -> state.mods.find { it.gameId == id } },
            modChest = queryParams["modChest"]?.let { id -> state.mods.find { it.gameId == id } },
            modBoots = queryParams["modBoots"]?.let { id -> state.mods.find { it.gameId == id } }
        )

        if (_loadout.value != newLoadout) {
            _loadout.value = newLoadout
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
            val mods: List<Mod>,
            val newData: Data
        ) : BuildScreenState()

        data class Error(val message: String) : BuildScreenState()
    }
}
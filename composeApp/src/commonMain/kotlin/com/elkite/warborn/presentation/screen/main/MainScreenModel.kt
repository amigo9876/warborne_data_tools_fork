package com.elkite.warborn.presentation.screen.main

import cafe.adriel.voyager.core.model.ScreenModel
import com.elkite.warborn.data.repository.DataRepository
import com.elkite.warborn.domain.entities.consumable.Consumable
import com.elkite.warborn.domain.entities.data.Data
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.BootsGear
import com.elkite.warborn.domain.entities.gear.ChestGear
import com.elkite.warborn.domain.entities.gear.HeadGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.loadout.Loadout
import com.elkite.warborn.domain.entities.loadout.SelectedLoadoutType
import com.elkite.warborn.domain.entities.mod.ArmorMod
import com.elkite.warborn.domain.entities.mod.WeaponMod
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

    fun updateSelectedLoadout(selectedLoadoutType: SelectedLoadoutType) {
        _loadout.value = _loadout.value.copy(selectedLoadoutType = selectedLoadoutType)
    }

    fun updateWeaponMod(mod: WeaponMod) {
        _loadout.value = _loadout.value.copy(weaponMod = mod)
    }

    fun updateDrifter(drifter: Drifter) {
        _loadout.value = _loadout.value.copy(drifter = drifter)
    }

    fun updateWeapon(weapon: WeaponGear) {
        _loadout.value = _loadout.value.copy(weapon = weapon)
    }

    fun updateModHead(mod: ArmorMod) {
        if (_loadout.value.chestMod?.name == mod.name)
            _loadout.value = _loadout.value.copy(chestMod = null)
        if (_loadout.value.bootsMod?.name == mod.name)
            _loadout.value = _loadout.value.copy(bootsMod = null)
        _loadout.value = _loadout.value.copy(headMod = mod)
    }

    fun updateModChest(mod: ArmorMod) {
        if (_loadout.value.headMod?.name == mod.name)
            _loadout.value = _loadout.value.copy(headMod = null)
        if (_loadout.value.bootsMod?.name == mod.name)
            _loadout.value = _loadout.value.copy(bootsMod = null)
        _loadout.value = _loadout.value.copy(chestMod = mod)
    }

    fun updateModBoots(mod: ArmorMod) {
        if (_loadout.value.chestMod?.name == mod.name)
            _loadout.value = _loadout.value.copy(chestMod = null)
        if (_loadout.value.headMod?.name == mod.name)
            _loadout.value = _loadout.value.copy(headMod = null)
        _loadout.value = _loadout.value.copy(bootsMod = mod)
    }

    fun updateHead(head: HeadGear) {
        _loadout.value = _loadout.value.copy(head = head)
    }

    fun updateChest(chest: ChestGear) {
        _loadout.value = _loadout.value.copy(chest = chest)
    }

    fun updateBoots(boots: BootsGear) {
        _loadout.value = _loadout.value.copy(boots = boots)
    }

    fun updateConsumable(consumable: Consumable) {
        _loadout.value = _loadout.value.copy(consumable = consumable)
    }

    private fun loadSpells() {
        coroutineScope.launch {
            try {
                val data = DataRepository.getData()
                _screenState.update {
                    BuildScreenState.Success(
                        data = data,
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
            head = queryParams["head"]?.let { gearName ->
                val heads = mutableListOf<HeadGear>()
                heads.addAll(state.data.armors.head.dexHead)
                heads.addAll(state.data.armors.head.intHead)
                heads.addAll(state.data.armors.head.strHead)
                return@let heads.find { it.spellId == gearName }
            },
            headMod = queryParams["modHead"]?.let { name ->
                state.data.mods.armors.find { it.iconName == name }
            },
            chest = queryParams["chest"]?.let { gearName ->
                val chests = mutableListOf<ChestGear>()
                chests.addAll(state.data.armors.chest.dexChest)
                chests.addAll(state.data.armors.chest.intChest)
                chests.addAll(state.data.armors.chest.strChest)
                chests.find { it.spellId == gearName }
            },
            chestMod = queryParams["modChest"]?.let { name ->
                state.data.mods.armors.find { it.iconName == name }
            },
            boots = queryParams["boots"]?.let { gearName ->
                val boots = mutableListOf<BootsGear>()
                boots.addAll(state.data.armors.boots.dexBoots)
                boots.addAll(state.data.armors.boots.intBoots)
                boots.addAll(state.data.armors.boots.strBoots)
                boots.find { it.spellId == gearName }
            },
            bootsMod = queryParams["modBoots"]?.let { name ->
                state.data.mods.armors.find { it.iconName == name }
            },
            weapon = queryParams["weapon"]?.let { spellName ->
                val weapons = mutableListOf<WeaponGear>()
                weapons.addAll(state.data.weapons.axe.skills)
                weapons.addAll(state.data.weapons.bow.skills)
                weapons.addAll(state.data.weapons.dagger.skills)
                weapons.addAll(state.data.weapons.fire.skills)
                weapons.addAll(state.data.weapons.frost.skills)
                weapons.addAll(state.data.weapons.gun.skills)
                weapons.addAll(state.data.weapons.holy.skills)
                weapons.addAll(state.data.weapons.mace.skills)
                weapons.addAll(state.data.weapons.nature.skills)
                weapons.addAll(state.data.weapons.spear.skills)
                weapons.addAll(state.data.weapons.sword.skills)
                weapons.addAll(state.data.weapons.curse.skills)

                val weapon: WeaponGear = weapons.find { it.spellId == spellName } ?: return@let null

                return@let weapon.copy(
                    passiveSpell = queryParams["passive"]?.let { _ -> weapon.passiveSpell }
                        ?: return@let null,
                    activeCommonSpell = queryParams["commonSkill"]?.let { name -> weapon.commonSpells.find { it.spellId == name } }
                        ?: return@let null,
                    activeBasicSpell = queryParams["basicAttack"]?.let { name -> weapon.basicSpells.find { it.spellId == name } }
                        ?: return@let null,
                )
            },
            weaponMod = queryParams["modWeapon"]?.let { id -> state.data.mods.weapons.find { it.iconName == id } },

            drifter = queryParams["drifter"]?.let { gameId ->
                val drifters = mutableListOf<Drifter>()
                drifters.addAll(state.data.drifters.dexDrifters)
                drifters.addAll(state.data.drifters.strDrifters)
                drifters.addAll(state.data.drifters.intDrifters)
                drifters.addAll(state.data.drifters.gathers)

                drifters.find { it.gameId == gameId }
            },
            consumable = queryParams["consumable"]?.let { gameId ->
                val consumable = mutableListOf<Consumable>()
                consumable.addAll(state.data.consumables.food)
                consumable.addAll(state.data.consumables.potions)
                consumable.addAll(state.data.consumables.poisons)
                consumable.addAll(state.data.consumables.utilities)

                consumable.find { it.gameId == gameId }
            },
            selectedLoadoutType = _loadout.value.selectedLoadoutType
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
            val data: Data
        ) : BuildScreenState()

        data class Error(val message: String) : BuildScreenState()
    }
}
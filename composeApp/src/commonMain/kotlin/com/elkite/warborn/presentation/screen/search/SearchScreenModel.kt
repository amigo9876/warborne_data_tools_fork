package com.elkite.warborn.presentation.screen.search

import cafe.adriel.voyager.core.model.ScreenModel
import com.elkite.warborn.domain.entities.data.Data
import com.elkite.warborn.domain.entities.data.WeaponType
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.GearSlot
import com.elkite.warborn.domain.entities.gear.IGear
import com.elkite.warborn.domain.entities.gear.WeaponGear
import com.elkite.warborn.domain.entities.mod.IMod
import com.elkite.warborn.domain.entities.spells.ISpell
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchScreenModel(data: Data) : ScreenModel {

    private val drifters: List<Drifter> = listOf(
        data.drifters.dexDrifters,
        data.drifters.strDrifters,
        data.drifters.intDrifters
    ).flatten()

    private val weapons: List<WeaponGear> = listOf(
        data.weapons.sword,
        data.weapons.axe,
        data.weapons.mace,
        data.weapons.gun,
        data.weapons.bow,
        data.weapons.spear,
        data.weapons.dagger,
        data.weapons.nature,
        data.weapons.fire,
        data.weapons.frost,
        data.weapons.curse,
        data.weapons.holy
    ).map { it.skills }.flatten()

    private val armors: List<IGear> = listOf(
        data.armors.head.strHead,
        data.armors.head.intHead,
        data.armors.head.dexHead,
        data.armors.chest.strChest,
        data.armors.chest.intChest,
        data.armors.chest.dexChest,
        data.armors.boots.strBoots,
        data.armors.boots.intBoots,
        data.armors.boots.dexBoots,
    ).flatten()

    private val mods = listOf(
        data.mods.armors,
        data.mods.weapons,
    ).flatten()

    private val _drifterResults = MutableStateFlow<List<Pair<Drifter, ISpell>>>(emptyList())
    val drifterFiltered: StateFlow<List<Pair<Drifter, ISpell>>> = _drifterResults

    private val _weaponResults = MutableStateFlow<List<Pair<WeaponType, ISpell>>>(emptyList())
    val weaponFiltered: StateFlow<List<Pair<WeaponType, ISpell>>> = _weaponResults

    private val _armorResults = MutableStateFlow<List<Pair<GearSlot, IGear>>>(emptyList())
    val armorFiltered: StateFlow<List<Pair<GearSlot, IGear>>> = _armorResults

    private val _modResults = MutableStateFlow<List<IMod>>(emptyList())
    val modFiltered: StateFlow<List<IMod>> = _modResults


    fun filterDrifters(query: String) {
        _drifterResults.value = if (query.isEmpty()) {
            drifters.map { it to it.spell } + drifters.map { it to it.passive }
        } else {
            drifters.map {
                it to it.spell
            }.filter {
                it.second.description.contains(
                    query, ignoreCase = true
                )
            } + drifters.map {
                it to it.passive
            }.filter {
                it.second.description.contains(
                    query, ignoreCase = true
                )
            }
        }
    }

    fun filterWeapons(query: String) {
        if (query.isEmpty()) {
            _weaponResults.value = weapons.map { it.weaponType to it }
        } else {
            val skills: MutableList<Pair<WeaponType, ISpell>> = mutableListOf()
            weapons.map {
                if (it.description.contains(query, ignoreCase = true))
                    skills.add(it.weaponType to it)
            }
            val tmp = weapons.first()
                if (tmp.passiveSpell.description.contains(query, ignoreCase = true))
                    skills.add(tmp.weaponType to tmp.passiveSpell)

            tmp.commonSpells.forEach { commonSpell ->
                    if (commonSpell.description.contains(query, ignoreCase = true))
                        skills.add(tmp.weaponType to commonSpell)
                }

            tmp.basicSpells.forEach { basicSpell ->
                    if (basicSpell.description.contains(query, ignoreCase = true))
                        skills.add(tmp.weaponType to basicSpell)
                }
            _weaponResults.value = skills
        }
    }

    fun filterArmor(query: String) {
        if (query.isEmpty()) {
            _armorResults.value = armors.map { it.gearSlot to it }
        } else {
            _armorResults.value = armors.filter {
                it.description.contains(
                    query, ignoreCase = true
                )
            }.map { it.gearSlot to it }
        }
    }

    fun filterMods(query: String) {
        if (query.isEmpty()) {
            _modResults.value = mods
        } else {
            _modResults.value = mods.filter {
                it.description.contains(
                    query, ignoreCase = true
                )
            }
        }
    }
}
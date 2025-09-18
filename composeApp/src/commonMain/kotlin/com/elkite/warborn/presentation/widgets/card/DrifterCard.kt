package com.elkite.warborn.presentation.widgets.card


import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.drifter.Drifter
import com.elkite.warborn.domain.entities.spells.ISpell
import com.elkite.warborn.domain.entities.spells.SpellType
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.theme.spellBorder
import com.elkite.warborn.presentation.widgets.card.common.Description
import com.elkite.warborn.presentation.widgets.card.common.HeaderCard
import com.elkite.warborn.presentation.widgets.card.common.SpellAttributes
import com.elkite.warborn.presentation.widgets.card.common.SwitchContainer
import com.elkite.warborn.presentation.widgets.card.drifter.DrifterBaseStats
import com.elkite.warborn.presentation.widgets.card.drifter.DrifterLinksCard
import com.elkite.warborn.presentation.widgets.card.drifter.DrifterMainStatsMultiplier
import com.elkite.warborn.presentation.widgets.card.drifter.DrifterStats
import com.elkite.warborn.presentation.widgets.card.drifter.DrifterSupportStationBonus
import com.elkite.warborn.presentation.widgets.icons.DrifterIcon
import com.elkite.warborn.presentation.widgets.icons.DrifterPassiveIcon
import com.elkite.warborn.presentation.widgets.icons.DrifterSpellIcon

@Composable
fun ColumnScope.DrifterCard(
    drifter: Drifter?
) {
    if (drifter == null) return
    HeaderCard(
        title = drifter.name,
        subtitle = null,
        icon = {
            DrifterIcon(
                modifier = Modifier.spellBorder(
                    isSelected = true,
                    selectedBrush = WarborneColorTheme.legendaryBrush,
                    selectedBorderWidth = 1.dp
                ).size(64.dp),
                drifterId = drifter.gameId
            )
        }
    )
    SwitchContainer(
        title = "Drifter's details",
    ) {
        DrifterBaseStats(drifter.baseStats)
        DrifterMainStatsMultiplier(drifter.statsMultiplier)
        DrifterLinksCard(drifter.links)
        DrifterSupportStationBonus(drifter.bonus)
        DrifterStats(drifter.stats)
    }
    DrifterSpell(
        spell = drifter.spell,
        drifter = drifter,
    )
    DrifterSpell(
        spell = drifter.passive,
        drifter = drifter,
    )

}

@Composable
private fun ColumnScope.DrifterSpell(
    spell: ISpell,
    drifter: Drifter,
) {
    HeaderCard(
        title = spell.spellName,
        subtitle = spell.type.name,
        icon = {
            if (spell.type == SpellType.skill)
                DrifterSpellIcon(
                    modifier = Modifier.spellBorder().size(48.dp),
                    drifter = drifter
                )
            else
                DrifterPassiveIcon(
                    modifier = Modifier.spellBorder().size(48.dp),
                    drifter = drifter
                )
        }
    )
    SpellAttributes(
        manaCost = spell.manaCost,
        cooldown = spell.cooldown,
        range = spell.castingRange,
    )
    Spacer(Modifier.size(16.dp))
    Description(spell.description)
    Spacer(Modifier.size(16.dp))
}
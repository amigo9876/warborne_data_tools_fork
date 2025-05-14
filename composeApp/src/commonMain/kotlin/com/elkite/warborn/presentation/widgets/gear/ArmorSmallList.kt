
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearStats
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneTheme
import com.elkite.warborn.presentation.widgets.gear.ArmorImage
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCardRow

@Composable
fun ArmorSmallList(
    modifier: Modifier = Modifier,
    spells: HashMap<GearStats, List<Spell>>,
    gearType: GearType,
    columnCount: Int = 1,
    onSpellClick: (Spell) -> Unit,
) {
    val selectedGearStats = remember { mutableStateOf(GearStats.STR) }

    Row(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.Fixed(columnCount),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(spells.keys.toList()) { gearStats ->
                ArmorCategorySmallListItem(
                    gearStats = gearStats,
                    gearType = gearType,
                    onCategoryClick = {
                        selectedGearStats.value = gearStats
                    },
                )
            }
        }
        Spacer(Modifier.size(8.dp))
        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.Fixed(columnCount),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            val filteredSpells = spells[selectedGearStats.value]

            items(items = filteredSpells ?: listOf()) { spell ->
                ArmorSmallListItem(
                    spell = spell,
                    onSpellClick = onSpellClick,
                )
            }
        }
    }
}

@Composable
private fun ArmorCategorySmallListItem(
    gearStats: GearStats,
    gearType: GearType,
    onCategoryClick: (GearStats) -> Unit,
) {
    Card(
        modifier = Modifier.size(64.dp).border(
            width = 1.dp,
            color = WarborneTheme.borderSkillColor,
            shape = RectangleShape,
        )
            .clickable {
                onCategoryClick(gearStats)
            },
        backgroundColor = WarborneTheme.textBackgroundColor,
        content = {
            ArmorImage(
                gearStats = gearStats,
                gearType = gearType,
                modifier = Modifier.size(64.dp)
            )
        }
    )



//    GearStylizedCard(
//        onClick = {
//            onCategoryClick(gearStats)
//        },
//        composable = {
//            ArmorImage(
//                gearStats = gearStats,
//                gearType = gearType,
//                modifier = Modifier.size(64.dp)
//            )
//        },
//        modifier = Modifier.size(64.dp)
//    )

}

@Composable
private fun ArmorSmallListItem(
    spell: Spell,
    onSpellClick: (Spell) -> Unit,
) {
    GearStylizedCardRow(
        onClick = {
            onSpellClick(spell)
        },
        text = spell.gearName ?: "",
        composable = {
            ArmorImage(
                spell = spell,
                modifier = Modifier.size(64.dp)
            )
        }
    )
}
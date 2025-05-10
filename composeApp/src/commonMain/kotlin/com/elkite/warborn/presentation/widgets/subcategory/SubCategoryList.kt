package com.elkite.warborn.presentation.widgets.subcategory

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun SubCategoryList(
    modifier: Modifier = Modifier,
    entries: List<GearType>,
    onClick: (GearType) -> Unit,
) {
    Column {
        Card {
            Column(modifier = modifier.verticalScroll(rememberScrollState())) {
                entries
                    .forEach { gearType ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    onClick(gearType)
                                }
                        ) {
                            Icon(
                                painter = painterResource(IconMap.getWeaponIcon(gearType)),
                                contentDescription = "Home",
                                modifier = Modifier.size(64.dp),
                                tint = Color.Unspecified
                            )
                        }
                    }
            }
        }
    }
}
package com.elkite.warborn.presentation.widgets.card.drifter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.drifter.Link
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.icons.DrifterIcon
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

@Composable
fun DrifterLinksCard(links: List<Link> ) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
        GearStylizedTextTitle(text = "Links")
        Divider(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
            color = WarborneColorTheme.borderSkillColor,
            thickness = 1.dp
        )
       links.forEach {
            Column {
                GearStylizedTextTitle(
                    text = it.name,
                    style = MaterialTheme.typography.h5
                )
                Spacer(Modifier.size(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    it.driftersId.forEach {
                        DrifterIcon(
                            drifterId = it
                        )
                    }
                }
                Spacer(Modifier.size(8.dp))
                GearStylizedText(
                    text = it.description,
                    color = WarborneColorTheme.textDescriptionColor,
                    style = MaterialTheme.typography.body1
                )
                Spacer(Modifier.size(16.dp))
            }
        }
    }
}
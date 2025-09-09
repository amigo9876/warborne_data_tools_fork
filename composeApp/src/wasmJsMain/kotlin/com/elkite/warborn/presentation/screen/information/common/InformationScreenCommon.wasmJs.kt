package com.elkite.warborn.presentation.screen.information.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.screen.main.MainScreenModel
import com.elkite.warborn.presentation.widgets.utils.ClickableText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedCard
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText

@Composable
actual fun InformationScreenCommon(state: MainScreenModel.BuildScreenState.Success) {
    GearStylizedCard(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            GearStylizedText(text = "Feel free to report any issue or suggestion on the following links:")
            Row {
                GearStylizedText(text = "Discord : ")
                ClickableText("https://discord.gg/xQHwDzRh67")
            }
            Spacer(Modifier.size(16.dp))
            Row {
                GearStylizedText(text = "Source code : ")
                ClickableText("https://github.com/ElKite/warborne_data_tools")
            }
            Spacer(Modifier.size(16.dp))
            Row {
                GearStylizedText(text = "Data code : ")
                ClickableText("https://github.com/ElKite/warborne-data-json")
            }
        }
    }
}
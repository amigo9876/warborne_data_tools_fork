package com.elkite.warborn.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen

class TreeScreen : Screen {

    @Composable
    override fun Content() {
        Column {
            Text(
                text = "TO COME : FROST HOLY CURSE \n" +
                       "APPLY LAST PATCHES UPDATE \n" +
                        "WINDOW RESIZING\n" +
                        "BETTER UI\n" +
                        "CONSUMABLES \n" +
                        "MODS \n " +
                        "LINKS",
                color = Color.LightGray
            )
        }
    }
}
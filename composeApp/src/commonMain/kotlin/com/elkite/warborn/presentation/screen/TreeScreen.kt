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
                text = "Coming later....",
                color = Color.LightGray
            )
        }
    }
}
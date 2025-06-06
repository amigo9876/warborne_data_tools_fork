package com.elkite.warborn.presentation.tab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import cafe.adriel.voyager.transitions.SlideTransition
import com.elkite.warborn.presentation.screen.patch.PatchScreen


object ThirdTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Build"
            val icon = rememberVectorPainter(Icons.Default.Notifications)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(PatchScreen()) {
            SlideTransition(it)
        }
    }
}
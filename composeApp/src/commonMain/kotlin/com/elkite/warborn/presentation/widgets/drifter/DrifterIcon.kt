package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrifterIcon(
    modifier: Modifier = Modifier.size(48.dp),
    drifterId: String?
) {
    Image(
        painter = painterResource(
            IconMap.getDrifterIcon(
                drifterId
            )
        ),
        contentDescription = "Drifter's Icon",
        modifier = modifier,
    )
}
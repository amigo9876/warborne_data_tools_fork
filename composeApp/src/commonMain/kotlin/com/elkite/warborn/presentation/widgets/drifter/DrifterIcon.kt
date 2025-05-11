package com.elkite.warborn.presentation.widgets.drifter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrifterIcon(
    modifier: Modifier = Modifier.size(48.dp),
    drifter: Drifter
) {
    Image(
        painter = painterResource(
            IconMap.getDrifterIcon(
                drifter
            )
        ),
        contentDescription = "Drifter's Icon",
        modifier = modifier,
    )
}
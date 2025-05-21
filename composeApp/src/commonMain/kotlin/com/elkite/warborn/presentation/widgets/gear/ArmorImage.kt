package com.elkite.warborn.presentation.widgets.gear

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.GearType
import com.elkite.warborn.util.IconMap
import org.jetbrains.compose.resources.painterResource

@Composable
fun ArmorImage(
    modifier: Modifier = Modifier.size(48.dp),
    gearType: GearType,
    gearName: String?,
) {
    gearName?.let {
        if (gearType != GearType.DRIFTER)
            Image(
                modifier = modifier.clip(
                    shape = CircleShape
                ),
                painter = painterResource(
                    IconMap.getArmorIcon(
                        gearType,
                        gearName
                    )
                ),
                contentDescription = "Gear's Icon",
            )
    }
}


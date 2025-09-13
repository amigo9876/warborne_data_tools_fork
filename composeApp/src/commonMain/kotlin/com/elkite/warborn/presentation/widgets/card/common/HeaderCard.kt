package com.elkite.warborn.presentation.widgets.card.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.common.Rarity
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle

@Composable
fun ColumnScope.HeaderCard(
    title: String,
    subtitle: String? = null,
    icon: @Composable () -> Unit,
    rarity: Rarity? = null
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start,
//        modifier = rarity?.let {
//            Modifier.height(64.dp).fillMaxWidth().paint(
//                painter = painterResource(
//                    when (it) {
//                        Rarity.common -> Res.drawable.Img_Tips_QualityLv1
//                        Rarity.uncommon -> Res.drawable.Img_Tips_QualityLv2
//                        Rarity.rare -> Res.drawable.Img_Tips_QualityLv3
//                        Rarity.legendary -> Res.drawable.Img_Tips_QualityLv5
//                        Rarity.epic -> Res.drawable.Img_Tips_QualityLv4
//                    }
//                ),
//                contentScale = ContentScale.FillBounds,
//            )
//        } ?: Modifier
    ) {
        icon()
        Spacer(Modifier.size(16.dp))
        Column {
            GearStylizedTextTitle(text = title)
            if (!subtitle.isNullOrEmpty())
                GearStylizedText(
                    text = subtitle,
                    style = MaterialTheme.typography.caption.copy(
                        fontWeight = FontWeight.ExtraLight,
                    ),
                )
        }
    }
    CardDivider()
}
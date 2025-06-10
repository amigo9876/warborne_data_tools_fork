package com.elkite.warborn.presentation.widgets.tooltip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.elkite.warborn.domain.entities.gear.Gear
import com.elkite.warborn.domain.entities.gear.drifter.Drifter
import com.elkite.warborn.domain.entities.gear.mods.Mod
import com.elkite.warborn.domain.entities.gear.spell.Spell
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.mod.formatDescription
import com.elkite.warborn.presentation.widgets.utils.GearStylizedText
import com.elkite.warborn.presentation.widgets.utils.GearStylizedTextTitle
import com.elkite.warborn.presentation.widgets.utils.MultiPatternHighlightedText


@Composable
fun rememberTooltipState() = remember { TooltipState() }

class TooltipState {
    var isVisible by mutableStateOf(false)
    var gear: Gear? by mutableStateOf(null)
    var position by mutableStateOf(Offset.Zero)

    fun show(gear: Gear, position: Offset) {
        this.gear = gear
        this.position = position
        this.isVisible = true
    }

    fun hide() {
        this.isVisible = false
    }
}

@Composable
fun TooltipBox(
    gear: Gear,
    tooltipState: TooltipState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var componentPosition by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = modifier
            .onGloballyPositioned { coordinates ->
                componentPosition = coordinates.positionInRoot()
            }
            .pointerInput(gear) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        when (event.type) {
                            PointerEventType.Enter -> {
                                tooltipState.show(gear, componentPosition)
                            }

                            PointerEventType.Exit -> {
                                tooltipState.hide()
                            }
                        }
                    }
                }
            }
    ) {
        content()
    }
}

@Composable
fun GearTooltip(
    gear: Gear,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Surface(
        modifier = modifier,
        color = Color.Black.copy(alpha = 0.9f),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = modifier
                .padding(12.dp).verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            GearStylizedTextTitle(
                style = MaterialTheme.typography.h6,
                text = gear.name,
            )
            when (gear) {
                is Spell -> {
                    gear.gearName?.let {
                        GearStylizedText(
                            text = it,
                            style = MaterialTheme.typography.caption.copy(
                                fontWeight = FontWeight.ExtraLight,
                            ),
                        )
                    } ?: GearStylizedText(
                        text = gear.associatedGearType.name.lowercase().capitalize(),
                        style = MaterialTheme.typography.caption.copy(
                            fontWeight = FontWeight.ExtraLight,
                        ),
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    MultiPatternHighlightedText(
                        baseTextStyle = MaterialTheme.typography.body2.copy(color = WarborneColorTheme.textDescriptionColor)
                            .copy(
                                fontFamily = FontFamily.Monospace
                            ),
                        text = gear.description,
                        patternsWithStyles = listOf(
                            Regex("""\[Damage Rate: [^\]]+]""") to SpanStyle(
                                color = WarborneColorTheme.textDamageColor,
                                fontWeight = FontWeight.Bold
                            ),
                            Regex("""\[Healing Rate: [^\]]+]""") to SpanStyle(
                                color = WarborneColorTheme.textHealColor,
                                fontWeight = FontWeight.Bold
                            ),
                            Regex("""\[Target-based Max HP [^\]]+]""") to SpanStyle(
                                color = WarborneColorTheme.textShieldColor,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    )
                }

                is Drifter -> {
                    GearStylizedText(text = gear.spell.description, maxLines = Int.MAX_VALUE)
                }

                is Mod -> {
                    val description =
                        formatDescription(
                            description = gear.description,
                            arguments = gear.arguments
                        )
                    MultiPatternHighlightedText(
                        baseTextStyle = MaterialTheme.typography.body2.copy(color = WarborneColorTheme.textDescriptionColor)
                            .copy(
                                fontFamily = FontFamily.Monospace
                            ),
                        text = description,
                        patternsWithStyles = listOf(
                            Regex("""\[Damage Rate: [^\]]+]]""") to SpanStyle(
                                color = WarborneColorTheme.textDamageColor,
                                fontWeight = FontWeight.Bold
                            ),
                            Regex("""\[Healing Rate: [^\]]+]]""") to SpanStyle(
                                color = WarborneColorTheme.textHealColor,
                                fontWeight = FontWeight.Bold
                            ),
                            Regex("""\[Target-based Max HP [^\]]+]]""") to SpanStyle(
                                color = WarborneColorTheme.textShieldColor,
                                fontWeight = FontWeight.Bold
                            ),
                            Regex("""\[\s*[^a-zA-Z\]]*](?!])""") to SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = WarborneColorTheme.legendaryBorderMidColor
                            )

                        )
                    )
                }
            }
        }
    }
}

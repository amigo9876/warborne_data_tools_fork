package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.elkite.warborn.presentation.theme.WarborneColorTheme

@Composable
fun MultiPatternHighlightedText(
    text: String,
    baseTextStyle: TextStyle,
    patternsWithStyles: List<Pair<Regex, SpanStyle>>
) {
    val baseSpanStyle = baseTextStyle.toSpanStyle()

    val annotatedString = buildAnnotatedString {
        var currentIndex = 0

        val matches = patternsWithStyles.flatMap { (regex, style) ->
            regex.findAll(text).map { matchResult ->
                MatchData(
                    start = matchResult.range.first,
                    end = matchResult.range.last + 1,
                    text = matchResult.value,
                    style = style
                )
            }
        }.sortedBy { it.start }

        for (match in matches) {
            if (currentIndex < match.start) {
                withStyle(style = baseSpanStyle) {
                    append(text.substring(currentIndex, match.start))
                }
            }

            withStyle(style = match.style) {
                append(match.text)
            }

            currentIndex = match.end
        }

        if (currentIndex < text.length) {
            withStyle(style = baseSpanStyle) {
                append(text.substring(currentIndex))
            }
        }
    }

    Text(text = annotatedString, style = baseTextStyle) // applies font size, line height, etc.
}

data class MatchData(val start: Int, val end: Int, val text: String, val style: SpanStyle)


@Composable
fun HighlightedSupportBonus(
    text: String,
    bonusColor: Color = WarborneColorTheme.dexterityColor,
    malusColor: Color = WarborneColorTheme.strengthColor
) {
    MultiPatternHighlightedText(
        text = text,
        baseTextStyle = MaterialTheme.typography.body1.copy(color = WarborneColorTheme.textDescriptionColor)
            .copy(
                fontFamily = FontFamily.Monospace
            ),
        patternsWithStyles = listOf(
            // Highlight +XXXX in green
            Regex("\\+\\d+(\\.\\d+)?%?") to SpanStyle(
                color = bonusColor,
                fontWeight = FontWeight.Bold
            ),
            // Highlight -XXXX in red
            Regex("-\\d+(\\.\\d+)?%?") to SpanStyle(
                color = malusColor,
                fontWeight = FontWeight.Bold
            )
        )
    )
}

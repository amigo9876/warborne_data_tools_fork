package com.elkite.warborn.presentation.widgets.utils

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun MultiPatternHighlightedText(
    text: String,
    baseTextStyle: TextStyle, // <- use full Material style
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


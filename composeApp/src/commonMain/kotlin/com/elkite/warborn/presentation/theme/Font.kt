package com.elkite.warborn.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.elkite.warborn.resources.NanumGothic_Bold
import com.elkite.warborn.resources.NanumGothic_ExtraBold
import com.elkite.warborn.resources.NanumGothic_Regular
import com.elkite.warborn.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun TekoFontFamily() = FontFamily(
    Font(Res.font.NanumGothic_Regular, weight = FontWeight.Light),
    Font(Res.font.NanumGothic_Regular, weight = FontWeight.Normal),
    Font(Res.font.NanumGothic_Regular, weight = FontWeight.Medium),
    Font(Res.font.NanumGothic_Bold, weight = FontWeight.SemiBold),
    Font(Res.font.NanumGothic_ExtraBold, weight = FontWeight.Bold)
)

@Composable
fun TekoTypography() : Typography {
    val fontFamily = TekoFontFamily()
    return Typography(
        h1 = MaterialTheme.typography.h1.copy(fontFamily = fontFamily),
        h2 = MaterialTheme.typography.h2.copy(fontFamily = fontFamily),
        h3 = MaterialTheme.typography.h3.copy(fontFamily = fontFamily),
        h4 = MaterialTheme.typography.h4.copy(fontFamily = fontFamily),
        h5 = MaterialTheme.typography.h5.copy(fontFamily = fontFamily),
        h6 = MaterialTheme.typography.h6.copy(fontFamily = fontFamily),
        subtitle1 = MaterialTheme.typography.subtitle1.copy(fontFamily = fontFamily),
        subtitle2 = MaterialTheme.typography.subtitle2.copy(fontFamily = fontFamily),
        body1 = MaterialTheme.typography.body1.copy(fontFamily = fontFamily),
        body2 = MaterialTheme.typography.body2.copy(fontFamily = fontFamily),
        button = MaterialTheme.typography.button.copy(fontFamily = fontFamily),
        caption = MaterialTheme.typography.caption.copy(fontFamily = fontFamily),
    )
}
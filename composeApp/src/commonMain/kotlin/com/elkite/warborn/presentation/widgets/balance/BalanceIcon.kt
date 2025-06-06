package com.elkite.warborn.presentation.widgets.balance

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.patch_balance.BalanceStatus

@Composable
fun BalanceIcon(
    modifier: Modifier = Modifier,
    balanceStatus: BalanceStatus,
) {
    Text(
        modifier = modifier,
        text = when (balanceStatus) {
            BalanceStatus.balance -> "~"
            BalanceStatus.buff -> "+"
            BalanceStatus.nerf -> "-"
        },
        color = when (balanceStatus) {
            BalanceStatus.balance -> WarborneColorTheme.legendaryBorderMidColor
            BalanceStatus.buff -> WarborneColorTheme.dexterityColor
            BalanceStatus.nerf -> WarborneColorTheme.strengthColor
        },
        style = MaterialTheme.typography.h3
    )
}
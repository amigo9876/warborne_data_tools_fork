package com.elkite.warborn.presentation.widgets.balance

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elkite.warborn.presentation.theme.WarborneColorTheme
import com.elkite.warborn.presentation.widgets.patch_balance.BalanceStatus

@Composable
fun BalanceIcon(
    modifier: Modifier = Modifier.size(32.dp),
    balanceStatus: BalanceStatus,
) {
    Icon(
        modifier = modifier,
        imageVector = when (balanceStatus) {
            BalanceStatus.balance -> Icons.Default.Refresh
            BalanceStatus.buff -> Icons.Default.KeyboardArrowUp
            BalanceStatus.nerf -> Icons.Default.KeyboardArrowDown
        },
        tint = when (balanceStatus) {
            BalanceStatus.balance -> WarborneColorTheme.legendaryBorderMidColor
            BalanceStatus.buff -> WarborneColorTheme.dexterityColor
            BalanceStatus.nerf -> WarborneColorTheme.strengthColor
        },
        contentDescription = null
    )
}
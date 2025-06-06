package com.elkite.warborn.presentation.widgets.patch_balance

import kotlinx.serialization.Serializable

@Serializable
data class Balance(
    val lastUpdate: String,
    val changes: String,
    val status: BalanceStatus
)

enum class BalanceStatus {
    nerf,
    buff,
    balance
}
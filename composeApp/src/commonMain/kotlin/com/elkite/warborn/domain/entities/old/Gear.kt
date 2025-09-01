package com.elkite.warborn.domain.entities.old

import com.elkite.warborn.presentation.widgets.patch_balance.Balance
import kotlinx.serialization.Serializable

@Serializable
open class Gear(
    open val gameId: String,
    open val name: String,
    open val balance: Balance
)
package com.elkite.warborn.util

import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object ConsumableResources {
    fun getConsumable(id: String?): DrawableResource {
        return when(id) {
            "if" -> Res.drawable.error_emoji
            else -> Res.drawable.error_emoji
        }
    }
}
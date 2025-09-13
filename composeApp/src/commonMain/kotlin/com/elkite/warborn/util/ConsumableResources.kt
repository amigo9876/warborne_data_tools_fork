package com.elkite.warborn.util

import com.elkite.warborn.resources.Invincible_Potion
import com.elkite.warborn.resources.Invisible_Range
import com.elkite.warborn.resources.PetrolBomb
import com.elkite.warborn.resources.RebornDevice
import com.elkite.warborn.resources.RecoverRatioHP
import com.elkite.warborn.resources.RecoverRatioHPAndDisperse
import com.elkite.warborn.resources.RecoverRatioHP_Range
import com.elkite.warborn.resources.RecoverRatioHP_Range_Slow
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.equip_food_1
import com.elkite.warborn.resources.equip_food_2
import com.elkite.warborn.resources.equip_food_3
import com.elkite.warborn.resources.equip_food_4
import com.elkite.warborn.resources.equip_food_5
import com.elkite.warborn.resources.equip_medicine_1_1
import com.elkite.warborn.resources.equip_medicine_1_2
import com.elkite.warborn.resources.equip_medicine_1_3
import com.elkite.warborn.resources.equip_medicine_2_1
import com.elkite.warborn.resources.equip_medicine_2_2
import com.elkite.warborn.resources.equip_medicine_2_3
import com.elkite.warborn.resources.equip_medicine_3_1
import com.elkite.warborn.resources.equip_medicine_3_2
import com.elkite.warborn.resources.equip_medicine_3_3
import com.elkite.warborn.resources.equip_medicine_4_1
import com.elkite.warborn.resources.equip_medicine_4_2
import com.elkite.warborn.resources.equip_medicine_4_3
import com.elkite.warborn.resources.equip_medicine_5_1
import com.elkite.warborn.resources.equip_medicine_5_2
import com.elkite.warborn.resources.equip_medicine_5_3
import com.elkite.warborn.resources.equip_medicine_6_1
import com.elkite.warborn.resources.equip_medicine_6_2
import com.elkite.warborn.resources.equip_medicine_6_3
import com.elkite.warborn.resources.equip_medicine_blackhand_2
import com.elkite.warborn.resources.equip_medicine_blackhand_3
import com.elkite.warborn.resources.equip_medicine_iceblock_2
import com.elkite.warborn.resources.equip_medicine_iceblock_3
import com.elkite.warborn.resources.equip_medicine_mass_defen_2
import com.elkite.warborn.resources.equip_medicine_mass_defen_3
import com.elkite.warborn.resources.equip_medicine_voidzone_2
import com.elkite.warborn.resources.equip_medicine_voidzone_3
import com.elkite.warborn.resources.error_emoji
import com.elkite.warborn.resources.fence
import com.elkite.warborn.resources.icon_Stealth
import org.jetbrains.compose.resources.DrawableResource

object ConsumableResources {
    fun getConsumable(id: String?): DrawableResource {
        return when(id) {
            "equip_medicine_1_1" -> Res.drawable.equip_medicine_1_1
            "equip_medicine_1_2" -> Res.drawable.equip_medicine_1_2
            "equip_medicine_1_3" -> Res.drawable.equip_medicine_1_3
            "equip_medicine_2_1" -> Res.drawable.equip_medicine_2_1
            "equip_medicine_2_2" -> Res.drawable.equip_medicine_2_2
            "equip_medicine_2_3" -> Res.drawable.equip_medicine_2_3
            "equip_medicine_3_1" -> Res.drawable.equip_medicine_3_1
            "equip_medicine_3_2" -> Res.drawable.equip_medicine_3_2
            "equip_medicine_3_3" -> Res.drawable.equip_medicine_3_3
            "equip_medicine_4_1" -> Res.drawable.equip_medicine_4_1
            "equip_medicine_4_2" -> Res.drawable.equip_medicine_4_2
            "equip_medicine_4_3" -> Res.drawable.equip_medicine_4_3
            "equip_medicine_5_1" -> Res.drawable.equip_medicine_5_1
            "equip_medicine_5_2" -> Res.drawable.equip_medicine_5_2
            "equip_medicine_5_3" -> Res.drawable.equip_medicine_5_3
            "equip_medicine_6_1" -> Res.drawable.equip_medicine_6_1
            "equip_medicine_6_2" -> Res.drawable.equip_medicine_6_2
            "equip_medicine_6_3" -> Res.drawable.equip_medicine_6_3
            "equip_medicine_iceblock_2" -> Res.drawable.equip_medicine_iceblock_2
            "equip_medicine_iceblock_3" -> Res.drawable.equip_medicine_iceblock_3
            "equip_medicine_blackhand_2" -> Res.drawable.equip_medicine_blackhand_2
            "equip_medicine_blackhand_3" -> Res.drawable.equip_medicine_blackhand_3
            "equip_medicine_mass_defen_2" -> Res.drawable.equip_medicine_mass_defen_2
            "equip_medicine_mass_defen_3" -> Res.drawable.equip_medicine_mass_defen_3
            "icon_Stealth" -> Res.drawable.icon_Stealth
            "fence" -> Res.drawable.fence
            "Invisible_Range" -> Res.drawable.Invisible_Range
            "RebornDevice" -> Res.drawable.RebornDevice
            "RecoverRatioHP" -> Res.drawable.RecoverRatioHP
            "RecoverRatioHP_Range" -> Res.drawable.RecoverRatioHP_Range
            "RecoverRatioHP_Range_Slow" -> Res.drawable.RecoverRatioHP_Range_Slow
            "RecoverRatioHPAndDisperse" -> Res.drawable.RecoverRatioHPAndDisperse
            "PetrolBomb" -> Res.drawable.PetrolBomb
            "Invincible_Potion" -> Res.drawable.Invincible_Potion
            "equip_medicine_voidzone_2" -> Res.drawable.equip_medicine_voidzone_2
            "equip_medicine_voidzone_3" -> Res.drawable.equip_medicine_voidzone_3
            "equip_food_1" -> Res.drawable.equip_food_1
            "equip_food_2" -> Res.drawable.equip_food_2
            "equip_food_3" -> Res.drawable.equip_food_3
            "equip_food_4" -> Res.drawable.equip_food_4
            "equip_food_5" -> Res.drawable.equip_food_5
            else -> Res.drawable.error_emoji
        }
    }
}
package com.elkite.warborn.util

import com.elkite.warborn.resources.ArmorEpic1
import com.elkite.warborn.resources.ArmorEpic2
import com.elkite.warborn.resources.ArmorEpic3
import com.elkite.warborn.resources.ArmorEpic4
import com.elkite.warborn.resources.ArmorEpic5
import com.elkite.warborn.resources.ArmorEpic6
import com.elkite.warborn.resources.ArmorEpic7
import com.elkite.warborn.resources.ArmorEpic8
import com.elkite.warborn.resources.ArmorEpic9
import com.elkite.warborn.resources.ArmorExclusiveLgdr1
import com.elkite.warborn.resources.ArmorExclusiveLgdr2
import com.elkite.warborn.resources.ArmorExclusiveLgdr3
import com.elkite.warborn.resources.ArmorExclusiveLgdr4
import com.elkite.warborn.resources.ArmorExclusiveLgdr5
import com.elkite.warborn.resources.ArmorExclusiveLgdr6
import com.elkite.warborn.resources.ArmorLgdr1
import com.elkite.warborn.resources.ArmorLgdr2
import com.elkite.warborn.resources.ArmorLgdr3
import com.elkite.warborn.resources.ArmorRare1
import com.elkite.warborn.resources.ArmorRare2
import com.elkite.warborn.resources.ArmorRare3
import com.elkite.warborn.resources.ArmorRare4
import com.elkite.warborn.resources.Res
import com.elkite.warborn.resources.WeaponEpic1
import com.elkite.warborn.resources.WeaponEpic2
import com.elkite.warborn.resources.WeaponEpic3
import com.elkite.warborn.resources.WeaponEpic4
import com.elkite.warborn.resources.WeaponEpic5
import com.elkite.warborn.resources.WeaponEpic6
import com.elkite.warborn.resources.WeaponEpic7
import com.elkite.warborn.resources.WeaponEpic8
import com.elkite.warborn.resources.WeaponEpic9
import com.elkite.warborn.resources.WeaponExclusiveLgdr1
import com.elkite.warborn.resources.WeaponExclusiveLgdr10
import com.elkite.warborn.resources.WeaponExclusiveLgdr11
import com.elkite.warborn.resources.WeaponExclusiveLgdr12
import com.elkite.warborn.resources.WeaponExclusiveLgdr2
import com.elkite.warborn.resources.WeaponExclusiveLgdr3
import com.elkite.warborn.resources.WeaponExclusiveLgdr4
import com.elkite.warborn.resources.WeaponExclusiveLgdr5
import com.elkite.warborn.resources.WeaponExclusiveLgdr6
import com.elkite.warborn.resources.WeaponExclusiveLgdr7
import com.elkite.warborn.resources.WeaponExclusiveLgdr8
import com.elkite.warborn.resources.WeaponExclusiveLgdr9
import com.elkite.warborn.resources.WeaponLgdr1
import com.elkite.warborn.resources.WeaponLgdr2
import com.elkite.warborn.resources.WeaponLgdr3
import com.elkite.warborn.resources.WeaponRare1
import com.elkite.warborn.resources.WeaponRare2
import com.elkite.warborn.resources.error_emoji
import org.jetbrains.compose.resources.DrawableResource

object ModResources {
    fun getModIcon(modId: String?) : DrawableResource {
        return when(modId) {
            "ArmorRare1" -> Res.drawable.ArmorRare1
            "ArmorRare2" -> Res.drawable.ArmorRare2
            "ArmorRare3" -> Res.drawable.ArmorRare3
            "ArmorRare4" -> Res.drawable.ArmorRare4
            "WeaponRare1" -> Res.drawable.WeaponRare1
            "WeaponRare2" -> Res.drawable.WeaponRare2
            "ArmorEpic1" -> Res.drawable.ArmorEpic1
            "ArmorEpic2" -> Res.drawable.ArmorEpic2
            "ArmorEpic3" -> Res.drawable.ArmorEpic3
            "ArmorEpic4" -> Res.drawable.ArmorEpic4
            "ArmorEpic5" -> Res.drawable.ArmorEpic5
            "ArmorEpic6" -> Res.drawable.ArmorEpic6
            "ArmorEpic7" -> Res.drawable.ArmorEpic7
            "ArmorEpic8" -> Res.drawable.ArmorEpic8
            "ArmorEpic9" -> Res.drawable.ArmorEpic9
            "ArmorLgdr1" -> Res.drawable.ArmorLgdr1
            "ArmorLgdr2" -> Res.drawable.ArmorLgdr2
            "ArmorLgdr3" -> Res.drawable.ArmorLgdr3
            "ArmorExclusiveLgdr1" -> Res.drawable.ArmorExclusiveLgdr1
            "ArmorExclusiveLgdr2" -> Res.drawable.ArmorExclusiveLgdr2
            "ArmorExclusiveLgdr3" -> Res.drawable.ArmorExclusiveLgdr3
            "ArmorExclusiveLgdr4" -> Res.drawable.ArmorExclusiveLgdr4
            "ArmorExclusiveLgdr5" -> Res.drawable.ArmorExclusiveLgdr5
            "ArmorExclusiveLgdr6" -> Res.drawable.ArmorExclusiveLgdr6
            "WeaponEpic1" -> Res.drawable.WeaponEpic1
            "WeaponEpic2" -> Res.drawable.WeaponEpic2
            "WeaponEpic3" -> Res.drawable.WeaponEpic3
            "WeaponEpic4" -> Res.drawable.WeaponEpic4
            "WeaponEpic5" -> Res.drawable.WeaponEpic5
            "WeaponEpic6" -> Res.drawable.WeaponEpic6
            "WeaponEpic7" -> Res.drawable.WeaponEpic7
            "WeaponEpic8" -> Res.drawable.WeaponEpic8
            "WeaponEpic9" -> Res.drawable.WeaponEpic9
            "WeaponExclusiveLgdr1" -> Res.drawable.WeaponExclusiveLgdr1
            "WeaponExclusiveLgdr2" -> Res.drawable.WeaponExclusiveLgdr2
            "WeaponExclusiveLgdr3" -> Res.drawable.WeaponExclusiveLgdr3
            "WeaponExclusiveLgdr4" -> Res.drawable.WeaponExclusiveLgdr4
            "WeaponExclusiveLgdr5" -> Res.drawable.WeaponExclusiveLgdr5
            "WeaponExclusiveLgdr6" -> Res.drawable.WeaponExclusiveLgdr6
            "WeaponExclusiveLgdr7" -> Res.drawable.WeaponExclusiveLgdr7
            "WeaponExclusiveLgdr8" -> Res.drawable.WeaponExclusiveLgdr8
            "WeaponExclusiveLgdr9" -> Res.drawable.WeaponExclusiveLgdr9
            "WeaponExclusiveLgdr10" -> Res.drawable.WeaponExclusiveLgdr10
            "WeaponExclusiveLgdr11" -> Res.drawable.WeaponExclusiveLgdr11
            "WeaponExclusiveLgdr12" -> Res.drawable.WeaponExclusiveLgdr12
            "WeaponLgdr1" -> Res.drawable.WeaponLgdr1
            "WeaponLgdr2" -> Res.drawable.WeaponLgdr2
            "WeaponLgdr3" -> Res.drawable.WeaponLgdr3
            else -> Res.drawable.error_emoji
        }
    }
}
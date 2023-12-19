package com.farmfinal.app.modules.start.`data`.model

import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.di.MyApp
import kotlin.String

data class StartModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFarmProtection: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_farm_protection)

)

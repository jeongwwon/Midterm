package com.farmfinal.app.modules.diary.`data`.model

import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.di.MyApp
import kotlin.String

data class DatesRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtMON: String? = MyApp.getInstance().resources.getString(R.string.lbl_mon)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEight: String? = MyApp.getInstance().resources.getString(R.string.lbl_82)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFifteen: String? = MyApp.getInstance().resources.getString(R.string.lbl_15)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwentyTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_22)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTwentyNine: String? = MyApp.getInstance().resources.getString(R.string.lbl_29)

)

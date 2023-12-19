package com.farmfinal.app.modules.detail.`data`.model

import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.di.MyApp
import kotlin.String

data class DetailModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHome: String? = MyApp.getInstance().resources.getString(R.string.lbl8)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLIST: String? = MyApp.getInstance().resources.getString(R.string.lbl_list)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDiary: String? = MyApp.getInstance().resources.getString(R.string.lbl9)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt202310317: String? = MyApp.getInstance().resources.getString(R.string.msg_2023_10_31_7)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtKind: String? = MyApp.getInstance().resources.getString(R.string.lbl_wild_boar)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNumber: String? = MyApp.getInstance().resources.getString(R.string.lbl11)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZero: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWhenout: String? = MyApp.getInstance().resources.getString(R.string.lbl12)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWhen: String? = MyApp.getInstance().resources.getString(R.string.lbl_0)

)

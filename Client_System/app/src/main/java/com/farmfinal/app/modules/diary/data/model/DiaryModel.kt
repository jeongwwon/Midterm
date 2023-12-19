package com.farmfinal.app.modules.diary.`data`.model

import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.di.MyApp
import kotlin.String

data class DiaryModel(
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
  var txtNovemberCounter: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_november_2023)

)

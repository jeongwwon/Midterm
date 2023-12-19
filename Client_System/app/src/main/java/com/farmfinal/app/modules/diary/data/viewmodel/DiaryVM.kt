package com.farmfinal.app.modules.diary.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farmfinal.app.modules.diary.`data`.model.DatesRowModel
import com.farmfinal.app.modules.diary.`data`.model.DiaryModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class DiaryVM : ViewModel(), KoinComponent {
  val diaryModel: MutableLiveData<DiaryModel> = MutableLiveData(DiaryModel())

  var navArguments: Bundle? = null

  val datesList: MutableLiveData<MutableList<DatesRowModel>> = MutableLiveData(mutableListOf())
}

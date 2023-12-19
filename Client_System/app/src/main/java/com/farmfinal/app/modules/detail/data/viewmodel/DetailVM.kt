package com.farmfinal.app.modules.detail.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farmfinal.app.modules.detail.`data`.model.DetailModel
import org.koin.core.KoinComponent

class DetailVM : ViewModel(), KoinComponent {
  val detailModel: MutableLiveData<DetailModel> = MutableLiveData(DetailModel())

  var navArguments: Bundle? = null
}

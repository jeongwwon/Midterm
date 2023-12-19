  package com.farmfinal.app.modules.list.data.viewmodel

  import android.content.Context
  import android.graphics.Bitmap
  import android.graphics.drawable.BitmapDrawable
  import android.os.Bundle
  import android.util.Log
  import androidx.activity.viewModels
  import androidx.lifecycle.MutableLiveData
  import androidx.lifecycle.ViewModel
  import com.farmfinal.app.modules.detail.ui.DetailActivity
  import com.farmfinal.app.modules.list.data.model.IntruderListItem
  import com.farmfinal.app.modules.list.data.model.IntruderListResponseModel
  import com.farmfinal.app.modules.list.data.model.ListViewAdapter
  import com.farmfinal.app.modules.list.data.model.ListViewItem
  import com.farmfinal.app.modules.main.data.viewmodel.MainVM
  import com.farmfinal.app.modules.network.ApiService
  import com.squareup.picasso.Picasso
  import retrofit2.Call
  import retrofit2.Callback
  import retrofit2.Response
  import java.io.IOException
  class ListVM(private val apiService: ApiService = ApiService.createDefault()) : ViewModel() {

    // Initialize listModel with an empty list
    var navArguments: Bundle? = null
    private lateinit var adapter: ListViewAdapter

    // Set up the ListView and attach the adapter

  }


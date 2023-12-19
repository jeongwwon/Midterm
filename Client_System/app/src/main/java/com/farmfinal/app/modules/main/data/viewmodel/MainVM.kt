package com.farmfinal.app.modules.main.data.viewmodel

import androidx.lifecycle.ViewModel
import com.farmfinal.app.modules.network.ApiService
import org.koin.core.KoinComponent
import android.os.Bundle
import com.farmfinal.app.modules.main.data.model.MainModel
import com.farmfinal.app.modules.main.data.model.todResponseModel
import com.farmfinal.app.modules.main.data.model.totResponseModel
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainVM(private val apiService: ApiService = ApiService.createDefault()) : ViewModel(),
    KoinComponent {

    val mainModel: MutableLiveData<MainModel> = MutableLiveData(MainModel())
    var navArguments: Bundle? = null

    fun fetchData() {
        // Fetch total count
        apiService.total().enqueue(object : Callback<totResponseModel> {
            override fun onResponse(call: Call<totResponseModel>, response: Response<totResponseModel>) {
                if (response.isSuccessful) {
                    val total = response.body()?.global_count ?: 0
                    // Update MainModel with total count
                    mainModel.value?.total = total
                    mainModel.postValue(mainModel.value)
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<totResponseModel>, t: Throwable) {
                // Handle failure
            }
        })

        // Fetch today count
        apiService.today().enqueue(object : Callback<todResponseModel> {
            override fun onResponse(call: Call<todResponseModel>, response: Response<todResponseModel>) {
                if (response.isSuccessful) {
                    val today = response.body()?.today_count ?: 0
                    // Update MainModel with today count
                    mainModel.value?.today = today
                    mainModel.postValue(mainModel.value)
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<todResponseModel>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
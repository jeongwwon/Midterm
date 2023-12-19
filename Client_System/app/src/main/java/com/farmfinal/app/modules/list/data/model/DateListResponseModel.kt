package com.farmfinal.app.modules.list.data.model
import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName


data class IntruderListItem(
    val image: String,
    val published_date: String,
    val text: String,
)

data class IntruderListResponseModel(
    @SerializedName("intruder_list") val intruderList: List<IntruderListItem>
)


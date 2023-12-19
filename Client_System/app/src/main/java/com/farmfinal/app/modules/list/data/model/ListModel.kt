package com.farmfinal.app.modules.list.`data`.model

import android.graphics.drawable.Drawable
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.di.MyApp
import com.google.gson.annotations.SerializedName
import kotlin.String

data class ListModel(
  @SerializedName("image") val image: Drawable,
  @SerializedName("published_date") val published_date: String,
  @SerializedName("text") val text: String
)


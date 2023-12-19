package com.farmfinal.app.modules.list.ui

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityListBinding
import com.farmfinal.app.modules.detail.ui.DetailActivity
import com.farmfinal.app.modules.diary.ui.DiaryActivity
import com.farmfinal.app.modules.list.data.model.IntruderListItem
import com.farmfinal.app.modules.list.data.model.ListViewAdapter
import com.farmfinal.app.modules.list.data.model.ListViewItem
import com.farmfinal.app.modules.list.data.viewmodel.ListVM
import com.farmfinal.app.modules.main.ui.MainActivity
import com.farmfinal.app.modules.network.ApiService
import com.farmfinal.app.modules.network.ApiService.Companion.BASE_URL
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity(private val apiService: ApiService = ApiService.createDefault()) :
  BaseActivity<ActivityListBinding>(R.layout.activity_list) {
  private val viewModel: ListVM by viewModels<ListVM>()
  private lateinit var adapter: ListViewAdapter

  override fun onCreate(savedInstanceState: Bundle?): Unit {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.listVM = viewModel
    val listView: ListView = findViewById(R.id.listview1)

    // Initialize the adapter
    adapter = ListViewAdapter()
    listView.adapter = adapter

    apiService.getPostList().enqueue(object : Callback<List<IntruderListItem>> {
      override fun onResponse(
        call: Call<List<IntruderListItem>>,
        response: Response<List<IntruderListItem>>
      ) {
        if (response.isSuccessful) {
          // Successful response, handle the data
          val itemList = response.body()
          if (itemList != null) {
            for (intruderItem in itemList) {
              Log.d("Response API", "Published Date: ${intruderItem.published_date}")
              Log.d("Response API", "Text: ${intruderItem.text}")
              Log.d("Response API", "Image URL: ${intruderItem.image}")
              loadImageDrawable(intruderItem.image) { drawable ->
                runOnUiThread {
                  // Add items to the adapter after converting Image URL to Drawable
                  adapter.addItem(drawable, intruderItem.published_date, intruderItem.text)
                }
              }
            }
          }
        } else {
          // Handle unsuccessful response
          // Log.e(TAG, "Failed to get data. Code: ${response.code()}")
        }
      }

      override fun onFailure(call: Call<List<IntruderListItem>>, t: Throwable) {
        // Handle network failure
        // Log.e(TAG, "Network request failed. Error: ${t.message}")
      }
    })
  }

  private fun loadImageDrawable(imageUrl: String, callback: (Drawable?) -> Unit) {
    Glide.with(this)
      .load(imageUrl)
      .listener(object : com.bumptech.glide.request.RequestListener<Drawable> {
        override fun onLoadFailed(
          e: com.bumptech.glide.load.engine.GlideException?,
          model: Any?,
          target: com.bumptech.glide.request.target.Target<Drawable>?,
          isFirstResource: Boolean
        ): Boolean {
          // Handle image loading failure
          callback(null)
          return false
        }

        override fun onResourceReady(
          resource: Drawable?,
          model: Any?,
          target: com.bumptech.glide.request.target.Target<Drawable>?,
          dataSource: com.bumptech.glide.load.DataSource?,
          isFirstResource: Boolean
        ): Boolean {
          // Callback with the loaded Drawable
          callback(resource)
          return false
        }
      })
      .submit()
  }

  override fun setUpClicks(): Unit {
    binding.viewEllipseOne.setOnClickListener {
      val destIntent = MainActivity.getIntent(this, null)
      startActivity(destIntent)
      this.overridePendingTransition(R.anim.left_to_right ,R.anim.left_to_right )
      finish()
    }
    binding.viewEllipseThree.setOnClickListener {
      val destIntent = DiaryActivity.getIntent(this, null)
      startActivity(destIntent)
      this.overridePendingTransition(R.anim.left_to_right ,R.anim.left_to_right )
      finish()
    }

  }

  companion object {
    const val TAG: String = "LIST_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ListActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

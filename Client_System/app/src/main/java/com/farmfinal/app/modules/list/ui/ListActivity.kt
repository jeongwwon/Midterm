package com.farmfinal.app.modules.list.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityListBinding
import com.farmfinal.app.modules.detail.ui.DetailActivity
import com.farmfinal.app.modules.diary.ui.DiaryActivity
import com.farmfinal.app.modules.list.`data`.viewmodel.ListVM
import com.farmfinal.app.modules.main.ui.MainActivity
import kotlin.String
import kotlin.Unit

class ListActivity : BaseActivity<ActivityListBinding>(R.layout.activity_list) {
  private val viewModel: ListVM by viewModels<ListVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.listVM = viewModel
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
    binding.btnDate.setOnClickListener {
      val destIntent = DetailActivity.getIntent(this, null)
      startActivity(destIntent)
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

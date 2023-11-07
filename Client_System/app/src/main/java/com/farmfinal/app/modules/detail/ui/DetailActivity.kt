package com.farmfinal.app.modules.detail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityDetailBinding
import com.farmfinal.app.modules.detail.`data`.viewmodel.DetailVM
import com.farmfinal.app.modules.diary.ui.DiaryActivity
import com.farmfinal.app.modules.main.ui.MainActivity
import kotlin.String
import kotlin.Unit

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {
  private val viewModel: DetailVM by viewModels<DetailVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.detailVM = viewModel
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
    const val TAG: String = "DETAIL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DetailActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

package com.farmfinal.app.modules.main.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityMainBinding
import com.farmfinal.app.modules.diary.ui.DiaryActivity
import com.farmfinal.app.modules.list.ui.ListActivity
import com.farmfinal.app.modules.main.`data`.viewmodel.MainVM
import kotlin.String
import kotlin.Unit

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
  private val viewModel: MainVM by viewModels<MainVM>()

  override fun onInitialized(): Unit {
    viewModel.fetchData()
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.mainVM = viewModel
    binding.lifecycleOwner = this
  }

  override fun setUpClicks(): Unit {
    binding.viewEllipseThree.setOnClickListener {
      val destIntent = DiaryActivity.getIntent(this, null)
      startActivity(destIntent)
      this.overridePendingTransition(R.anim.left_to_right ,R.anim.left_to_right )
      finish()
    }
    binding.viewEllipseTwo.setOnClickListener {
      val destIntent = ListActivity.getIntent(this, null)
      startActivity(destIntent)
      this.overridePendingTransition(R.anim.left_to_right ,R.anim.left_to_right )
      finish()
    }
  }

  companion object {
    const val TAG: String = "MAIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MainActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

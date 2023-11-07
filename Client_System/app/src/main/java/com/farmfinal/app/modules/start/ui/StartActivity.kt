package com.farmfinal.app.modules.start.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityStartBinding
import com.farmfinal.app.modules.login.ui.LoginActivity
import com.farmfinal.app.modules.signup.ui.SignupActivity
import com.farmfinal.app.modules.start.`data`.viewmodel.StartVM
import kotlin.String
import kotlin.Unit

class StartActivity : BaseActivity<ActivityStartBinding>(R.layout.activity_start) {
  private val viewModel: StartVM by viewModels<StartVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.startVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btn1.setOnClickListener {
      val destIntent = SignupActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "START_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, StartActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

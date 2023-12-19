package com.farmfinal.app.modules.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivityLoginBinding
import com.farmfinal.app.modules.login.data.viewmodel.LoginVM
import com.farmfinal.app.modules.main.ui.MainActivity
import com.farmfinal.app.modules.start.ui.StartActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // ... (your existing initialization code)
    // Observe the LiveData for navigation
    viewModel.navigateToMainActivity.observe(this, Observer { shouldNavigate ->
      if (shouldNavigate == true) {
        // Using coroutine to introduce a delay
        GlobalScope.launch(Dispatchers.Main) { // 5000 milliseconds (5 seconds) delay
          val destIntent = MainActivity.getIntent(this@LoginActivity, null)
          startActivity(destIntent)
        }
      }
    })
  }
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val txtID = binding.editText1.text.toString()
      val txtPassword = binding.editText2.text.toString()
      viewModel.updateLoginData(txtID, txtPassword)
          val destIntent = MainActivity.getIntent(this, null)
          startActivity(destIntent)
        }
    }

  companion object {
    const val TAG: String = "LOGIN_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

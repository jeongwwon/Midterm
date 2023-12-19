package com.farmfinal.app.modules.signup.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.farmfinal.app.R
import com.farmfinal.app.appcomponents.base.BaseActivity
import com.farmfinal.app.databinding.ActivitySignupBinding
import com.farmfinal.app.modules.signup.`data`.viewmodel.SignupVM
import com.farmfinal.app.modules.start.ui.StartActivity
import androidx.appcompat.app.AlertDialog
import kotlin.String
import kotlin.Unit
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignupActivity :  BaseActivity<ActivitySignupBinding>(R.layout.activity_signup) {
  private val viewModel: SignupVM by viewModels<SignupVM>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // ... (your existing initialization code)
    // Observe the LiveData for navigation
    viewModel.navigateToStartActivity.observe(this, Observer { shouldNavigate ->
      if (shouldNavigate == true) {
        showSuccessModal()
        // Using coroutine to introduce a delay
        GlobalScope.launch(Dispatchers.Main) {
          delay(5000) // 5000 milliseconds (5 seconds) delay
          val destIntent = StartActivity.getIntent(this@SignupActivity, null)
          startActivity(destIntent)
        }
      }
    })
  }
  private fun showSuccessModal() {
    // Implement the logic to show your success modal
    // You can use AlertDialog, DialogFragment, or any other UI component
    // to display a modal indicating successful signup.
    // For example:
    val alertDialog = AlertDialog.Builder(this)
      .setTitle("회원가입 상태창")
      .setMessage("회원가입 성공!")
      .setPositiveButton("OK") { dialog, _ ->
        dialog.dismiss()
      }
      .create()

    alertDialog.show()
  }
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signupVM = viewModel

  }

  override fun setUpClicks(): Unit {
    binding.btn.setOnClickListener {
      val txtID = binding.editText1.text.toString()
      val txtEmail = binding.editText2.text.toString()
      val txtPassword = binding.editText3.text.toString()

      viewModel.updateSignupData(txtID, txtEmail, txtPassword)

      val destIntent = StartActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGNUP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignupActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
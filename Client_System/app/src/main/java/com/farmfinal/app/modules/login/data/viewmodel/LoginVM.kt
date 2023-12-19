package com.farmfinal.app.modules.login.data.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farmfinal.app.modules.login.data.model.LoginModel
import com.farmfinal.app.modules.login.data.model.loginRequest
import com.farmfinal.app.modules.login.data.model.ResponseModel2
import com.farmfinal.app.modules.network.ApiService
import com.farmfinal.app.modules.signup.data.model.SignUpRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginVM(private val apiService: ApiService = ApiService.createDefault()) : ViewModel() {

  private val _navigateToMainActivity = MutableLiveData<Boolean>()
  val navigateToMainActivity: LiveData<Boolean>
    get() = _navigateToMainActivity

  private val _loginModel = MutableLiveData<LoginModel>()
  val loginModel: LiveData<LoginModel>
    get() = _loginModel

  // LiveData for observing API response
  private val _responseLiveData = MutableLiveData<ResponseModel2>()
  val responseLiveData: LiveData<ResponseModel2>
    get() = _responseLiveData

  var navArguments: Bundle? = null

  fun updateLoginData(txtUsername: String, txtPassword: String) {
    val updatedModel = LoginModel(
      username = txtUsername,
      password = txtPassword
    )
    _loginModel.value = updatedModel
  }

  // Function to perform login
  fun login() {
    Log.d("LoginActivity", "Login button clicked")
    val loginrequest = loginRequest(
      username = "palatino",
      password = "jj0516@124"
    )
    Log.d("LoginVM", "request: $loginrequest")

    if (loginrequest != null) {
      val call = apiService.login(loginrequest)
      Log.d("LoginVM", "call: $call")

      call.enqueue(object : Callback<ResponseModel2> {
        override fun onResponse(
          call: Call<ResponseModel2>,
          response: Response<ResponseModel2>
        ) {
          Log.d("LoginVM", "enqueue method called")
          if (response.isSuccessful) {
            Log.d("LoginVM", "Response is successful")
            val responseBody = response.body()
            if (responseBody != null) {
              Log.d("LoginVM", "Response body: $responseBody")

              _navigateToMainActivity.value = true

              // Update LiveData with modified response
              // Handle successful login
              // You may update your UI or perform other actions here
            } else {
              Log.d("LoginVM", "Response body is null")
              // Handle the case where the response body is null
            }
          } else {
            Log.d(
              "LoginVM",
              "Response is not successful. Code: ${response.code()}, Message: ${response.message()}"
            )
            // Handle error
            // You may show an error message or perform other error handling here
          }
        }

        override fun onFailure(call: Call<ResponseModel2>, t: Throwable) {
          Log.e("LoginVM", "Call failed: ${t.message}")
        }
      })
    } else {
      Log.e("LoginVM", "LoginModel is null")
      // Handle the case where the LoginModel is null
    }
  }
}

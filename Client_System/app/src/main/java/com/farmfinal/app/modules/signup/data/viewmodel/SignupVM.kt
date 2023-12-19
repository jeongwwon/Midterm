package com.farmfinal.app.modules.signup.`data`.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.farmfinal.app.modules.signup.`data`.model.SignupModel
import org.koin.core.KoinComponent
import com.farmfinal.app.modules.signup.data.model.SignUpRequest
import com.farmfinal.app.modules.network.ApiClient
import com.farmfinal.app.modules.signup.data.model.ResponseModel
import com.farmfinal.app.modules.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.farmfinal.app.modules.start.ui.StartActivity
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity


class SignupVM(private val apiService: ApiService = ApiService.createDefault()) : ViewModel(), KoinComponent {
  private val _navigateToStartActivity = MutableLiveData<Boolean>()
  val navigateToStartActivity: LiveData<Boolean>
    get() = _navigateToStartActivity


  private val _signupModel = MutableLiveData<SignupModel>()
  val signupModel: LiveData<SignupModel>
    get() = _signupModel
  var navArguments: Bundle? = null

  // LiveData for observing API response
  private val _responseLiveData = MutableLiveData<ResponseModel>()
  val responseLiveData: LiveData<ResponseModel>
    get() = _responseLiveData

  fun updateSignupData(txtID: String, txtEmail: String, txtPassword: String) {
    val updatedModel = SignupModel(
      txtID = txtID,
      txtEmail = txtEmail,
      txtPassword = txtPassword
    )
    _signupModel.value = updatedModel
  }
  // Function to perform signup
  fun signUp() {
    Log.d("SignupActivity", "SignUp button clicked")
    val signUpRequest = SignUpRequest(
      username = "palatino",
      email = "abcd@khu.ac.kr",
      password = "jj0516@124"
    )
    val call = apiService.signUp(signUpRequest)
    Log.d("SignupVM", "request: $signUpRequest")
    Log.d("SignupVM", "call: $call")

    call.enqueue(object : Callback<ResponseModel> {
      override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
        Log.d("SignupVM", "enqueue method called")
        if (response.isSuccessful) {
          Log.d("SignupVM", "Response is successful")
          val responseBody = response.body()
          if (responseBody != null) {
            Log.d("SignupVM", "Response body: $responseBody")

            _navigateToStartActivity.value = true
            val modifiedResponse = responseBody.copy(issuccess = true)
            _responseLiveData.value = modifiedResponse
          // Update LiveData with modified response
            // Handle successful signup
            // You may update your UI or perform other actions here
          } else {
            Log.d("SignupVM", "Response body is null")
            // Handle the case where the response body is null
          }
        }else {
          Log.d("SignupVM", "Response is not successful. Code: ${response.code()}, Message: ${response.message()}")
          // Handle error
          // You may show an error message or perform other error handling here
        }
      }

      override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
        Log.e("SignupVM", "Call failed: ${t.message}")
      }
    })
  }
}


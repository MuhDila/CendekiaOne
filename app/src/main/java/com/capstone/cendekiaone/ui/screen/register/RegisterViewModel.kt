package com.capstone.cendekiaone.ui.screen.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.cendekiaone.data.remote.response.DataResponse
import com.capstone.cendekiaone.data.remote.retforit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO : Data ga bisa masuk ke API :(
class RegisterViewModel(private val apiService: ApiService) : ViewModel() {
    // LiveData to observe loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // LiveData to observe the registration result
    private val _registrationResult = MutableLiveData<RegistrationResult>()
    val registrationResult: LiveData<RegistrationResult> = _registrationResult

    // Sealed class to represent different registration results
    sealed class RegistrationResult {
        data class Success(val message: String) : RegistrationResult()
        data class Error(val errorMessage: String) : RegistrationResult()
        object NetworkError : RegistrationResult()
    }

    // Function to initiate the registration process
    fun register(name: String, email: String, password: String) {
        _isLoading.value = true
        apiService.register(name, email, password).enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                _isLoading.value = false
                val responseBody = response.body()
                if (response.isSuccessful && responseBody?.message == "User Created") {
                    // Registration is successful
                    _registrationResult.value = RegistrationResult.Success(responseBody.message)
                } else {
                    // Registration failed
                    _registrationResult.value = RegistrationResult.Error("Registration failed")
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                _isLoading.value = false
                // Network error
                _registrationResult.value = RegistrationResult.NetworkError
            }
        })
    }
}
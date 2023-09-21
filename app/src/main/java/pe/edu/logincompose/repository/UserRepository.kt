package pe.edu.logincompose.repository

import pe.edu.logincompose.data.remote.ApiClient
import pe.edu.logincompose.data.model.UserRequest
import pe.edu.logincompose.data.model.UserResponse
import pe.edu.logincompose.data.remote.UserService
import pe.edu.logincompose.utils.Result

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(val userService: UserService = ApiClient.getUserService()) {

    fun register(userRequest: UserRequest, callback: (Result<UserResponse>) -> Unit) {
        val register = userService.register(userRequest)

        register.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {

                    val userResponse = response.body()!!
                    callback(Result.Success(userResponse))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val message = t.message!!
                callback(Result.Error(message))
            }

        })
    }
}
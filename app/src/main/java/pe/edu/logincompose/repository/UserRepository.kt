package pe.edu.logincompose.repository

import pe.edu.logincompose.data.remote.ApiClient
import pe.edu.logincompose.data.remote.UserRequest
import pe.edu.logincompose.data.remote.UserResponse
import pe.edu.logincompose.data.remote.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(val userService: UserService = ApiClient.getUserService()) {

    fun register(userRequest: UserRequest) {
        val register = userService.register(userRequest)

        register.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
package pe.edu.logincompose.data.remote

import pe.edu.logincompose.data.model.UserRequest
import pe.edu.logincompose.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("users")
    fun register(@Body userRequest: UserRequest): Call<UserResponse>

}
package pe.edu.logincompose.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://plain-marbled-muskox.glitch.me/"

    private var userService: UserService? = null

    fun getUserService(): UserService {
        if (userService == null){
            val retrofit = Retrofit
                .Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return userService as UserService
    }
}
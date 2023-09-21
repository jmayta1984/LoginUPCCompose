package pe.edu.logincompose.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://plain-marbled-muskox.glitch.me/"

    private const val RICK_MORTY_API_BASE_URL = "https://rickandmortyapi.com/api/"

    private var userService: UserService? = null
    private var characterService: CharacterService? = null


    fun getUserService(): UserService {
        if (userService == null) {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            userService = retrofit.create(UserService::class.java)
        }
        return userService as UserService
    }

    fun getCharacterService(): CharacterService {
        if (characterService == null) {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(RICK_MORTY_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            characterService = retrofit.create(CharacterService::class.java)
        }
        return characterService as CharacterService
    }
}
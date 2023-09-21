package pe.edu.logincompose.data.remote

import pe.edu.logincompose.data.model.Character
import pe.edu.logincompose.data.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("character")
    fun getAll(): Call<CharacterResponse>

    @GET("character/{id}")
    fun getById(@Path("id") id: String): Call<Character>
}
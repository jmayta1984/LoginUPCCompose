package pe.edu.logincompose.data.remote

import pe.edu.logincompose.data.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    fun getAll(): Call<CharacterResponse>
}
package pe.edu.logincompose.repository

import pe.edu.logincompose.App
import pe.edu.logincompose.data.local.AppDatabase
import pe.edu.logincompose.data.local.CharacterDao
import pe.edu.logincompose.data.local.CharacterEntity
import pe.edu.logincompose.data.model.Character
import pe.edu.logincompose.data.model.CharacterResponse
import pe.edu.logincompose.data.remote.ApiClient
import pe.edu.logincompose.data.remote.CharacterService
import pe.edu.logincompose.utils.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository(
    private val characterDao: CharacterDao = AppDatabase.getInstance(App.instance).characterDao(),
    private val characterService: CharacterService = ApiClient.getCharacterService()
) {

    fun getAll(callback: (Result<List<Character>>) -> Unit) {
        val getAll = characterService.getAll()

        getAll.enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful) {

                    val characters = response.body()!!.characters

                    characters.forEach {   character ->
                        character.isFavorite = characterDao.getById(character.id) != null
                    }
                    callback(Result.Success(data = response.body()!!.characters ))
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                callback(Result.Error(message = t.localizedMessage!!))
            }

        })
    }

    fun delete(character: Character){
        characterDao.delete(CharacterEntity(character.id))
        character.isFavorite = false
    }

    fun save(character: Character){
        characterDao.save(CharacterEntity(character.id))
        character.isFavorite = true
    }

    fun getById(id: String, callback: (Result<Character>) -> Unit) {
        val getById = characterService.getById(id)

        getById.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (response.isSuccessful) {
                    callback(Result.Success(data = response.body()!!))
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                callback(Result.Error(message = t.localizedMessage!!))
            }
        })
    }
}
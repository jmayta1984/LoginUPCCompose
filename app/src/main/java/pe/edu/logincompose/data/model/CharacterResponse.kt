package pe.edu.logincompose.data.model

import com.google.gson.annotations.SerializedName

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val gender: String,
    val status: String,
    val image: String
)

data class CharacterResponse (
    @SerializedName("results")
    val characters: List<Character>
)

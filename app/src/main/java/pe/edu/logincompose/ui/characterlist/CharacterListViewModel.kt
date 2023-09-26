package pe.edu.logincompose.ui.characterlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.logincompose.data.model.Character
import pe.edu.logincompose.repository.CharacterRepository
import pe.edu.logincompose.utils.Result

class CharacterListViewModel(
    private val characterRepository: CharacterRepository = CharacterRepository()
) : ViewModel() {
    private var _characters = MutableLiveData<List<Character>>()
    val characters get() = _characters
    fun getAll() {
        characterRepository.getAll { result ->
            if (result is Result.Success) {
                _characters.value = result.data!!
            }
        }
    }

    fun delete(character: Character){
        characterRepository.delete(character)

    }

    fun save(character: Character){
        characterRepository.save(character)
    }

}
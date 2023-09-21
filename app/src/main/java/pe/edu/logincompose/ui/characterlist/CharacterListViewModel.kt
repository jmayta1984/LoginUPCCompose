package pe.edu.logincompose.ui.characterlist

import androidx.lifecycle.ViewModel
import pe.edu.logincompose.repository.CharacterRepository

class CharacterListViewModel(
    val characterRepository: CharacterRepository = CharacterRepository()
) : ViewModel() {
}
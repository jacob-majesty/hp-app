package com.majesty.hpapp.ui.character_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majesty.hpapp.data.model.Character
import com.majesty.hpapp.data.repository.HpRepository
import kotlinx.coroutines.launch
data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val error: String? = null
)

class CharacterDetailViewModel(private val repository: HpRepository = HpRepository()) : ViewModel() {

    private val _state = MutableLiveData<CharacterDetailState>()
    val state: LiveData<CharacterDetailState> = _state

    /**
     * Inicia a busca pelo personagem.
     * @param id O ID do personagem a ser buscado.
     */
    fun fetchCharacter(id: String) {
        if (id.isBlank()) {
            _state.value = CharacterDetailState(error = "O ID não pode ser vazio.")
            return
        }

        viewModelScope.launch {
            _state.value = CharacterDetailState(isLoading = true)

            val result = repository.getCharacterById(id)

            result.onSuccess { character ->
                _state.value = CharacterDetailState(character = character)
            }.onFailure { exception ->
                _state.value = CharacterDetailState(error = exception.message ?: "Erro desconhecido na busca.")
            }
        }
    }
}

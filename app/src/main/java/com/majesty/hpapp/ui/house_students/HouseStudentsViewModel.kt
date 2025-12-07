package com.majesty.hpapp.ui.house_students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majesty.hpapp.data.model.Character
import com.majesty.hpapp.data.repository.HpRepository
import kotlinx.coroutines.launch

data class HouseStudentsState(
    val isLoading: Boolean = false,
    val studentsList: List<Character> = emptyList(),
    val error: String? = null
)

class HouseStudentsViewModel(private val repository: HpRepository = HpRepository()) : ViewModel() {

    private val _state = MutableLiveData<HouseStudentsState>()
    val state: LiveData<HouseStudentsState> = _state

    /**
     * Busca os estudantes de uma casa específica.
     * @param houseName O nome da casa (ex: "Gryffindor", "Slytherin").
     */
    fun fetchStudentsByHouse(houseName: String) {
        if (houseName.isBlank()) {
            _state.value = HouseStudentsState(error = "O nome da casa não pode ser vazio.")
            return
        }

        viewModelScope.launch {
            _state.value = HouseStudentsState(isLoading = true)

            val capitalizedHouse = houseName.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            }

            val result = repository.getStudentsByHouse(capitalizedHouse)

            result.onSuccess { students ->
                val filteredStudents = students.filter { it.hogwartsStudent == true }
                _state.value = HouseStudentsState(studentsList = filteredStudents)
            }.onFailure { exception ->
                _state.value = HouseStudentsState(error = exception.message ?: "Falha ao carregar estudantes.")
            }
        }
    }
}
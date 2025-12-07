package com.majesty.hpapp.ui.staff_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.majesty.hpapp.data.model.Character
import com.majesty.hpapp.data.repository.HpRepository
import kotlinx.coroutines.launch

data class StaffListState(
    val isLoading: Boolean = false,
    val staffList: List<Character> = emptyList(),
    val error: String? = null
)

class StaffListViewModel(private val repository: HpRepository = HpRepository()) : ViewModel() {

    private val _state = MutableLiveData<StaffListState>()
    val state: LiveData<StaffListState> = _state

    init {
        fetchStaff()
    }

    private fun fetchStaff() {
        viewModelScope.launch {
            _state.value = StaffListState(isLoading = true)

            val result = repository.getStaff()

            result.onSuccess { staff ->
                val filteredStaff = staff.filter { it.hogwartsStaff == true }
                _state.value = StaffListState(staffList = filteredStaff)
            }.onFailure { exception ->
                _state.value = StaffListState(error = exception.message ?: "Falha ao carregar os professores.")
            }
        }
    }
}
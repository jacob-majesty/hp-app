package com.majesty.hpapp.ui.house_students

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.majesty.hpapp.data.repository.HpRepository

class HouseStudentsViewModelFactory(private val repository: HpRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HouseStudentsViewModel::class.java)) {
            return HouseStudentsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
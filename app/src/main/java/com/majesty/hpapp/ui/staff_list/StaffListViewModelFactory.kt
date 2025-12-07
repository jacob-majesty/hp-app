package com.majesty.hpapp.ui.staff_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.majesty.hpapp.data.repository.HpRepository

class StaffListViewModelFactory(private val repository: HpRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StaffListViewModel::class.java)) {
            return StaffListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
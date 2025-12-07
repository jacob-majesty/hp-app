package com.majesty.hpapp.ui.character_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.majesty.hpapp.data.repository.HpRepository

class CharacterDetailViewModelFactory(private val repository: HpRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterDetailViewModel::class.java)) {
            return CharacterDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
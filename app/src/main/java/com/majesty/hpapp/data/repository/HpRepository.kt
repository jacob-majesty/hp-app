package com.majesty.hpapp.data.repository

import com.majesty.hpapp.data.model.Character
import com.majesty.hpapp.data.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HpRepository {

    private val apiService = RetrofitClient.apiService

   suspend fun getCharacterById(id: String): Result<Character> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getCharacterById(id)

            if (response.isNotEmpty()) {
                Result.success(response.first())
            } else {
                Result.failure(NoSuchElementException("Personagem com ID '$id' não encontrado."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getStaff(): Result<List<Character>> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getHogwartsStaff()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getStudentsByHouse(houseName: String): Result<List<Character>> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getHouseStudents(houseName)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
package com.majesty.hpapp.data.network

import com.majesty.hpapp.data.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface HpApiService {

    @GET("api/character/{id}")
    suspend fun getCharacterById(@Path("id") characterId: String): List<Character>

    @GET("api/characters/staff")
    suspend fun getHogwartsStaff(): List<Character>

    @GET("api/characters/house/{house}")
    suspend fun getHouseStudents(@Path("house") houseName: String): List<Character>
}
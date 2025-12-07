package com.majesty.hpapp.data.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("house")
    val house: String?,

    @SerializedName("staff")
    val staff: Boolean = false,

    @SerializedName("student")
    val student: Boolean = false,

    @SerializedName("hogwartsStudent")
    val hogwartsStudent: Boolean = false,

    @SerializedName("hogwartsStaff")
    val hogwartsStaff: Boolean = false
)
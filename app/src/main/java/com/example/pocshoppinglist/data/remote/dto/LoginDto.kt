package com.example.pocshoppinglist.data.remote.dto

import com.squareup.moshi.Json

data class LoginDto(
    @field:Json(name = "message")
    val message: String = ""
)

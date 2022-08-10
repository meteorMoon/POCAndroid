package com.example.pocshoppinglist.data.remote

import com.example.pocshoppinglist.data.remote.dto.LoginDto
import com.example.pocshoppinglist.data.remote.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ShoppingApi {

    @POST("login")
    suspend fun login(@Body user: UserDto): Response<LoginDto>

    companion object {
        const val BASE_URL = "http://192.168.56.102/"
    }
}
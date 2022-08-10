package com.example.pocshoppinglist.data.repository

import com.example.pocshoppinglist.common.util.Constants
import com.example.pocshoppinglist.common.util.Resource
import com.example.pocshoppinglist.data.mappers.toUserDto
import com.example.pocshoppinglist.data.remote.ShoppingApi
import com.example.pocshoppinglist.domain.model.User
import com.example.pocshoppinglist.domain.repository.LoginRepository
import java.lang.Exception
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: ShoppingApi
) : LoginRepository {
    override suspend fun login(user: User): Resource<String?> {
        val userDto = user.toUserDto()
        return try {
            val response = api.login(userDto)
            Resource.Success(response.headers()[Constants.AUTH_TOKEN])
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error("error api")
        }
    }
}
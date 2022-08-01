package com.example.pocshoppinglist.domain.repository

import com.example.pocshoppinglist.common.util.Resource
import com.example.pocshoppinglist.domain.model.User

interface LoginRepository {
    suspend fun login(user: User): Resource<String?>
}
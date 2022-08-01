package com.example.pocshoppinglist.data.mappers

import com.example.pocshoppinglist.data.remote.dto.UserDto
import com.example.pocshoppinglist.domain.model.User

fun User.toUserDto() = UserDto(
    name = username,
    email = email,
    password = password
)

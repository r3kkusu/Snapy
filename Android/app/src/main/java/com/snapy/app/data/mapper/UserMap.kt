package com.snapy.app.data.mapper

import com.snapy.app.data.remote.dto.UserDto
import com.snapy.app.domain.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        username = username,
        email = email,
        password = password
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        id = id,
        username = username,
        email = email,
        password = password
    )
}
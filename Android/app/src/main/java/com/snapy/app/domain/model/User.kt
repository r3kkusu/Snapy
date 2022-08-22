package com.snapy.app.domain.model

data class User(
    val id: Long,
    var username: String,
    var email: String,
    var password: String
)

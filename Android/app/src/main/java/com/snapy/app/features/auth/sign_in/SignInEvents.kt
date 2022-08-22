package com.snapy.app.features.auth.sign_in

sealed class SignInEvents {
    data class SignIn(val username: String, val password: String) : SignInEvents()
}
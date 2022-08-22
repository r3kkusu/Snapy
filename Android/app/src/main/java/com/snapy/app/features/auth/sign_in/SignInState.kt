package com.snapy.app.features.auth.sign_in

data class SignInState(
    val isLoading: Boolean = false,
    val result: String? = null,
    val error: String = ""
)

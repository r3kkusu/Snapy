package com.snapy.app.domain.usecase

import com.snapy.app.domain.usecase.queries.ValidateAccount

data class AuthUseCase (
    val validate: ValidateAccount
        )
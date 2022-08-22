package com.snapy.app.features.auth.sign_in

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snapy.app.common.Resource
import com.snapy.app.domain.usecase.AuthUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

import kotlinx.coroutines.withContext

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {
    var state by mutableStateOf(SignInState())
    var job : Job? = null

    private fun signIn(username: String, password: String) {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            authUseCase.validate(username, password)
                .collect { result ->
                    withContext(Dispatchers.Main) {
                        when(result) {
                            is Resource.Success -> {
                                result.data?.let {
                                    state = state.copy(result = it)
                                }
                            }
                            is Resource.Error -> Unit
                            is Resource.Loading -> {
                                state = state.copy(isLoading = result.isLoading)
                            }
                        }
                    }
                }
        }
    }

    fun onEvent(event: SignInEvents) {
        when(event) {
            is SignInEvents.SignIn -> {
                signIn(event.username, event.password)
            }
        }
    }
}
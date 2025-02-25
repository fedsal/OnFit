package org.dev.onfit.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.dev.onfit.data.auth.AuthRepository

class SplashViewModel(
    private val authRepository: AuthRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(SplashUiState())
    val uiState: StateFlow<SplashUiState> get() =  _uiState

    init {
        checkRefreshToken()
    }

    fun checkRefreshToken() = viewModelScope.launch(Dispatchers.IO) {
        val refreshToken = authRepository.getRefreshToken()
        if (refreshToken.isNullOrBlank()) {
            _uiState.update { it.copy(goToLogin = true) }
        } else {
            _uiState.update { it.copy(goToHome = true) }
        }
    }
}

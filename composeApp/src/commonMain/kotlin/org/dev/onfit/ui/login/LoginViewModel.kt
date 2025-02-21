package org.dev.onfit.ui.login

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.dev.onfit.data.auth.AuthRepository

class LoginViewModel(
    private val authRepository: AuthRepository,
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> get() =  _uiState

    fun login(username: String, password: String) {
        _uiState.update { it.copy(isLoading = true) }
        // Call the remote data source
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = authRepository.login(username, password)
                if (response.accessToken.isNotBlank()) {
                    authRepository.saveAccessToken(response.accessToken)
                }
                if (!response.refreshToken.isNullOrBlank()) {
                    authRepository.saveRefreshToken(response.refreshToken)
                }
                _uiState.update { it.copy(isLoading = false, loggedIn = true) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

}
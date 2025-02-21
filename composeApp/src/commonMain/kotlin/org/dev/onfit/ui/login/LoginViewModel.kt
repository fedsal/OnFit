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
    private val dataStore: DataStore<Preferences>
): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> get() =  _uiState

    fun login(username: String, password: String, boolean: Boolean) {
        _uiState.update { it.copy(isLoading = true) }
        // Call the remote data source
        viewModelScope.launch(Dispatchers.IO) {
            try {
                authRepository.login(username, password)
                _uiState.update { it.copy(isLoading = false, loggedIn = true) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

}
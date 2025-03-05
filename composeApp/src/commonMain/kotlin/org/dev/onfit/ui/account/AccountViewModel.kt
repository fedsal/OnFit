package org.dev.onfit.ui.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.dev.onfit.data.auth.AuthRepository

class AccountViewModel(
    private val accountRepository: AuthRepository
): ViewModel() {

    private val _sessionClosed = MutableStateFlow(false)
    val sessionClosed: StateFlow<Boolean> get() = _sessionClosed

    fun closeSession() = viewModelScope.launch {
        try {
            accountRepository.logout()
            _sessionClosed.value = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
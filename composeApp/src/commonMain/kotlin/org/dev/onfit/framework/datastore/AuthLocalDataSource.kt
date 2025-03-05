package org.dev.onfit.framework.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.dev.onfit.data.auth.LocalAuthDataSource

class AuthLocalDataSource(
    private val dataStore: DataStore<Preferences>
): LocalAuthDataSource {
    private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
    private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")

    /**
     * Save the refresh token in the local data store
     */
    override suspend fun saveRefreshToken(token: String): Boolean = try {
        dataStore.edit {
            it[REFRESH_TOKEN_KEY] = token
        }
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

    /**
     * Get the refresh token from the local data store
     */
    override suspend fun getRefreshToken(): String? = try {
        dataStore.data.map { it[REFRESH_TOKEN_KEY] }.first()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

    /**
     * Save the access token in the local data store
     */
    override suspend fun saveAccessToken(token: String): Boolean = try {
        dataStore.edit {
            it[ACCESS_TOKEN_KEY] = token
        }
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

    override suspend fun logout(): Boolean = try {
        dataStore.edit {
            it.clear()
        }
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }

    /**
     * Get the access token from the local data store
     */
    override suspend fun getAccessToken(): String? = try {
        dataStore.data.map { it[ACCESS_TOKEN_KEY] }.first()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
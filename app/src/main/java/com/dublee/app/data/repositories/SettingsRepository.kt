package com.dublee.app.data.repositories

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("app_settings")

class SettingsRepository(
    private val context: Context
) {
    private val dataStore = context.dataStore

    private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")
    private val NOTIFICATIONS_ENABLED_KEY = booleanPreferencesKey("notifications_enabled")
    private val MUSIC_PLAYBACK_KEY = booleanPreferencesKey("music_playback")

    val isDarkTheme: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[DARK_THEME_KEY] ?: false
    }
    val isNotificationsEnabled: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[NOTIFICATIONS_ENABLED_KEY] ?: false
    }
    val isMusicPlayback: Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[MUSIC_PLAYBACK_KEY] ?: false
    }

    suspend fun setDarkTheme(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[DARK_THEME_KEY] = enabled
        }
    }

    suspend fun setNotificationsEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[NOTIFICATIONS_ENABLED_KEY] = enabled
        }
    }

    suspend fun setMusicPlayback(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[MUSIC_PLAYBACK_KEY] = enabled
        }
    }
}
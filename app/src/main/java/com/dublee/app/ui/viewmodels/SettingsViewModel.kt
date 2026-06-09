package com.dublee.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dublee.app.data.repositories.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsRepo: SettingsRepository
) : ViewModel() {

    val isDarkTheme = settingsRepo.isDarkTheme.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    val isNotificationsEnabled = settingsRepo.isNotificationsEnabled.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )
    val isMusicPlayback = settingsRepo.isMusicPlayback.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    fun toggleTheme() {
        viewModelScope.launch {
            settingsRepo.setDarkTheme(!isDarkTheme.value)
        }
    }

    fun toggleNotifications() {
        viewModelScope.launch {
            settingsRepo.setNotificationsEnabled(!isNotificationsEnabled.value)
        }
    }

    fun toggleMusic() {
        viewModelScope.launch {
            settingsRepo.setMusicPlayback(!isMusicPlayback.value)
        }
    }
}
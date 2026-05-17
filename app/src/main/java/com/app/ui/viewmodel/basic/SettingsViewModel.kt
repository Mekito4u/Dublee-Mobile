package com.app.ui.viewmodel.basic

import androidx.lifecycle.ViewModel
import com.app.data.repositories.profile.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    private val _notificationEnabled = MutableStateFlow(false)
    val notificationEnabled = _notificationEnabled.asStateFlow()

    private val _isLightTheme = MutableStateFlow(true)
    val isLightTheme = _isLightTheme.asStateFlow()

    init {
        loadSettings()
    }

    fun loadSettings() {
        _notificationEnabled.value = settingsRepository.isNotificationsEnabled()
        _isLightTheme.value = settingsRepository.isLightMode()
    }

    fun setTheme(isLightTheme: Boolean) {
        settingsRepository.setTheme(isLightTheme)
        _isLightTheme.value = isLightTheme
    }

    fun setNotification(enabled: Boolean) {
        settingsRepository.setNotificationsEnabled(enabled)
        _notificationEnabled.value = enabled
    }
}

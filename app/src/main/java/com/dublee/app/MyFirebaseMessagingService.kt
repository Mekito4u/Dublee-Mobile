package com.dublee.app

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.dublee.app.data.repositories.OptionRepository
import com.dublee.app.data.repositories.SettingsRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class MyFirebaseMessagingService() : FirebaseMessagingService() {
    private val optionRepository by lazy { OptionRepository() }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val areNotificationsEnabled = runBlocking {
            SettingsRepository(applicationContext).isNotificationsEnabled.first()
        }
        if (!areNotificationsEnabled) return

        val title = remoteMessage.notification?.title ?: "Dublee"
        var body = remoteMessage.notification?.body ?: "Новый мэтч!"

        val regex = Regex("\\d+")
        val matchResult = regex.find(body)
        if (matchResult != null) {
            val optionId = matchResult.value.toIntOrNull()
            optionId?.let {
                val option = optionRepository.getOptionById(it)
                val optionTitle = option?.title ?: it.toString()
                body = body.replace(it.toString(), optionTitle)
            }
        }

        showNotification(title, body)
    }

    private fun showNotification(title: String, body: String) {
        val channelId = "dublee_channel"
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, "Dublee", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.ic_dialog_info)
            .build()
        manager.notify(System.currentTimeMillis().toInt(), notification)
    }
}
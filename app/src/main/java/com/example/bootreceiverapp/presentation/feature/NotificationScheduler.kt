package com.example.bootreceiverapp.presentation.feature

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import javax.inject.Inject


class NotificationScheduler @Inject constructor(
    private val context: Context
) {
    fun scheduleNotification() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(BOOT_NOTIFICATION)
        val pending = PendingIntent.getBroadcast(
            context, 15,
            intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            ALARM_INTERVAL,
            pending
        )
    }

    companion object {
        const val BOOT_NOTIFICATION = "BOOT_NOTIFICATION"
        const val ALARM_INTERVAL = 1000 * 60 * 15L //15 minutes in millis
    }
}
package com.example.bootreceiverapp.presentation.feature

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import javax.inject.Inject


class NotificationDispatcher @Inject constructor(
    private val context: Context
) {

    fun showNotification(timeStamp: String) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var notificationBuilder: Notification.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                "default_channel",
                "boot_channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(notificationChannel)
            notificationBuilder = Notification.Builder(context, notificationChannel.id)
        } else {
            @Suppress("DEPRECATION")
            // builder without channel id uses for Nougat and less
            notificationBuilder = Notification.Builder(context)
        }

        val notification = notificationBuilder.setContentTitle("Boot Completed")
            .setContentText("Time: $timeStamp")
            .build()

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            notificationManager.notify(123, notification)
        } else {
            //perm request
        }
    }
}


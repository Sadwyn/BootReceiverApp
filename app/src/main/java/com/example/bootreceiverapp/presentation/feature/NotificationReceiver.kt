package com.example.bootreceiverapp.presentation.feature

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.bootreceiverapp.data.Repository
import javax.inject.Inject

class NotificationReceiver @Inject constructor(
    private val notificationDispatcher: NotificationDispatcher,
    private val repository: Repository
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val boots = repository.getBoots()
        if (boots.isEmpty()) {
            notificationDispatcher.showNotification("No boots detected")
        } else if (boots.size == 1) {
            notificationDispatcher.showNotification(
                "The boot was detected with the timestamp =\n" +
                        "${boots[0].date}."
            )
        } else {
            val lastBoot = boots[boots.size - 1].date
            val preLastBoot = boots[boots.size - 2].date
            val delta = lastBoot.toLong() - preLastBoot.toLong()
            notificationDispatcher.showNotification(
                "Last boots time delta =\n" + "${delta}."
            )
        }
    }
}
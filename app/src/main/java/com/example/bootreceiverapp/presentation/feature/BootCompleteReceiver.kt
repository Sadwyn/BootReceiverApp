package com.example.bootreceiverapp.presentation.feature

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.bootreceiverapp.data.BootModel
import com.example.bootreceiverapp.data.Repository
import java.util.concurrent.Executors
import javax.inject.Inject

class BootCompleteReceiver @Inject constructor(
    private val repository: Repository,
) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val date = System.currentTimeMillis().toString()
        val bootModel = BootModel(date = date)
        val executor = Executors.newSingleThreadExecutor();
        executor.submit {
            repository.insertBoot(bootModel)
        }
    }
}
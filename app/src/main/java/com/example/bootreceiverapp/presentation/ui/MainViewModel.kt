package com.example.bootreceiverapp.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bootreceiverapp.data.BootModel
import com.example.bootreceiverapp.data.Repository
import com.example.bootreceiverapp.presentation.feature.NotificationScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.Executors
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: Repository,
    notificationScheduler: NotificationScheduler
) : ViewModel() {
    val liveData = MutableLiveData<List<BootModel>>()

    init {
        notificationScheduler.scheduleNotification()
        val executor = Executors.newSingleThreadExecutor()
        executor.submit {
            liveData.postValue(repository.getBoots())
        }
    }
}
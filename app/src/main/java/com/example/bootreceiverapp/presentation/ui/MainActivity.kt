package com.example.bootreceiverapp.presentation.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bootreceiverapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.data)
        mainViewModel.liveData.observe(this) {
            val message = StringBuffer()

            if (it.isEmpty()) {
                message.append("No boots detected")
            } else {
                it.forEach { bootModel ->
                    message.append(bootModel.id)
                }
            }
            textView.text = message.toString()
        }
    }
}
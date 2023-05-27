package com.app.smartparking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.smartparking.data.network.ApiClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ApiClient.initialize(this)
    }
}
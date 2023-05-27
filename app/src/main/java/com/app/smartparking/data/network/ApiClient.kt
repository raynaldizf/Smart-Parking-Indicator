package com.app.smartparking.data.network

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.Properties

object ApiClient {
    private var BASE_URL: String = ""

    fun initialize(context: Context) {
        val properties = Properties()
        try {
            val inputStream = context.assets.open("config.properties")
            properties.load(inputStream)
            BASE_URL = properties.getProperty("apiBaseUrl")
        } catch (e: IOException) {
            e.printStackTrace()
            // Handle the exception
        }
    }

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }
}
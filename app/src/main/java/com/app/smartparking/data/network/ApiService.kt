package com.app.smartparking.data.network

import com.app.smartparking.data.model.response.ResponseDataDevice
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("park")
    fun getDevice() : Call<ResponseDataDevice>
}
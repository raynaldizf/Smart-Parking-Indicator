@file:Suppress("unused")

package com.app.smartparking.data.model.response


import com.app.smartparking.data.model.request.Parkiran
import com.google.gson.annotations.SerializedName

@Suppress("unused")
data class ResponseDataDevice(
    @SerializedName("parkiran")
    val parkiran: List<Parkiran>,
    @SerializedName("status")
    val status: String
)
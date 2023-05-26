@file:Suppress("unused", "unused", "unused", "unused")

package com.app.smartparking.data.model.request


import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused", "unused", "unused")
data class Parkiran(
    @SerializedName("_id")
    val id: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)
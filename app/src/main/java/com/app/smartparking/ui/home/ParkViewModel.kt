package com.app.smartparking.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.smartparking.data.model.request.Parkiran
import com.app.smartparking.data.model.response.ResponseDataDevice
import com.app.smartparking.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ParkViewModel : ViewModel(){

    private val getDevice= MutableLiveData<List<Parkiran>?>()

    fun getData() :MutableLiveData<List<Parkiran>?>{
        return getDevice
    }

    fun showData(){
        ApiClient.instance.getDevice().enqueue(object : Callback<ResponseDataDevice>{
            override fun onResponse(
                call: Call<ResponseDataDevice>,
                response: Response<ResponseDataDevice>
            ) {
                if (response.isSuccessful) {
                    getDevice.postValue(response.body()?.parkiran)
                } else {
                    getDevice.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDataDevice>, t: Throwable) {
                getDevice.postValue(null)
            }

        })
    }
}
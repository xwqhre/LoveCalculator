package com

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.remote.LoveApi
import com.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){

    fun getLoveMutableLiveData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLoveData = MutableLiveData<LoveModel>()

        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}" )
            }

        })
        return liveLoveData
    }
}
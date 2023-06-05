package com

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.remote.LoveModel
import javax.inject.Inject

class LoveViewModel @Inject constructor(private val repository: Repository):
    ViewModel(){

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveMutableLiveData(firstName, secondName)
    }
}
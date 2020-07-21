package com.ozcanalasalvar.samplemapapp.ui.detail

import androidx.lifecycle.MutableLiveData
import com.ozcanalasalvar.core.network.model.Result
import com.ozcanalasalvar.samplemapapp.base.BaseViewModel
import com.ozcanalasalvar.samplemapapp.DataHolder

class DetailViewModel : BaseViewModel() {

    val sharedPlace = MutableLiveData<Result>()

    fun getSharedPlace() {
        sharedPlace.value = DataHolder.getData()
    }


}
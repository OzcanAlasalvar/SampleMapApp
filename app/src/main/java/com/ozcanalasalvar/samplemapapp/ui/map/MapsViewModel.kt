package com.ozcanalasalvar.samplemapapp.ui.map

import androidx.lifecycle.MutableLiveData
import com.ozcanalasalvar.core.network.model.Result
import com.ozcanalasalvar.samplemapapp.base.BaseViewModel
import com.ozcanalasalvar.samplemapapp.DataHolder

class MapsViewModel : BaseViewModel() {

    val sharedPlace = MutableLiveData<Result>()

    fun getSharedPlace() {
        sharedPlace.value = DataHolder.getData()
    }

}
package com.ozcanalasalvar.samplemapapp

import com.ozcanalasalvar.core.network.model.Result

object DataHolder {

    private var data: Result? = null
    fun getData(): Result? {
        return data
    }

    fun setData(data: Result?) {
        this.data = data
    }

}
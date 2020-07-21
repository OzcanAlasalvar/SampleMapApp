package com.ozcanalasalvar.core.repository.data_source

import com.ozcanalasalvar.core.network.model.BaseModel
import io.reactivex.Single

interface RemoteSource {
    suspend fun  getPlacesFromApi(input: String): BaseModel
}
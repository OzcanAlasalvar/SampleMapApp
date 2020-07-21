package com.ozcanalasalvar.core.repository

import com.ozcanalasalvar.core.repository.data_source.RemoteSource
import com.ozcanalasalvar.core.network.model.BaseModel
import io.reactivex.Single
import javax.inject.Inject

class MapRepository @Inject constructor(
    private val remoteSource: RemoteSource
) {
    suspend fun getPlacesFromApi(input: String):BaseModel = remoteSource.getPlacesFromApi(input)
}
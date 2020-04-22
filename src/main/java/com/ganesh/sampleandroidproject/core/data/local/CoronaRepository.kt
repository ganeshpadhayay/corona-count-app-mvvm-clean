package com.ganesh.sampleandroidproject.core.data.local

import com.ganesh.sampleandroidproject.core.base.BaseRepository
import com.ganesh.sampleandroidproject.core.beans.network.DataWrapper
import com.ganesh.sampleandroidproject.core.beans.network.NetworkResource
import com.ganesh.sampleandroidproject.core.beans.network.Status
import com.ganesh.sampleandroidproject.core.utility.Constants
import com.ganesh.sampleandroidproject.features.network.CoronaService
import com.ganesh.sampleandroidproject.features.network.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

class CoronaRepository
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: CoronaService
): BaseRepository() {

    fun getCoronaData(): NetworkResource? {
        return when (networkHandler.isConnected) {
            true -> request(service.fetchCoronaData()) { it.toNetworkResource() }
            false, null -> NetworkResource(Status.ERROR, null, null)
        }
    }

    fun getCoronaIndiaData(): NetworkResource? {
        return when (networkHandler.isConnected) {
            true -> request(service.fetchCoronaIndiaData(Constants.INDIA_CORONA_DATA_URL)) { it.toNetworkResource() }
            false, null -> NetworkResource(Status.ERROR, null, null)
        }
    }
}
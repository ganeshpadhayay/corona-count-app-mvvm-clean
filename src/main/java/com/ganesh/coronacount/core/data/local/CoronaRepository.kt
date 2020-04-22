package com.ganesh.coronacount.core.data.local

import com.ganesh.coronacount.core.base.BaseRepository
import com.ganesh.coronacount.core.beans.network.NetworkResource
import com.ganesh.coronacount.core.beans.network.Status
import com.ganesh.coronacount.core.utility.Constants
import com.ganesh.coronacount.features.network.CoronaService
import com.ganesh.coronacount.features.network.NetworkHandler
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
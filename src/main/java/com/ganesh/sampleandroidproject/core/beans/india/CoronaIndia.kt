package com.ganesh.sampleandroidproject.core.beans.india

import com.ganesh.sampleandroidproject.core.beans.network.DataWrapper
import com.ganesh.sampleandroidproject.core.beans.network.NetworkResource
import com.google.gson.annotations.SerializedName

data class CoronaIndia(
    @SerializedName("cases_time_series")
    var casesTimeSeries: List<CasesTimeSeries>? = null,

    @SerializedName("statewise")
    var statewise: List<Statewise>? = null,

    @SerializedName("tested")
    var tested: List<Tested>? = null
): DataWrapper() {
    fun toNetworkResource(): NetworkResource {
        return NetworkResource.success(this)
    }
}
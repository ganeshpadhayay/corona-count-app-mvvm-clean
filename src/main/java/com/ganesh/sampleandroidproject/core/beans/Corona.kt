package com.ganesh.sampleandroidproject.core.beans

import com.ganesh.sampleandroidproject.core.beans.network.DataWrapper
import com.ganesh.sampleandroidproject.core.beans.network.NetworkResource
import com.google.gson.annotations.SerializedName

data class Corona(
    @SerializedName("updated")
    var updated: String? = null,

    @SerializedName("cases")
    var cases: String? = null,

    @SerializedName("todayCases")
    var todayCases: String? = null,

    @SerializedName("deaths")
    var deaths: String? = null,

    @SerializedName("todayDeaths")
    var todayDeaths: String? = null,

    @SerializedName("recovered")
    var recovered: String? = null,

    @SerializedName("active")
    var active: String? = null,

    @SerializedName("critical")
    var critical: String? = null,

    @SerializedName("casesPerOneMillion")
    var casesPerOneMillion: String? = null,

    @SerializedName("deathsPerOneMillion")
    var deathsPerOneMillion: String? = null,

    @SerializedName("tests")
    var tests: String? = null,

    @SerializedName("testsPerOneMillion")
    var testsPerOneMillion: String? = null,

    @SerializedName("affectedCountries")
    var affectedCountries: String? = null
) : DataWrapper() {

    fun toNetworkResource(): NetworkResource {
        return NetworkResource.success(this)
    }
}
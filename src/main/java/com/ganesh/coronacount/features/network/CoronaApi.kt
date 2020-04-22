package com.ganesh.coronacount.features.network

import com.ganesh.coronacount.core.beans.Corona
import com.ganesh.coronacount.core.beans.india.CoronaIndia
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

internal interface CoronaApi {

    companion object {
        private const val CORONA_OVERALL_DATA = "all"
        private const val CORONA_INDIA_DATA = "api.covid19india.org/data.json"
    }

    @GET(CORONA_OVERALL_DATA)
    fun fetchCoronaData(): Call<Corona>

    @GET()
    fun fetchCoronaIndiaData(@Url url :String): Call<CoronaIndia>
}
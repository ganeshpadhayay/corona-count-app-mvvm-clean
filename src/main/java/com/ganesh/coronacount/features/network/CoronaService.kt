package com.ganesh.coronacount.features.network

import com.ganesh.coronacount.core.beans.Corona
import com.ganesh.coronacount.core.beans.india.CoronaIndia
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoronaService
@Inject constructor(retrofit: Retrofit) : CoronaApi {

    private val coronaApi by lazy { retrofit.create(CoronaApi::class.java) }

    override fun fetchCoronaData(): Call<Corona> = coronaApi.fetchCoronaData()

    override fun fetchCoronaIndiaData(url :String): Call<CoronaIndia> = coronaApi.fetchCoronaIndiaData(url)
}
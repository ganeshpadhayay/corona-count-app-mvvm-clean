package com.ganesh.coronacount.core.beans.india

import com.ganesh.coronacount.core.beans.network.DataWrapper
import com.google.gson.annotations.SerializedName

data class CasesTimeSeries(
    @SerializedName("dailyconfirmed")
    var dailyconfirmed: String? = null,

    @SerializedName("dailydeceased")
    var dailydeceased: String? = null,

    @SerializedName("dailyrecovered")
    var dailyrecovered: String? = null,

    @SerializedName("date")
    var date: String? = null,

    @SerializedName("totalconfirmed")
    var totalconfirmed: String? = null,

    @SerializedName("totaldeceased")
    var totaldeceased: String? = null,

    @SerializedName("totalrecovered")
    var totalrecovered: String? = null
) : DataWrapper()
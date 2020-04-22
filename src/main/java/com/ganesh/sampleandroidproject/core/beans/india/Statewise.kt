package com.ganesh.sampleandroidproject.core.beans.india

import com.ganesh.sampleandroidproject.core.beans.network.DataWrapper
import com.google.gson.annotations.SerializedName

data class Statewise(
    @SerializedName("active")
    var active: String? = null,

    @SerializedName("confirmed")
    var confirmed: String? = null,

    @SerializedName("deaths")
    var deaths: String? = null,

    @SerializedName("deltaconfirmed")
    var deltaconfirmed: String? = null,

    @SerializedName("deltadeaths")
    var deltadeaths: String? = null,

    @SerializedName("deltarecovered")
    var deltarecovered: String? = null,

    @SerializedName("lastupdatedtime")
    var lastupdatedtime: String? = null,

    @SerializedName("recovered")
    var recovered: String? = null,

    @SerializedName("state")
    var state: String? = null,

    @SerializedName("statecode")
    var statecode: String? = null
): DataWrapper()
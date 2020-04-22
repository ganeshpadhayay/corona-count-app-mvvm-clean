package com.ganesh.sampleandroidproject.core.beans.india

import com.ganesh.sampleandroidproject.core.beans.network.DataWrapper
import com.google.gson.annotations.SerializedName

data class Tested(
    @SerializedName("_cyevm")
    var cyevm: String? = null,

    @SerializedName("positivecasesfromsamplesreported")
    var positivecasesfromsamplesreported: String? = null,

    @SerializedName("samplereportedtoday")
    var samplereportedtoday: String? = null,

    @SerializedName("source")
    var source: String? = null,

    @SerializedName("testsconductedbyprivatelabs")
    var testsconductedbyprivatelabs: String? = null,

    @SerializedName("totalindividualstested")
    var totalindividualstested: String? = null,

    @SerializedName("totalpositivecases")
    var totalpositivecases: String? = null,

    @SerializedName("totalsamplestested")
    var totalsamplestested: String? = null,

    @SerializedName("updatetimestamp")
    var updatetimestamp: String? = null
): DataWrapper()
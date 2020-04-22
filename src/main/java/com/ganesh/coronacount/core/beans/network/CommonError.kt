package com.ganesh.coronacount.core.beans.network

data class CommonError(var statusCode: Int, var ijrPaytmDataModel: DataWrapper?, var networkCustomError: NetworkCustomError?)

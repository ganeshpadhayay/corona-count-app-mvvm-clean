package com.ganesh.sampleandroidproject.core.beans.network

data class NetworkResource(val status: Status, val data: DataWrapper?, val error: CommonError?) {

    companion object {

        fun success(data: DataWrapper): NetworkResource {
            return NetworkResource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun error(statusCode: Int, data: DataWrapper, networkCustomError: NetworkCustomError): NetworkResource {
            return NetworkResource(
                Status.ERROR,
                null,
                CommonError(
                    statusCode,
                    data,
                    networkCustomError
                )
            )
        }

        fun progress(): NetworkResource {
            return NetworkResource(
                Status.PROGRESS,
                null,
                null
            )
        }

        fun cancel(): NetworkResource {
            return NetworkResource(
                Status.CANCELLED,
                null,
                null
            )
        }

    }
}

enum class Status {
    SUCCESS, ERROR, PROGRESS, CANCELLED
}
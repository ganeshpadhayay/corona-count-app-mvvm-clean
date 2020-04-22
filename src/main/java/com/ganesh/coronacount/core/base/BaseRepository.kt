package com.ganesh.coronacount.core.base

import com.ganesh.coronacount.core.beans.network.NetworkResource
import com.ganesh.coronacount.core.beans.network.Status
import retrofit2.Call

open class BaseRepository {

    fun <T> request(call: Call<T>, transform: (T) -> NetworkResource): NetworkResource? {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> response.body()?.let { transform(it) }
                false -> NetworkResource(Status.ERROR, null, null)
            }
        } catch (exception: Throwable) {
            NetworkResource(Status.ERROR, null, null)
        }
    }

}
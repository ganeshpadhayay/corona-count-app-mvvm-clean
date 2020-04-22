package com.ganesh.coronacount.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.ganesh.coronacount.core.beans.network.NetworkResource

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) =
    liveData.observe(this, Observer(body))

fun <L : LiveData<NetworkResource>> LifecycleOwner.failure(liveData: L, body: (NetworkResource?) -> Unit) =
    liveData.observe(this, Observer(body))
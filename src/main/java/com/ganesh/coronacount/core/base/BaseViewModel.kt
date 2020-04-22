package com.ganesh.coronacount.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganesh.coronacount.core.beans.network.NetworkResource

abstract class BaseViewModel : ViewModel() {

    var failure: MutableLiveData<NetworkResource> = MutableLiveData()

    protected fun handleFailure(failure: NetworkResource) {
        this.failure.value = failure
    }
}
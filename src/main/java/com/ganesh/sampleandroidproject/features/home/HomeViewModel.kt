package com.ganesh.sampleandroidproject.features.home

import androidx.lifecycle.MutableLiveData
import com.ganesh.sampleandroidproject.core.base.BaseViewModel
import com.ganesh.sampleandroidproject.core.beans.Corona
import com.ganesh.sampleandroidproject.core.beans.india.CoronaIndia
import com.ganesh.sampleandroidproject.core.beans.network.NetworkResource
import com.ganesh.sampleandroidproject.core.beans.network.Status
import com.ganesh.sampleandroidproject.core.interactor.UseCase
import com.ganesh.sampleandroidproject.features.usecase.GetCorona
import com.ganesh.sampleandroidproject.features.usecase.GetCoronaIndia
import javax.inject.Inject

class HomeViewModel
@Inject constructor(private val getCorona: GetCorona, private val getCoronaIndia: GetCoronaIndia) : BaseViewModel() {

    var coronaData: MutableLiveData<Corona> = MutableLiveData()
    var coronaIndiaData: MutableLiveData<CoronaIndia> = MutableLiveData()

    fun loadCoronaData() = getCorona(UseCase.None()) {
        if (it.status == Status.SUCCESS) {
            handleCoronaCount(it)
        } else if (it.status == Status.ERROR) {
            handleFailure(it)
        }
    }

    private fun handleCoronaCount(networkResource: NetworkResource) {
        coronaData.postValue(networkResource.data as Corona);
    }

    fun loadCoronaIndiaData()= getCoronaIndia(UseCase.None()){
        if (it.status == Status.SUCCESS) {
            coronaIndiaData.postValue(it.data as CoronaIndia)
        } else if (it.status == Status.ERROR) {
            handleFailure(it)
        }
    }
}
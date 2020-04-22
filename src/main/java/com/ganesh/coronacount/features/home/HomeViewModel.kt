package com.ganesh.coronacount.features.home

import androidx.lifecycle.MutableLiveData
import com.ganesh.coronacount.core.base.BaseViewModel
import com.ganesh.coronacount.core.beans.Corona
import com.ganesh.coronacount.core.beans.india.CoronaIndia
import com.ganesh.coronacount.core.beans.network.NetworkResource
import com.ganesh.coronacount.core.beans.network.Status
import com.ganesh.coronacount.core.interactor.UseCase
import com.ganesh.coronacount.features.usecase.GetCorona
import com.ganesh.coronacount.features.usecase.GetCoronaIndia
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
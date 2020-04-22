package com.ganesh.coronacount.features.usecase

import com.ganesh.coronacount.core.beans.network.NetworkResource
import com.ganesh.coronacount.core.data.local.CoronaRepository
import com.ganesh.coronacount.core.interactor.UseCase
import javax.inject.Inject

class GetCoronaIndia
@Inject constructor(private val coronaRepository: CoronaRepository) : UseCase<NetworkResource, UseCase.None>() {

    override suspend fun run(params: None) = coronaRepository.getCoronaIndiaData()
}
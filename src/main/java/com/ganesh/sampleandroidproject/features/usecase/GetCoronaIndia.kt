package com.ganesh.sampleandroidproject.features.usecase

import com.ganesh.sampleandroidproject.core.beans.network.NetworkResource
import com.ganesh.sampleandroidproject.core.data.local.CoronaRepository
import com.ganesh.sampleandroidproject.core.interactor.UseCase
import javax.inject.Inject

class GetCoronaIndia
@Inject constructor(private val coronaRepository: CoronaRepository) : UseCase<NetworkResource, UseCase.None>() {

    override suspend fun run(params: None) = coronaRepository.getCoronaIndiaData()
}
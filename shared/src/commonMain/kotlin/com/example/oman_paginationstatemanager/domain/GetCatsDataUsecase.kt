package com.example.oman_paginationstatemanager.domain

import com.example.oman_paginationstatemanager.data.getCarsList
import kotlinx.coroutines.flow.flow

class GetCatsDataUsecase {
    operator fun invoke() = flow {
        val response = getCarsList().asDomainModel()
        emit(response)
    }
}
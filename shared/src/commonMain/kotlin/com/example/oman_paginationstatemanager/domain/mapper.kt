package com.example.oman_paginationstatemanager.domain

import com.example.oman_paginationstatemanager.data.CarDetailDTO

fun CarDetailDTO.asDomainModel() = CarDomainModel(
    id,
    carModel,
    carName,
    carPrice,
    isBooked,
    carImage,
    description,
    companyId,
)


fun List<CarDetailDTO>.asDomainModel() = map { it.asDomainModel() }
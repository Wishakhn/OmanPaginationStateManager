package com.example.oman_paginationstatemanager.di


import com.example.oman_paginationstatemanager.domain.GetCatsDataUsecase
import org.koin.dsl.module


val UsecaseModule  = module{
    factory { GetCatsDataUsecase() }
}
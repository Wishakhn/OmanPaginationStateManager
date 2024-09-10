package com.example.oman_paginationstatemanager.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(viewModelModule + UsecaseModule)
}
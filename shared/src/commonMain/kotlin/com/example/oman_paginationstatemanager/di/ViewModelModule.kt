package com.example.oman_paginationstatemanager.di

import com.example.oman_paginationstatemanager.ui.PaginationStateViewModel
import org.koin.dsl.module


val viewModelModule = module {
    single { PaginationStateViewModel(get()) }
}
package com.example.oman_paginationstatemanager.android

import android.app.Application
import com.example.oman_paginationstatemanager.di.initKoin


class PaginationManagerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
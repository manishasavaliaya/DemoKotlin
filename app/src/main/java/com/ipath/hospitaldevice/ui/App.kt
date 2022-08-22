package com.ipath.hospitaldevice.ui

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
    companion object {
        private var context: Context? = null
        fun getContext(): Context? {
            return context
        }
    }
}
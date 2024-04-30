package com.kaeddev.kaeddevdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KaEdDevDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
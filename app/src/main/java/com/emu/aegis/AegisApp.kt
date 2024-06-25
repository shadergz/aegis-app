package com.emu.aegis

import android.app.Application

class AegisApp : Application() {
    companion object {
        lateinit var application: AegisApp
            private set
    }
    init {
        application = this
    }

    override fun onCreate() {
        super.onCreate()
        System.loadLibrary("aegis")
    }
}

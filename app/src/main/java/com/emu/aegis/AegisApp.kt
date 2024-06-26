package com.emu.aegis

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import com.emu.aegis.preference.AegisSerializer
import com.emu.aegis.preference.AegisSettings
import java.io.File
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Singleton

@HiltAndroidApp
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

@Singleton
fun getDataStore(@ApplicationContext context: Context): DataStore<AegisSettings> =
    DataStoreFactory.create(
        serializer = AegisSerializer,
        produceFile = {
            File("${context.cacheDir.path}/aegis.preferences.ds")
        }
    )

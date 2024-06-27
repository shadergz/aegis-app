package com.emu.aegis

import android.content.Context

class CachedStorage(context: Context) {
    companion object {
        private var cacheDir: String? = null
    }
    init {
        if (cacheDir == null)
            cacheDir = context.externalCacheDir?.canonicalPath
    }
    fun checkPackageDirectory() {
        assert(cacheDir != null)
        ExternalFunctions.verifyInternalStorage(cacheDir!!)
    }

}
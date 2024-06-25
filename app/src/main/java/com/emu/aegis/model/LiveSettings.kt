package com.emu.aegis.model

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LiveSettings @Inject constructor() : ViewModel() {
    val isDocked: Boolean
        get() = false
}

package com.emu.aegis.data

data class MangleSettings(
    val isDocked: Boolean
) {
    constructor() : this(
        isDocked = false
    )
}
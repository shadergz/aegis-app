package com.emu.aegis.preference

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Singleton

@Serializable
data class AegisSettings(
    val isDocked: Boolean
)

@Singleton
object AegisSerializer : Serializer<AegisSettings> {
    override val defaultValue = AegisSettings(
        isDocked = false
    )
    override suspend fun readFrom(input: InputStream): AegisSettings =
        try {
            Json.decodeFromString(
                AegisSettings.serializer(), input.readBytes().decodeToString()
            )
        } catch (serialization: SerializationException) {
            throw CorruptionException("Unable to read Settings", serialization)
        }
    override suspend fun writeTo(t: AegisSettings, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(AegisSettings.serializer(), t).encodeToByteArray()
            )
        }
    }
}
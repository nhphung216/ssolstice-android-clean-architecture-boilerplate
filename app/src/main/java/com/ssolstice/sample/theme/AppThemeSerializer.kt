package com.ssolstice.sample.theme

import androidx.datastore.core.Serializer
import com.ssolstice.sample.data.model.ThemeMode
import java.io.InputStream
import java.io.OutputStream

object AppThemeSerializer : Serializer<ThemeMode> {

    override val defaultValue: ThemeMode
        get() = ThemeMode.AUTO

    override suspend fun readFrom(input: InputStream): ThemeMode {
        return try {
            val name = input.readBytes().decodeToString()
            ThemeMode.valueOf(name)
        } catch (e: Exception) {
            ThemeMode.AUTO
        }
    }

    override suspend fun writeTo(
        t: ThemeMode,
        output: OutputStream
    ) {
        output.write(t.name.toByteArray())
    }
}
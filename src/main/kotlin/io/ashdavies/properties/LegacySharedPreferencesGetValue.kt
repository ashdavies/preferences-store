package io.ashdavies.properties

import android.content.SharedPreferences
import androidx.core.content.edit

internal class LegacySharedPreferencesValue<T>(
        private val getValue: SharedPreferences.(String, T) -> T,
        private val setValue: SharedPreferences.Editor.(String, T) -> SharedPreferences.Editor,
        private val oldName: String
) : (SharedPreferences, String, T) -> T {

    override fun invoke(
            thisRef: SharedPreferences,
            key: String,
            default: T
    ): T {
        val value: T? = thisRef.getValue(key, default)
        if (value != null) {
            return value
        }

        val oldValue: T? = thisRef.getValue(oldName, default)
        if (oldValue != null) {
            thisRef.edit {
                setValue(key, oldValue)
            }

            return oldValue
        }

        @Suppress("UNCHECKED_CAST")
        return null as T
    }
}
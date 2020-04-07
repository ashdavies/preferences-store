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
        if (thisRef.contains(key)) {
            return thisRef.getValue(key, default)
        }

        val oldValue: T? = thisRef.getValue(oldName, default)
        if (oldValue != null) {
            thisRef.edit {
                setValue(key, oldValue)
            }

            return oldValue
        }

        return default
    }
}

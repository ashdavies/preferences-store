package io.ashdavies.properties

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.preferences.SharedPreferencesStore

internal class NullableSharedPreferencesProperty<T>(
        private val getValue: SharedPreferences.(String, T?) -> T?,
        private val setValue: Editor.(String, T) -> Editor,
        private val block: (T?) -> T
) : SharedPreferencesEditorProperty<T>() {

    override fun getValue(
            thisRef: SharedPreferencesStore,
            key: String
    ): T = thisRef
            .sharedPreferences
            .getValue(key, null)
            .let(block)

    override fun setValue(
            thisRef: Editor,
            key: String,
            value: T
    ): Editor = thisRef.setValue(key, value)
}

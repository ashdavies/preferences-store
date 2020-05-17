package io.ashdavies.properties

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.preferences.SharedPreferencesStore

internal class DefaultSharedPreferencesProperty<T>(
    private val getValue: SharedPreferences.(String, T) -> T,
    private val setValue: Editor.(String, T) -> Editor,
    private val default: T
) : SharedPreferencesEditorProperty<T>() {

    override fun getValue(
        thisRef: SharedPreferencesStore,
        key: String
    ): T = thisRef
        .sharedPreferences
        .getValue(key, default)

    override fun setValue(
        thisRef: Editor,
        key: String,
        value: T
    ): Editor = thisRef.setValue(key, value)
}

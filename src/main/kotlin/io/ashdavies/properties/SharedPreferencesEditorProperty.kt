package io.ashdavies.properties

import android.content.SharedPreferences.Editor
import androidx.core.content.edit
import io.ashdavies.preferences.SharedPreferencesStore

internal abstract class SharedPreferencesEditorProperty<T> :
    NamedReadWriteProperty<SharedPreferencesStore, T>() {

    final override fun setValue(
        thisRef: SharedPreferencesStore,
        key: String,
        value: T
    ): Unit = thisRef
        .sharedPreferences
        .edit { setValue(this, key, value) }

    abstract fun setValue(
        thisRef: Editor,
        key: String,
        value: T
    ): Editor
}

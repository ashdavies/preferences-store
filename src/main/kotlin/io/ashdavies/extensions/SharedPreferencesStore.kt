package io.ashdavies.extensions

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.preferences.SharedPreferencesStore
import io.ashdavies.properties.DefaultSharedPreferencesProperty
import io.ashdavies.properties.LegacySharedPreferencesValue
import io.ashdavies.properties.NullableSharedPreferencesProperty
import io.ashdavies.properties.SharedPreferencesProperty

fun SharedPreferencesStore.booleanOrDefault(default: Boolean): SharedPreferencesProperty<Boolean> = DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getBoolean,
        setValue = Editor::putBoolean,
        default = default
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesBooleanOrDefault(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesBooleanOrDefault"]
        )
)
fun SharedPreferencesStore.booleanOrDefault(key: String, default: Boolean): SharedPreferencesProperty<Boolean> = DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getBoolean, Editor::putBoolean, key),
        setValue = Editor::putBoolean,
        default = default
)

fun SharedPreferencesStore.floatOrDefault(default: Float): SharedPreferencesProperty<Float> = DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getFloat,
        setValue = Editor::putFloat,
        default = default
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesFloatOrDefault(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesFloatOrDefault"]
        )
)
fun SharedPreferencesStore.floatOrDefault(key: String, default: Float): SharedPreferencesProperty<Float> = DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getFloat, Editor::putFloat, key),
        setValue = Editor::putFloat,
        default = default
)

fun SharedPreferencesStore.intOrDefault(default: Int): SharedPreferencesProperty<Int> = DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getInt,
        setValue = Editor::putInt,
        default = default
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesIntOrDefault(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesIntOrDefault"]
        )
)
fun SharedPreferencesStore.intOrDefault(key: String, default: Int): SharedPreferencesProperty<Int> = DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getInt, Editor::putInt, key),
        setValue = Editor::putInt,
        default = default
)

fun SharedPreferencesStore.longOrDefault(default: Long): SharedPreferencesProperty<Long> = DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getLong,
        setValue = Editor::putLong,
        default = default
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesLongOrDefault(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesLongOrDefault"]
        )
)
fun SharedPreferencesStore.longOrDefault(key: String, default: Long): SharedPreferencesProperty<Long> = DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getLong, Editor::putLong, key),
        setValue = Editor::putLong,
        default = default
)

fun SharedPreferencesStore.string(): SharedPreferencesProperty<String> = NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { requireNotNull(it) }
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesString(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesString"]
        )
)
fun SharedPreferencesStore.string(key: String): SharedPreferencesProperty<String> = NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getString, Editor::putString, key),
        setValue = Editor::putString,
        block = { requireNotNull(it) }
)

fun SharedPreferencesStore.stringOrDefault(default: String): SharedPreferencesProperty<String> = NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { it ?: default }
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesStringOrDefault(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesStringOrDefault"]
        )
)
fun SharedPreferencesStore.stringOrDefault(key: String, default: String): SharedPreferencesProperty<String> = NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getString, Editor::putString, key),
        setValue = Editor::putString,
        block = { it ?: default }
)

fun SharedPreferencesStore.stringOrNull(): SharedPreferencesProperty<String?> = NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { it }
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesStringOrNull(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesStringOrNull"]
        )
)
fun SharedPreferencesStore.stringOrNull(key: String): SharedPreferencesProperty<String?> = NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getString, Editor::putString, key),
        setValue = Editor::putString,
        block = { it }
)

fun SharedPreferencesStore.stringSetOrDefault(default: Set<String>): SharedPreferencesProperty<Set<String>> = NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getStringSet,
        setValue = Editor::putStringSet,
        block = { it ?: default }
)

@Deprecated(
        message = "Key is deprecated",
        replaceWith = ReplaceWith(
                expression = "sharedPreferencesStringSetOrDefault(default)",
                imports = ["de.is24.mobile.extensions.sharedPreferencesStringSetOrDefault"]
        )
)
fun SharedPreferencesStore.stringSetOrDefault(key: String, default: Set<String>): SharedPreferencesProperty<Set<String>> = NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getStringSet, Editor::putStringSet, key),
        setValue = Editor::putStringSet,
        block = { it ?: default }
)


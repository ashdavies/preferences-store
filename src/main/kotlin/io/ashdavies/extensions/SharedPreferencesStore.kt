package io.ashdavies.extensions

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.properties.DefaultSharedPreferencesProperty
import io.ashdavies.properties.NullableSharedPreferencesProperty
import io.ashdavies.properties.SharedPreferencesProperty

fun booleanOrDefault(default: Boolean): SharedPreferencesProperty<Boolean> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getBoolean,
        setValue = Editor::putBoolean,
        default = default
    )

fun floatOrDefault(default: Float): SharedPreferencesProperty<Float> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getFloat,
        setValue = Editor::putFloat,
        default = default
    )

fun intOrDefault(default: Int): SharedPreferencesProperty<Int> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getInt,
        setValue = Editor::putInt,
        default = default
    )

fun longOrDefault(default: Long): SharedPreferencesProperty<Long> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getLong,
        setValue = Editor::putLong,
        default = default
    )

fun string(): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { requireNotNull(it) }
    )

fun stringOrDefault(default: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { it ?: default }
    )

fun stringOrNull(): SharedPreferencesProperty<String?> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { it }
    )

fun stringSetOrDefault(default: Set<String>): SharedPreferencesProperty<Set<String>> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getStringSet,
        setValue = Editor::putStringSet,
        block = { it ?: default }
    )

fun stringSetOrNull(): SharedPreferencesProperty<Set<String>?> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getStringSet,
        setValue = Editor::putStringSet,
        block = { it }
    )

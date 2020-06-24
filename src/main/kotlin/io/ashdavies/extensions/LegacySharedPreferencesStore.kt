package io.ashdavies.extensions

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.properties.DefaultSharedPreferencesProperty
import io.ashdavies.properties.LegacySharedPreferencesValue
import io.ashdavies.properties.NullableSharedPreferencesProperty
import io.ashdavies.properties.SharedPreferencesProperty

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.booleanOrDefault(default)"
    )
)
fun booleanOrDefault(key: String, default: Boolean): SharedPreferencesProperty<Boolean> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getBoolean,
            setValue = Editor::putBoolean,
            oldName = key
        ),
        setValue = Editor::putBoolean,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.floatOrDefault(default)"
    )
)
fun floatOrDefault(key: String, default: Float): SharedPreferencesProperty<Float> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getFloat,
            setValue = Editor::putFloat,
            oldName = key
        ),
        setValue = Editor::putFloat,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.intOrDefault(default)"
    )
)
fun intOrDefault(key: String, default: Int): SharedPreferencesProperty<Int> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getInt,
            setValue = Editor::putInt,
            oldName = key
        ),
        setValue = Editor::putInt,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.longOrDefault(default)"
    )
)
fun longOrDefault(key: String, default: Long): SharedPreferencesProperty<Long> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getLong,
            setValue = Editor::putLong,
            oldName = key
        ),
        setValue = Editor::putLong,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.string(default)"
    )
)
fun string(key: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getString,
            setValue = Editor::putString,
            oldName = key
        ),
        setValue = Editor::putString,
        block = { requireNotNull(it) }
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.stringOrDefault(default)"
    )
)
fun stringOrDefault(key: String, default: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getString,
            setValue = Editor::putString,
            oldName = key
        ),
        setValue = Editor::putString,
        block = { it ?: default }
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.stringOrNull()"
    )
)
fun stringOrNull(key: String): SharedPreferencesProperty<String?> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getString,
            setValue = Editor::putString,
            oldName = key
        ),
        setValue = Editor::putString,
        block = { it }
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.stringSetOrDefault(default)"
    )
)
fun stringSetOrDefault(key: String, default: Set<String>): SharedPreferencesProperty<Set<String>> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getStringSet,
            setValue = Editor::putStringSet,
            oldName = key
        ),
        setValue = Editor::putStringSet,
        block = { it ?: default }
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "io.ashdavies.extensions.stringSetOrNull(default)"
    )
)
fun stringSetOrNull(key: String): SharedPreferencesProperty<Set<String>?> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getStringSet,
            setValue = Editor::putStringSet,
            oldName = key
        ),
        setValue = Editor::putStringSet,
        block = { it }
    )

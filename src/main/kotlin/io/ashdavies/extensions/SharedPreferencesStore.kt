package io.ashdavies.extensions

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.properties.DefaultSharedPreferencesProperty
import io.ashdavies.properties.LegacySharedPreferencesValue
import io.ashdavies.properties.NullableSharedPreferencesProperty
import io.ashdavies.properties.SharedPreferencesProperty

fun booleanOrDefault(default: Boolean): SharedPreferencesProperty<Boolean> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getBoolean,
        setValue = Editor::putBoolean,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "booleanOrDefault(default)",
        imports = ["io.ashdavies.extensions.booleanOrDefault"]
    )
)
fun booleanOrDefault(key: String, default: Boolean): SharedPreferencesProperty<Boolean> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            SharedPreferences::getBoolean,
            Editor::putBoolean,
            key
        ),
        setValue = Editor::putBoolean,
        default = default
    )

fun floatOrDefault(default: Float): SharedPreferencesProperty<Float> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getFloat,
        setValue = Editor::putFloat,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "floatOrDefault(default)",
        imports = ["io.ashdavies.extensions.floatOrDefault"]
    )
)
fun floatOrDefault(key: String, default: Float): SharedPreferencesProperty<Float> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getFloat, Editor::putFloat, key),
        setValue = Editor::putFloat,
        default = default
    )

fun intOrDefault(default: Int): SharedPreferencesProperty<Int> = DefaultSharedPreferencesProperty(
    getValue = SharedPreferences::getInt,
    setValue = Editor::putInt,
    default = default
)

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "intOrDefault(default)",
        imports = ["io.ashdavies.extensions.intOrDefault"]
    )
)
fun intOrDefault(key: String, default: Int): SharedPreferencesProperty<Int> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getInt, Editor::putInt, key),
        setValue = Editor::putInt,
        default = default
    )

fun longOrDefault(default: Long): SharedPreferencesProperty<Long> =
    DefaultSharedPreferencesProperty(
        getValue = SharedPreferences::getLong,
        setValue = Editor::putLong,
        default = default
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "longOrDefault(default)",
        imports = ["io.ashdavies.extensions.longOrDefault"]
    )
)
fun longOrDefault(key: String, default: Long): SharedPreferencesProperty<Long> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(SharedPreferences::getLong, Editor::putLong, key),
        setValue = Editor::putLong,
        default = default
    )

fun string(): SharedPreferencesProperty<String> = NullableSharedPreferencesProperty(
    getValue = SharedPreferences::getString,
    setValue = Editor::putString,
    block = { requireNotNull(it) }
)

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "string(default)",
        imports = ["io.ashdavies.extensions.string"]
    )
)
fun string(key: String): SharedPreferencesProperty<String> = NullableSharedPreferencesProperty(
    getValue = LegacySharedPreferencesValue(SharedPreferences::getString, Editor::putString, key),
    setValue = Editor::putString,
    block = { requireNotNull(it) }
)

fun stringOrDefault(default: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getString,
        setValue = Editor::putString,
        block = { it ?: default }
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "stringOrDefault(default)",
        imports = ["io.ashdavies.extensions.stringOrDefault"]
    )
)
fun stringOrDefault(key: String, default: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            SharedPreferences::getString,
            Editor::putString,
            key
        ),
        setValue = Editor::putString,
        block = { it ?: default }
    )

fun stringOrNull(): SharedPreferencesProperty<String?> = NullableSharedPreferencesProperty(
    getValue = SharedPreferences::getString,
    setValue = Editor::putString,
    block = { it }
)

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "stringOrNull()",
        imports = ["io.ashdavies.extensions.stringOrNull"]
    )
)
fun stringOrNull(key: String): SharedPreferencesProperty<String?> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            SharedPreferences::getString,
            Editor::putString,
            key
        ),
        setValue = Editor::putString,
        block = { it }
    )

fun stringSetOrDefault(default: Set<String>): SharedPreferencesProperty<Set<String>> =
    NullableSharedPreferencesProperty(
        getValue = SharedPreferences::getStringSet,
        setValue = Editor::putStringSet,
        block = { it ?: default }
    )

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "stringSetOrDefault(default)",
        imports = ["io.ashdavies.extensions.stringSetOrDefault"]
    )
)
fun stringSetOrDefault(key: String, default: Set<String>): SharedPreferencesProperty<Set<String>> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            SharedPreferences::getStringSet,
            Editor::putStringSet,
            key
        ),
        setValue = Editor::putStringSet,
        block = { it ?: default }
    )

fun stringSetOrNull(): SharedPreferencesProperty<Set<String>?> = NullableSharedPreferencesProperty(
    getValue = SharedPreferences::getStringSet,
    setValue = Editor::putStringSet,
    block = { it }
)

@Deprecated(
    message = "Key is deprecated",
    replaceWith = ReplaceWith(
        expression = "stringSetOrNull(default)",
        imports = ["io.ashdavies.extensions.stringSetOrNull"]
    )
)
fun stringSetOrNull(key: String): SharedPreferencesProperty<Set<String>?> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            SharedPreferences::getStringSet,
            Editor::putStringSet,
            key
        ),
        setValue = Editor::putStringSet,
        block = { it }
    )

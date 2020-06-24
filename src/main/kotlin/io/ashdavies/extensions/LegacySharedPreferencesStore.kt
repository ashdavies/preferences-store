package io.ashdavies.extensions

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import io.ashdavies.properties.DefaultSharedPreferencesProperty
import io.ashdavies.properties.LegacySharedPreferencesValue
import io.ashdavies.properties.NullableSharedPreferencesProperty
import io.ashdavies.properties.SharedPreferencesProperty

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.booleanOrDefault(default)")
)
fun booleanOrDefault(oldName: String, default: Boolean): SharedPreferencesProperty<Boolean> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getBoolean,
            setValue = Editor::putBoolean,
            oldName = oldName
        ),
        setValue = Editor::putBoolean,
        default = default
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.floatOrDefault(default)")
)
fun floatOrDefault(oldName: String, default: Float): SharedPreferencesProperty<Float> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getFloat,
            setValue = Editor::putFloat,
            oldName = oldName
        ),
        setValue = Editor::putFloat,
        default = default
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.intOrDefault(default)")
)
fun intOrDefault(oldName: String, default: Int): SharedPreferencesProperty<Int> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getInt,
            setValue = Editor::putInt,
            oldName = oldName
        ),
        setValue = Editor::putInt,
        default = default
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.longOrDefault(default)")
)
fun longOrDefault(oldName: String, default: Long): SharedPreferencesProperty<Long> =
    DefaultSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getLong,
            setValue = Editor::putLong,
            oldName = oldName
        ),
        setValue = Editor::putLong,
        default = default
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.string(default)")
)
fun string(oldName: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getString,
            setValue = Editor::putString,
            oldName = oldName
        ),
        setValue = Editor::putString,
        block = { requireNotNull(it) }
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.stringOrDefault(default)")
)
fun stringOrDefault(oldName: String, default: String): SharedPreferencesProperty<String> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getString,
            setValue = Editor::putString,
            oldName = oldName
        ),
        setValue = Editor::putString,
        block = { it ?: default }
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.stringOrNull()")
)
fun stringOrNull(oldName: String): SharedPreferencesProperty<String?> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getString,
            setValue = Editor::putString,
            oldName = oldName
        ),
        setValue = Editor::putString,
        block = { it }
    )

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.stringSetOrDefault(default)")
)
fun stringSetOrDefault(
    oldName: String,
    default: Set<String>
): SharedPreferencesProperty<Set<String>> = NullableSharedPreferencesProperty(
    getValue = LegacySharedPreferencesValue(
        getValue = SharedPreferences::getStringSet,
        setValue = Editor::putStringSet,
        oldName = oldName
    ),
    setValue = Editor::putStringSet,
    block = { it ?: default }
)

@Deprecated(
    message = "Explicitly named preference delegate properties are deprecated",
    replaceWith = ReplaceWith("io.ashdavies.extensions.stringSetOrNull(default)")
)
fun stringSetOrNull(oldName: String): SharedPreferencesProperty<Set<String>?> =
    NullableSharedPreferencesProperty(
        getValue = LegacySharedPreferencesValue(
            getValue = SharedPreferences::getStringSet,
            setValue = Editor::putStringSet,
            oldName = oldName
        ),
        setValue = Editor::putStringSet,
        block = { it }
    )

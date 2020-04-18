package io.ashdavies.preferences

import android.app.Activity
import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.LazyThreadSafetyMode.SYNCHRONIZED
import kotlin.reflect.KProperty

interface SharedPreferencesStore {

    val sharedPreferences: SharedPreferences
}

@Suppress("FunctionName")
fun SharedPreferencesStore(
        application: Application,
        name: String,
        mode: LazyThreadSafetyMode = SYNCHRONIZED
): SharedPreferencesStore = object : SharedPreferencesStore {

    override val sharedPreferences: SharedPreferences by lazy(mode) {
        application.getSharedPreferences(name, MODE_PRIVATE)
    }
}

@Suppress("FunctionName")
fun SharedPreferencesStore(
        activity: Activity,
        mode: LazyThreadSafetyMode = SYNCHRONIZED
): SharedPreferencesStore = SharedPreferencesStore(
        application = activity.application,
        name = activity.localClassName,
        mode = mode
)

fun SharedPreferencesStore.remove(
        property: KProperty<*>
): Unit = sharedPreferences.edit {
    remove(property.name)
}

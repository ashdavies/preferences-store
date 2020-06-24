@file:Suppress("FunctionName")

package io.ashdavies.preferences

import android.app.Activity
import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.reflect.KProperty

interface SharedPreferencesStore {

    val sharedPreferences: SharedPreferences
}

@ExperimentalCoroutinesApi
fun SharedPreferencesStore(
    application: Application,
    name: String
): SharedPreferencesStore = CoroutinePreferencesStore(
    application = application,
    name = name
)

@ExperimentalCoroutinesApi
fun SharedPreferencesStore(
    activity: Activity
): SharedPreferencesStore = SharedPreferencesStore(
    application = activity.application,
    name = activity.localClassName
)

fun SharedPreferencesStore.remove(
    property: KProperty<*>
): Unit = sharedPreferences.edit {
    remove(property.name)
}

package io.ashdavies.preferences

import android.app.Activity
import android.app.Application
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.KProperty

interface SharedPreferencesStore {

    val sharedPreferences: SharedPreferences
}

@Suppress("FunctionName")
fun SharedPreferencesStore(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    application: Application,
    name: String
): SharedPreferencesStore = CoroutinePreferencesStore(
    context = coroutineContext,
    application = application,
    name = name
)

@Suppress("FunctionName")
fun SharedPreferencesStore(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    activity: Activity
): SharedPreferencesStore = SharedPreferencesStore(
    coroutineContext = coroutineContext,
    application = activity.application,
    name = activity.localClassName
)

fun SharedPreferencesStore.remove(
    property: KProperty<*>
): Unit = sharedPreferences.edit {
    remove(property.name)
}

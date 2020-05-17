package io.ashdavies.extensions

import android.app.Activity
import android.app.Application
import io.ashdavies.preferences.SharedPreferencesStore
import kotlinx.coroutines.CoroutineScope

fun CoroutineScope.sharedPreferencesStore(
    application: Application,
    name: String
): SharedPreferencesStore = SharedPreferencesStore(
    coroutineContext = coroutineContext,
    application = application,
    name = name
)

fun CoroutineScope.sharedPreferencesStore(
    activity: Activity
): SharedPreferencesStore = SharedPreferencesStore(
    coroutineContext = coroutineContext,
    activity = activity
)

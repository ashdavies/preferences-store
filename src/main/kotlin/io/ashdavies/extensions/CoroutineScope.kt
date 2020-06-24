package io.ashdavies.extensions

import android.app.Activity
import android.app.Application
import io.ashdavies.preferences.CoroutinePreferencesStore
import io.ashdavies.preferences.SharedPreferencesStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun CoroutineScope.sharedPreferencesStore(
    application: Application,
    name: String
): SharedPreferencesStore = CoroutinePreferencesStore(
    application = application,
    name = name
)

@ExperimentalCoroutinesApi
fun CoroutineScope.sharedPreferencesStore(
    activity: Activity
): SharedPreferencesStore = sharedPreferencesStore(
    application = activity.application,
    name = activity.localClassName
)

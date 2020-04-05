package io.ashdavies.preferences

import android.app.Activity
import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

interface SharedPreferencesStore {

    val sharedPreferences: SharedPreferences
}

@Suppress("FunctionName")
fun SharedPreferencesStore(
        application: Application,
        name: String
): SharedPreferencesStore = object : SharedPreferencesStore {

    override val sharedPreferences: SharedPreferences by lazy {
        application.getSharedPreferences(name, MODE_PRIVATE)
    }
}

@Suppress("FunctionName")
fun SharedPreferencesStore(
        activity: Activity
): SharedPreferencesStore = object : SharedPreferencesStore {

    override val sharedPreferences: SharedPreferences by lazy {
        activity.getPreferences(MODE_PRIVATE)
    }
}



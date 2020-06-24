package io.ashdavies.preferences

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineStart.LAZY
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.LazyThreadSafetyMode.NONE

internal class CoroutinePreferencesStore(
    application: Application,
    name: String
) : SharedPreferencesStore {

    private val _sharedPreferences: Deferred<SharedPreferences> = GlobalScope.async(start = LAZY) {
        application.getSharedPreferences(name, MODE_PRIVATE)
    }

    override val sharedPreferences: SharedPreferences by lazy(NONE) {
        runBlocking { _sharedPreferences.await() }
    }
}

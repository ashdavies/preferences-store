package io.ashdavies.preferences

import android.app.Application
import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineStart.LAZY
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.LazyThreadSafetyMode.NONE

@ExperimentalCoroutinesApi
internal class CoroutinePreferencesStore(
    application: Application,
    name: String
) : SharedPreferencesStore {

    private val coroutinePreferences: CoroutineValue<SharedPreferences> =
        CoroutineSharedPreferences(
            application = application,
            name = name
        )

    private val _sharedPreferences: Deferred<SharedPreferences> =
        GlobalScope.async(start = LAZY) {
            coroutinePreferences.get()
        }

    override val sharedPreferences: SharedPreferences
        by lazy(NONE) {
            runBlocking { _sharedPreferences.await() }
        }
}

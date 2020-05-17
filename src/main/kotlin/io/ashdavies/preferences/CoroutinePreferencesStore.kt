package io.ashdavies.preferences

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.LazyThreadSafetyMode.NONE
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

internal class CoroutinePreferencesStore(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    application: Application,
    name: String
) : SharedPreferencesStore {

    private val coroutineScope: CoroutineScope = CoroutineScope(Default + coroutineContext)

    private val _sharedPreferences: Deferred<SharedPreferences> = coroutineScope.async {
        application.getSharedPreferences(name, MODE_PRIVATE)
    }

    override val sharedPreferences: SharedPreferences by lazy(NONE) {
        runBlocking { _sharedPreferences.await() }
    }
}

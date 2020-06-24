package io.ashdavies.preferences

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

internal class CoroutineSharedPreferences(
    private val application: Application,
    private val name: String
) : CoroutineValue<SharedPreferences> {

    override suspend fun get(): SharedPreferences =
        suspendCancellableCoroutine {
            it.resume(application.getSharedPreferences(name, MODE_PRIVATE))
        }
}

package io.ashdavies.preferences

internal interface CoroutineValue<T> {

    suspend fun get(): T
}

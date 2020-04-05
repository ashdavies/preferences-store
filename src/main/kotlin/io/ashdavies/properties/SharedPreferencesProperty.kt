package io.ashdavies.properties

import io.ashdavies.preferences.SharedPreferencesStore
import kotlin.properties.ReadWriteProperty

typealias SharedPreferencesProperty<T> = ReadWriteProperty<SharedPreferencesStore, T>

package io.ashdavies.properties

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal abstract class NamedReadWriteProperty<R, T> : ReadWriteProperty<R, T> {

    final override fun getValue(
            thisRef: R,
            property: KProperty<*>
    ): T = getValue(thisRef, property.name)

    abstract fun getValue(
            thisRef: R,
            key: String
    ): T

    final override fun setValue(
            thisRef: R,
            property: KProperty<*>,
            value: T
    ): Unit = setValue(thisRef, property.name, value)

    abstract fun setValue(
            thisRef: R,
            key: String,
            value: T
    )
}

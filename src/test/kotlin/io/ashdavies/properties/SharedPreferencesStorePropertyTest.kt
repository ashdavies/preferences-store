package io.ashdavies.properties

import android.content.SharedPreferences
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.*
import io.ashdavies.extensions.string
import io.ashdavies.extensions.stringOrDefault
import io.ashdavies.extensions.stringOrNull
import io.ashdavies.preferences.SharedPreferencesStore
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.function.ThrowingRunnable

internal class SharedPreferencesPropertyTest : SharedPreferencesStore {

    private var defaultProperty: String by stringOrDefault("DEFAULT")
    private var nullableProperty: String? by stringOrNull()
    private var notNullProperty: String by string()

    private val preferencesEditor: SharedPreferences.Editor = mock()
    override val sharedPreferences: SharedPreferences = mock {
        on { edit() } doReturn preferencesEditor
    }

    @Test
    fun `should get default shared preferences default value`() {
        assertThat(defaultProperty).isEqualTo("DEFAULT")
    }

    @Test
    fun `should get nullable shared preferences null value`() {
        assertThat(nullableProperty).isNull()
    }

    @Test
    fun `should get not null shared preferences not null value`() {
        given(sharedPreferences.getString(eq("notNullProperty"), anyOrNull())).willReturn("Hello World")

        assertThat(notNullProperty).isEqualTo("Hello World")
    }

    @Test
    fun `should set not null shared preferences not null value`() {
        given(preferencesEditor.putString(any(), anyOrNull())).willReturn(preferencesEditor)

        notNullProperty = "Hello World"

        then(preferencesEditor)
                .should()
                .putString("notNullProperty", "Hello World")
    }

    @Test
    fun `should throw not null shared preferences null value`() {
        assertThrows<IllegalArgumentException> {
            notNullProperty
        }
    }

    private inline fun <reified T : Throwable> assertThrows(noinline block: () -> Unit) {
        assertThrows(T::class.java, ThrowingRunnable(block))
    }
}

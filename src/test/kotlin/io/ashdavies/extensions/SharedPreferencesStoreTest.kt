package io.ashdavies.extensions

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.common.truth.Truth.assertThat
import io.ashdavies.content.TestSharedPreferences
import io.ashdavies.preferences.SharedPreferencesStore
import io.ashdavies.preferences.remove
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.function.ThrowingRunnable

internal class SharedPreferencesPropertyTest : SharedPreferencesStore {

    private var defaultProperty: String by stringOrDefault("DEFAULT")
    private var legacyProperty: String? by stringOrNull("nullableProperty")
    private var nullableProperty: String? by stringOrNull()
    private var notNullProperty: String by string()

    override val sharedPreferences: SharedPreferences = TestSharedPreferences()

    @Test
    fun `should get default shared preferences default value`() {
        assertThat(defaultProperty).isEqualTo("DEFAULT")
    }

    @Test
    fun `should update from legacy value`() {
        nullableProperty = "Hello World!"

        assertThat(legacyProperty).isEqualTo("Hello World!")
    }

    @Test
    fun `should get nullable shared preferences null value`() {
        assertThat(nullableProperty).isNull()
    }

    @Test
    fun `should get not null shared preferences not null value`() {
        sharedPreferences.edit {
            putString("notNullProperty", "Hello World")
        }

        assertThat(notNullProperty).isEqualTo("Hello World")
    }

    @Test
    fun `should set not null shared preferences not null value`() {
        notNullProperty = "Hello World"

        assertThat(notNullProperty).isEqualTo("Hello World")
    }

    @Test
    fun `should throw not null shared preferences null value`() {
        assertThrows<IllegalArgumentException> { notNullProperty }
    }

    @Test
    fun `should remove preferences value`() {
        nullableProperty = "Hello World"

        remove(::nullableProperty)

        assertThat(nullableProperty).isNull()
    }

    private inline fun <reified T : Throwable> assertThrows(noinline block: () -> Unit) {
        assertThrows(T::class.java, ThrowingRunnable(block))
    }
}

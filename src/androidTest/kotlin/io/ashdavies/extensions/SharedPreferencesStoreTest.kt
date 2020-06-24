package io.ashdavies.extensions

import androidx.core.content.edit
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import io.ashdavies.preferences.SharedPreferencesStore
import io.ashdavies.preferences.remove
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.function.ThrowingRunnable
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
internal class SharedPreferencesPropertyTest : SharedPreferencesStore by SharedPreferencesStore(
    name = SharedPreferencesPropertyTest::class.java.simpleName,
    application = getApplicationContext()
) {

    private var defaultProperty: String by stringOrDefault("DEFAULT")
    private var legacyProperty: String? by stringOrNull("nullableProperty")
    private var nullableProperty: String? by stringOrNull()
    private var notNullProperty: String by string()

    @Test
    fun shouldGetDefaultSharedPreferencesDefaultValue() {
        assertThat(defaultProperty).isEqualTo("DEFAULT")
    }

    @Test
    fun shouldUpdateFromLegacyValue() {
        nullableProperty = "Hello World!"

        assertThat(legacyProperty).isEqualTo("Hello World!")
    }

    @Test
    fun shouldGetNullableSharedPreferencesNullValue() {
        assertThat(nullableProperty).isNull()
    }

    @Test
    fun shouldGetNotNullSharedPreferencesNotNullValue() {
        sharedPreferences.edit {
            putString("notNullProperty", "Hello World")
        }

        assertThat(notNullProperty).isEqualTo("Hello World")
    }

    @Test
    fun shouldSetNotNullSharedPreferencesNotNullValue() {
        notNullProperty = "Hello World"

        assertThat(notNullProperty).isEqualTo("Hello World")
    }

    @Test
    fun shouldThrowNotNullSharedPreferencesNullValue() {
        assertThrows<IllegalArgumentException> { notNullProperty }
    }

    @Test
    fun shouldRemovePreferencesValue() {
        nullableProperty = "Hello World"

        remove(::nullableProperty)

        assertThat(nullableProperty).isNull()
    }

    private inline fun <reified T : Throwable> assertThrows(noinline block: () -> Unit) {
        assertThrows(T::class.java, ThrowingRunnable(block))
    }
}

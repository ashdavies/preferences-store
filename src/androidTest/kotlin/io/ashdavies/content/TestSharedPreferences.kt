package io.ashdavies.content

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.content.SharedPreferences.OnSharedPreferenceChangeListener

internal class TestSharedPreferences : SharedPreferences {

    private val listeners: MutableList<OnSharedPreferenceChangeListener> = mutableListOf()
    private val map: MutableMap<String, Any?> = mutableMapOf()

    override fun getAll(): Map<String, *> {
        return map.toMap()
    }

    override fun getString(key: String, defValue: String?): String? {
        return map[key] as String? ?: defValue
    }

    @Suppress("UNCHECKED_CAST")
    override fun getStringSet(key: String, defValues: MutableSet<String>?): Set<String>? {
        return map[key] as Set<String>? ?: defValues
    }

    override fun getInt(key: String, defValue: Int): Int {
        return map[key] as Int? ?: defValue
    }

    override fun getLong(key: String, defValue: Long): Long {
        return map[key] as Long? ?: defValue
    }

    override fun getFloat(key: String, defValue: Float): Float {
        return map[key] as Float? ?: defValue
    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        return map[key] as Boolean? ?: defValue
    }

    override fun contains(key: String): Boolean {
        return map.contains(key)
    }

    override fun edit(): Editor {
        return TestEditor(this)
    }

    override fun registerOnSharedPreferenceChangeListener(listener: OnSharedPreferenceChangeListener) {
        listeners.add(listener)
    }

    override fun unregisterOnSharedPreferenceChangeListener(listener: OnSharedPreferenceChangeListener) {
        listeners.remove(listener)
    }

    private fun commit(values: Map<String, Any?>): Boolean {
        map += values
        notifyListeners(values.keys)
        return true
    }

    private fun notifyListeners(keys: Set<String>) {
        listeners.forEach { listener: OnSharedPreferenceChangeListener ->
            keys.forEach { key: String ->
                listener.onSharedPreferenceChanged(this, key)
            }
        }
    }

    private class TestEditor(private val preferences: TestSharedPreferences) : Editor {

        private val map: MutableMap<String, Any?> = mutableMapOf()

        override fun putString(key: String, value: String?): Editor {
            map[key] = value
            return this
        }

        override fun putStringSet(key: String, values: MutableSet<String>?): Editor {
            map[key] = values
            return this
        }

        override fun putInt(key: String, value: Int): Editor {
            map[key] = value
            return this
        }

        override fun putLong(key: String, value: Long): Editor {
            map[key] = value
            return this
        }

        override fun putFloat(key: String, value: Float): Editor {
            map[key] = value
            return this
        }

        override fun putBoolean(key: String, value: Boolean): Editor {
            map[key] = value
            return this
        }

        override fun remove(key: String): Editor {
            map[key] = null
            return this
        }

        override fun clear(): Editor {
            map.clear()
            return this
        }

        override fun commit(): Boolean {
            return preferences.commit(map)
        }

        override fun apply() {
            commit()
        }
    }
}

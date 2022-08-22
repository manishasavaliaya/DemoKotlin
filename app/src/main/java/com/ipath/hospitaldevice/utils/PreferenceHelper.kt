package com.ipath.hospitaldevice.utils


import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    internal constructor(context: Context?) {
        preferences =
            context!!.getSharedPreferences("IpathHealthCare", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    internal constructor(context: Context, name: String?, mode: Int) {
        preferences = context.getSharedPreferences(name, mode)
        editor = preferences.edit()
    }

    fun clearAll() {
        editor.clear().commit()
    }

    fun save(key: String?, value: Boolean) {
        editor.putBoolean(key, value).commit()
    }

    fun save(key: String?, value: String?) {
        editor.putString(key, value).commit()
    }

    fun save(key: String?, value: Int) {
        editor.putInt(key, value).commit()
    }

    fun save(key: String?, value: Float) {
        editor.putFloat(key, value).commit()
    }

    fun save(key: String?, value: Long) {
        editor.putLong(key, value).commit()
    }

    fun save(key: String?, value: Set<String?>?) {
        editor.putStringSet(key, value).commit()
    }

    fun getBoolean(key: String?, defValue: Boolean = false): Boolean {
        return preferences.getBoolean(key, defValue)
    }

    fun getString(key: String?, defValue: String = ""): String {
        return preferences.getString(key, defValue)!!
    }

    fun getInt(key: String?, defValue: Int = 0): Int {
        return preferences.getInt(key, defValue)
    }

    fun getFloat(key: String?, defValue: Float): Float {
        return preferences.getFloat(key, defValue)
    }

    fun getLong(key: String?, defValue: Long): Long {
        return preferences.getLong(key, defValue)
    }

    fun getStringSet(key: String?, defValue: Set<String?>?): Set<String> {
        return preferences.getStringSet(key, defValue)!!
    }

    val all: Map<String, *>
        get() = preferences.getAll()

    fun remove(key: String?) {
        editor.remove(key).commit()
    }

    fun removeAll() {
        editor.clear().commit()
    }

    fun contains(key: String?) {
        preferences.contains(key)
    }

    fun registerOnSharedPreferenceChangeListener(prefChangeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
        preferences.registerOnSharedPreferenceChangeListener(prefChangeListener)
    }

    private class Builder(context: Context?, name: String?, mode: Int) {
        private val context: Context
        private val mode: Int
        private val name: String?

        /**
         * Method that creates an instance of Prefs
         *
         * @return an instance of Prefs
         */
        fun build(): PreferenceHelper {
            return if (mode == -1 || name == null) {
                PreferenceHelper(context)
            } else PreferenceHelper(context, name, mode)
        }

        init {
            requireNotNull(context) { "Context must not be null." }
            this.context = context.applicationContext
            this.name = name
            this.mode = mode
        }
    }

    companion object {
        var singleton: PreferenceHelper? = null
        lateinit var preferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
        fun with(context: Context?): PreferenceHelper {
            if (singleton == null) {
                singleton = Builder(context, null, -1).build()
            }
            return singleton!!
        }

        fun with(context: Context?, name: String?, mode: Int): PreferenceHelper {
            if (singleton == null) {
                singleton = Builder(context, name, mode).build()
            }
            return singleton!!
        }
    }
}
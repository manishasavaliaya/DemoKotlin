package com.ipath.hospitaldevice.utils

import android.content.SharedPreferences
import com.ipath.hospitaldevice.ui.App
import com.ipath.hospitaldevice.utils.PreferenceHelper


class UserPreferenceHelper {


    private val USER_ID = "USER_ID"

    companion object {
        val USER_TOKEN = "USER_TOKEN"
        private val DEFAULT_FILTER = "DEFAULT_FILTER"
        private val USER_FIRST_NAME = "USER_FIRST_NAME"
        private val ADDRESS = "address"
        private val IMAGEURL = "imageUrl"
        private val USER_LAST_NAME = "USER_LAST_NAME"
        private val USER_EMAIL = "USER_EMAIL"

        private val LOCATION_PERMISSION = "LOCATION_PERMISSION"
        private val EXTERNAL_PERMISSION = "EXTERNAL_PERMISSION"
        private val CAMERA_PERMISSION = "CAMERA_PERMISSION"

        private var userPref: UserPreferenceHelper? = null
        fun getInstance(): UserPreferenceHelper {
            if (userPref == null)
                userPref = UserPreferenceHelper()
            return userPref!!
        }

    }


    private var pref = PreferenceHelper(App.getContext())


    var isCameraPermission: Boolean
        get() {
            return pref.getBoolean(CAMERA_PERMISSION)
        }
        set(value) {
            pref.save(CAMERA_PERMISSION, value)
        }
    var isReadStoragePermission: Boolean
        get() {
            return pref.getBoolean(EXTERNAL_PERMISSION)
        }
        set(value) {
            pref.save(EXTERNAL_PERMISSION, value)
        }

    var fName: String
        get() {
            return pref.getString(USER_FIRST_NAME)
        }
        set(value) {
            pref.save(USER_FIRST_NAME, value)
        }
    var address: String
        get() {
            return pref.getString(ADDRESS)
        }
        set(value) {
            pref.save(ADDRESS, value)
        }
    var imageUrl: String
        get() {
            return pref.getString(IMAGEURL)
        }
        set(value) {
            pref.save(IMAGEURL, value)
        }
    var defaultFilter: String
        get() {
            return pref.getString(DEFAULT_FILTER)
        }
        set(value) {
            pref.save(DEFAULT_FILTER, value)
        }
    var lName: String
        get() {
            return pref.getString(USER_LAST_NAME)
        }
        set(value) {
            pref.save(USER_LAST_NAME, value)
        }

    var email: String
        get() {
            return pref.getString(USER_EMAIL)
        }
        set(value) {
            pref.save(USER_EMAIL, value)
        }


    var token: String
        get() {
            return pref.getString(USER_TOKEN)
        }
        set(value) {
            pref.save(USER_TOKEN, value)
        }


    fun clear() {
        pref.clearAll()
    }

    fun registerOnSharedPreferenceChangeListener(prefChangeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
        pref.registerOnSharedPreferenceChangeListener(prefChangeListener)
    }
}

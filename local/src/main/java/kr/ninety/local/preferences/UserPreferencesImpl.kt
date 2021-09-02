package kr.ninety.local.preferences

import android.content.Context
import javax.inject.Inject

class UserPreferencesImpl @Inject constructor(
    private val context: Context
) : UserPreferences {

    private val preferences by lazy {
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    override fun getToken(): String {
        return preferences.getString(KEY_TOKEN, "")!!
    }

    companion object {
        private const val PREFERENCE_NAME = "USER"
        private const val KEY_TOKEN = "TOKEN"
    }
}
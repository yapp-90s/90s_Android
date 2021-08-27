package kr.ninety.local.preferences

import android.content.SharedPreferences
import javax.inject.Inject

class UserPreferencesImpl @Inject constructor(
    private val privatePreferences: SharedPreferences
) : UserPreferences {

    override fun getToken(): String {
        return privatePreferences.getString(KEY_TOKEN, "")!!
    }

    companion object {
        private const val KEY_TOKEN = "TOKEN"
    }
}
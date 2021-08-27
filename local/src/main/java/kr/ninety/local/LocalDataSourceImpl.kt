package kr.ninety.local

import kr.ninety.data.local.LocalDataSource
import kr.ninety.local.preferences.UserPreferences
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val userPreferences: UserPreferences
): LocalDataSource {

    override fun getUserToken(): String {
        return userPreferences.getToken()
    }
}
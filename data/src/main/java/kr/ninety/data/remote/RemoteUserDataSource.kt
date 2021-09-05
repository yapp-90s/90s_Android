package kr.ninety.data.remote

import io.reactivex.Single
import kr.ninety.data.remote.model.User

interface RemoteUserDataSource {
    fun login(userInfo: User.Info): Single<User.JsonToken>
    fun checkPhoneNumber(userPhone: User.Phone): Single<User.AuthCode>
}
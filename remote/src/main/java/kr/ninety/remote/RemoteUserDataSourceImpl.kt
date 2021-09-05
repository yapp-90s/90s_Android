package kr.ninety.remote

import io.reactivex.Single
import kr.ninety.data.remote.RemoteUserDataSource
import kr.ninety.data.remote.model.User
import kr.ninety.remote.api.UserApi
import kr.ninety.remote.mapper.toData
import kr.ninety.remote.mapper.toRemote
import kr.ninety.remote.response.user.AuthCodeResponse
import kr.ninety.remote.response.user.JsonTokenResponse
import javax.inject.Inject

class RemoteUserDataSourceImpl @Inject constructor(
    private val userApi: UserApi,
) : RemoteUserDataSource {

    override fun login(userInfo: User.Info): Single<User.JsonToken> {
        return userApi.postUserLogin(userInfo.toRemote()).map(JsonTokenResponse::toData)
    }

    override fun checkPhoneNumber(userPhone: User.Phone): Single<User.AuthCode> {
        return userApi.postUserCheckPhoneNumber(userPhone.toRemote()).map(AuthCodeResponse::toData)
    }
}
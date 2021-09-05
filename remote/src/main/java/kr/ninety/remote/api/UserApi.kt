package kr.ninety.remote.api

import io.reactivex.Single
import kr.ninety.remote.request.user.LoginRequest
import kr.ninety.remote.request.user.PhoneRequest
import kr.ninety.remote.response.user.AuthCodeResponse
import kr.ninety.remote.response.user.JsonTokenResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @POST("user/login")
    fun postUserLogin(
        @Body loginRequest: LoginRequest
    ): Single<JsonTokenResponse>

    @POST("user/checkPhoneNum")
    fun postUserCheckPhoneNumber(
        @Body phoneRequest: PhoneRequest
    ): Single<AuthCodeResponse>
}

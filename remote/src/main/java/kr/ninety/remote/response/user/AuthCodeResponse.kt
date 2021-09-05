package kr.ninety.remote.response.user

import com.google.gson.annotations.SerializedName
import kr.ninety.remote.response.Response

data class AuthCodeResponse(
    @SerializedName("num") val authCode: String
): Response
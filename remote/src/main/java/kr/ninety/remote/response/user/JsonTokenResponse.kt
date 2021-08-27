package kr.ninety.remote.response.user

import com.google.gson.annotations.SerializedName
import kr.ninety.remote.response.Response

data class JsonTokenResponse(
    @SerializedName("jwt") val jsonToken: String
): Response
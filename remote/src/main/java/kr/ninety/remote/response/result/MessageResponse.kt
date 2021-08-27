package kr.ninety.remote.response.result

import com.google.gson.annotations.SerializedName
import kr.ninety.remote.response.Response

data class MessageResponse(
    val result: Boolean,
    @SerializedName("msg") val message: String?
): Response
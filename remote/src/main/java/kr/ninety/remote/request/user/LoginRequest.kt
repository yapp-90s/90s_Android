package kr.ninety.remote.request.user

import kr.ninety.remote.request.Request

data class LoginRequest(
    val emailKakao: String? = "",
    val emailApple: String? = "",
    val emailGoogle: String? = "",
    val phoneNum: String
): Request
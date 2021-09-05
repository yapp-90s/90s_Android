package kr.ninety.remote.request.user

import kr.ninety.remote.request.Request

data class PhoneRequest(
    val phoneNumber: String
): Request
package kr.ninety.data.remote.model

sealed class User {

    data class AuthCode(
        val authCode: String
    ): User()

    data class JsonToken(
        val jsonToken: String
    ): User()

    data class Info(
        val emailKakao: String?,
        val emailApple: String?,
        val emailGoogle: String?,
        val phoneNum: String
    ): User()

    data class Phone(
        val phoneNumber: String
    ): User()
}

package kr.ninety.remote.response.film

import kr.ninety.remote.response.Response

data class FilmResponse(
    val createdAt: String,
    val deleteAt: String?,
    val filmType: FilmType,
    val name: String,
    val printEndAt: String?,
    val printStartAt: String?,
    val uid: Int,
    val user: User
): Response {
    data class FilmType(
        val code: Int,
        val createdAt: String,
        val description: String,
        val max: Int,
        val name: String,
        val releasedAt: String?,
        val uid: Int,
        val updatedAt: String
    )

    data class User(
        val accountNonExpired: Boolean,
        val accountNonLocked: Boolean,
        val authorities: List<Authority>,
        val createdAt: String,
        val credentialsNonExpired: Boolean,
        val emailApple: String,
        val emailGoogle: String,
        val emailKakao: String,
        val enabled: Boolean,
        val jwt: String,
        val name: String,
        val password: String?,
        val phoneNum: String,
        val roles: List<String>,
        val uid: Int,
        val updatedAt: String,
        val username: String
    ) {
        data class Authority(
            val authority: String
        )
    }
}
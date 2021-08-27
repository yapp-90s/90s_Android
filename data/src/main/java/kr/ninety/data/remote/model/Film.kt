package kr.ninety.data.remote.model

sealed class Film {

    data class Meta(
        val filmCode: Int,
        val name: String
    ): Film()

    data class Item(
        val createdAt: String,
        val deleteAt: String,
        val filmType: Type,
        val name: String,
        val printEndAt: String?,
        val printStartAt: String?,
        val uid: Int,
        val user: User
    ): Film()

    data class Type(
        val code: Int,
        val createdAt: String,
        val description: String,
        val max: Int,
        val name: String,
        val releasedAt: String?,
        val uid: Int,
        val updatedAt: String
    ): Film()

    data class User(
        val accountNonExpired: Boolean,
        val accountNonLocked: Boolean,
        val authorities: List<Authority>,
        val created_at: String,
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
        val updated_at: String,
        val username: String
    ): Film()

    data class Authority(
        val authority: String
    ): Film()
}

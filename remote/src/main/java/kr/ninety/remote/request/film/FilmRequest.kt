package kr.ninety.remote.request.film

import kr.ninety.remote.request.Request

data class FilmRequest(
    val filmCode: Int,
    val name: String
): Request
package kr.ninety.remote.response.photo

import kr.ninety.remote.response.Response
import kr.ninety.remote.response.film.FilmResponse

data class PhotoResponse(
    val uid: Int,
    val url: String,
    val film: FilmResponse,
    val createAt: String,
    val updateAt: String
): Response
package kr.ninety.remote.request.album

import kr.ninety.remote.request.Request

data class AlbumCreateRequest(
    val name: String,
    val layoutCode: Int,
    val coverCode: Int
): Request

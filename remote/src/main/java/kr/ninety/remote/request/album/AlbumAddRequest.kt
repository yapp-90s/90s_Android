package kr.ninety.remote.request.album

import kr.ninety.remote.request.Request

data class AlbumAddRequest(
    val photoUid: Int,
    val albumUid: Int,
    val paperNum: Int,
    val sequence: Int
): Request
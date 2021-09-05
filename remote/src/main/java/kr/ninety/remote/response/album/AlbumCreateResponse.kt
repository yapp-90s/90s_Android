package kr.ninety.remote.response.album

import kr.ninety.remote.response.Response

data class AlbumCreateResponse(
    val albumCover: AlbumCover,
    val albumLayout: AlbumLayout,
    val completedAt: String?,
    val createdAt: String,
    val name: String,
    val uid: Int,
    val updatedAt: String
): Response {

    data class AlbumCover(
        val code: Int,
        val createdAt: String,
        val description: String?,
        val name: String,
        val path: String?,
        val releasedAt: String?,
        val uid: Int
    )

    data class AlbumLayout(
        val code: Int,
        val createdAt: String,
        val description: String?,
        val name: String,
        val path: String?,
        val photoPerPaper: Int,
        val releasedAt: String?,
        val totPaper: Int,
        val uid: Int
    )
}
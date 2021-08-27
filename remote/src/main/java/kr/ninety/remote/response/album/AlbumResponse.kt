package kr.ninety.remote.response.album

import kr.ninety.remote.response.Response

data class AlbumResponse(
    val complete: Boolean,
    val count: Int,
    val cover: Cover,
    val createdAt: String,
    val endDate: String,
    val layout: Int,
    val name: String,
    val orderStatus: OrderStatus,
    val password: String,
    val photoLimit: Int,
    val uid: Int,
    val updatedAt: String
): Response {
    data class Cover(
        val name: String,
        val path: String,
        val uid: Int
    )

    data class OrderStatus(
        val status: String,
        val uid: Int
    )
}
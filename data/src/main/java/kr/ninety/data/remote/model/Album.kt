package kr.ninety.data.remote.model

sealed class Album {

    data class Meta(
        val name: String,
        val layoutCode: Int,
        val coverCode: Int
    ): Album()

    data class Info(
        val photoUid: Int,
        val albumUid: Int,
        val paperNum: Int,
        val sequence: Int
    ): Album()

    data class Data(
        val albumCover: AlbumCover,
        val albumLayout: AlbumLayout,
        val completedAt: String?,
        val createdAt: String,
        val name: String,
        val uid: Int,
        val updatedAt: String
    ): Album() {
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

    data class Item(
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
    ): Album() {
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
}

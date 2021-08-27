package kr.ninety.data.remote.model

sealed class Photo {

    data class Item(
        val uid: Int,
        val url: String,
        val film: Film.Item,
        val createAt: String,
        val updateAt: String
    ): Photo()
}

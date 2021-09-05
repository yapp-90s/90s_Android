package kr.ninety.data.remote

import io.reactivex.Single
import kr.ninety.data.remote.model.Album
import kr.ninety.data.remote.model.Message

interface RemoteAlbumDataSource {
    fun createAlbum(albumMeta: Album.Meta): Single<Album.Data>
    fun getAlbum(): Single<List<Album.Item>>
    fun addPhotoInAlbum(albumMeta: Album.Info): Single<Message>
    fun completeAlbum(albumUid: String): Single<Message>
    fun deleteAlbum(albumUid: String): Single<Message>
}
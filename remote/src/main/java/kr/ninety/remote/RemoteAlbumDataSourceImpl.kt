package kr.ninety.remote

import io.reactivex.Single
import kr.ninety.data.remote.RemoteAlbumDataSource
import kr.ninety.data.remote.model.Album
import kr.ninety.data.remote.model.Message
import kr.ninety.remote.api.AlbumApi
import kr.ninety.remote.mapper.toData
import kr.ninety.remote.mapper.toRemote
import kr.ninety.remote.response.album.AlbumCreateResponse
import kr.ninety.remote.response.album.AlbumResponse
import kr.ninety.remote.response.result.MessageResponse
import javax.inject.Inject

class RemoteAlbumDataSourceImpl @Inject constructor(
    private val albumApi: AlbumApi
) : RemoteAlbumDataSource {

    override fun createAlbum(albumMeta: Album.Meta): Single<Album.Data> {
        return albumApi.postAlbumCreate(albumMeta.toRemote()).map(AlbumCreateResponse::toData)
    }

    override fun getAlbum(): Single<List<Album.Item>> {
        return albumApi.getAlbums().map { it.map(AlbumResponse::toData) }
    }

    override fun addPhotoInAlbum(albumMeta: Album.Info): Single<Message> {
        return albumApi.postAddPhotoInAlbum(albumMeta.toRemote()).map(MessageResponse::toData)
    }

    override fun completeAlbum(albumUid: String): Single<Message> {
        return albumApi.getAlbumComplete(albumUid).map(MessageResponse::toData)
    }

    override fun deleteAlbum(albumUid: String): Single<Message> {
        return albumApi.deleteAlbum(albumUid).map(MessageResponse::toData)
    }
}
package kr.ninety.remote

import io.reactivex.Single
import kr.ninety.data.remote.RemoteDataSource
import kr.ninety.data.remote.model.User
import kr.ninety.data.remote.model.Film
import kr.ninety.data.remote.model.Message
import kr.ninety.data.remote.model.Photo
import kr.ninety.data.remote.model.Album
import kr.ninety.remote.api.AlbumApi
import kr.ninety.remote.api.FilmApi
import kr.ninety.remote.api.PhotoApi
import kr.ninety.remote.api.UserApi
import kr.ninety.remote.mapper.toData
import kr.ninety.remote.mapper.toRemote
import kr.ninety.remote.response.result.MessageResponse
import kr.ninety.remote.response.album.AlbumCreateResponse
import kr.ninety.remote.response.album.AlbumResponse
import kr.ninety.remote.response.film.FilmResponse
import kr.ninety.remote.response.photo.PhotoResponse
import kr.ninety.remote.response.user.AuthCodeResponse
import kr.ninety.remote.response.user.JsonTokenResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val userApi: UserApi,
    private val filmApi: FilmApi,
    private val photoApi: PhotoApi,
    private val albumApi: AlbumApi
) : RemoteDataSource {

    override fun login(userInfo: User.Info): Single<User.JsonToken> {
        return userApi.postUserLogin(userInfo.toRemote()).map(JsonTokenResponse::toData)
    }

    override fun checkPhoneNumber(userPhone: User.Phone): Single<User.AuthCode> {
        return userApi.postUserCheckPhoneNumber(userPhone.toRemote()).map(AuthCodeResponse::toData)
    }

    override fun createFilm(filmMeta: Film.Meta): Single<Film.Item> {
        return filmApi.postFilmCreate(filmMeta.toRemote()).map(FilmResponse::toData)
    }

    override fun getFilm(): Single<List<Film.Item>> {
        return filmApi.getFilm().map { it.map(FilmResponse::toData) }
    }

    override fun printingFilm(filmUid: String): Single<Message> {
        return filmApi.getFilmStartPrinting(filmUid).map(MessageResponse::toData)
    }

    override fun deleteFilm(filmUid: String): Single<Message> {
        return filmApi.deleteFilm(filmUid).map(MessageResponse::toData)
    }

    override fun uploadPhoto(filmUid: String): Single<Photo.Item> {
        return photoApi.postPhotoUpload(filmUid).map(PhotoResponse::toData)
    }

    override fun downloadPhoto(photoUid: String): Single<Photo.Item> {
        return photoApi.getPhotoDownload(photoUid).map(PhotoResponse::toData)
    }

    override fun getPhotoInfo(filmUid: String): Single<List<Photo.Item>> {
        return photoApi.getPhotoInfoByFilm(filmUid).map { it.map(PhotoResponse::toData) }
    }

    override fun deletePhoto(filmUid: String): Single<Message> {
        return photoApi.deletePhoto(filmUid).map(MessageResponse::toData)
    }

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
package kr.ninety.data.remote

import io.reactivex.Single
import kr.ninety.data.remote.model.*

interface RemoteDataSource {
    fun login(userInfo: User.Info): Single<User.JsonToken>
    fun checkPhoneNumber(userPhone: User.Phone): Single<User.AuthCode>

    fun createFilm(filmMeta: Film.Meta): Single<Film.Item>
    fun getFilm(): Single<List<Film.Item>>
    fun printingFilm(filmUid: String): Single<Message>
    fun deleteFilm(filmUid: String): Single<Message>

    fun uploadPhoto(filmUid: String): Single<Photo.Item>
    fun downloadPhoto(photoUid: String): Single<Photo.Item>
    fun getPhotoInfo(filmUid: String): Single<List<Photo.Item>>
    fun deletePhoto(filmUid: String): Single<Message>

    fun createAlbum(albumMeta: Album.Meta): Single<Album.Data>
    fun getAlbum(): Single<List<Album.Item>>
    fun addPhotoInAlbum(albumMeta: Album.Info): Single<Message>
    fun completeAlbum(albumUid: String): Single<Message>
    fun deleteAlbum(albumUid: String): Single<Message>
}
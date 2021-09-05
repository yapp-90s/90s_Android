package kr.ninety.data.remote

import io.reactivex.Single
import kr.ninety.data.remote.model.Message
import kr.ninety.data.remote.model.Photo

interface RemotePhotoDataSource {
    fun uploadPhoto(filmUid: String): Single<Photo.Item>
    fun downloadPhoto(photoUid: String): Single<Photo.Item>
    fun getPhotoInfo(filmUid: String): Single<List<Photo.Item>>
    fun deletePhoto(filmUid: String): Single<Message>
}
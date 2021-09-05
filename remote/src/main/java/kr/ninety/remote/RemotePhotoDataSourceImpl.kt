package kr.ninety.remote

import io.reactivex.Single
import kr.ninety.data.remote.RemotePhotoDataSource
import kr.ninety.data.remote.model.Message
import kr.ninety.data.remote.model.Photo
import kr.ninety.remote.api.PhotoApi
import kr.ninety.remote.mapper.toData
import kr.ninety.remote.response.photo.PhotoResponse
import kr.ninety.remote.response.result.MessageResponse
import javax.inject.Inject

class RemotePhotoDataSourceImpl  @Inject constructor(
    private val photoApi: PhotoApi
) : RemotePhotoDataSource {

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
}
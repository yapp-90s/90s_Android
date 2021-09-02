package kr.ninety.remote.api

import io.reactivex.Single
import kr.ninety.remote.response.result.MessageResponse
import kr.ninety.remote.response.photo.PhotoResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PhotoApi {

    @POST("photo/upload/{filmUid}")
    fun postPhotoUpload(
        @Path("filmUid") filmUid: String
    ): Single<PhotoResponse>

    @GET("photo/download/{photoUid}")
    fun getPhotoDownload(
        @Path("photoUid") photoUid: String
    ): Single<PhotoResponse>

    @GET("photo/getPhotoInfosByFilm/{filmUid}")
    fun getPhotoInfoByFilm(
        @Path("filmUid") filmUid: String
    ): Single<List<PhotoResponse>>

    @DELETE("photo/delete/{filmUid}")
    fun deletePhoto(
        @Path("filmUid") filmUid: String
    ): Single<MessageResponse>
}
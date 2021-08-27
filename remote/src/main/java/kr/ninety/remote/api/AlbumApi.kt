package kr.ninety.remote.api

import io.reactivex.Single
import kr.ninety.remote.request.album.AlbumAddRequest
import kr.ninety.remote.request.album.AlbumCreateRequest
import kr.ninety.remote.response.result.MessageResponse
import kr.ninety.remote.response.album.AlbumCreateResponse
import kr.ninety.remote.response.album.AlbumResponse
import retrofit2.http.*

interface AlbumApi {

    @POST("album/create")
    fun postAlbumCreate(
        @Body albumCreateRequest: AlbumCreateRequest
    ): Single<AlbumCreateResponse>

    @GET("album/getAlbums")
    fun getAlbums(): Single<List<AlbumResponse>>

    @POST("album/addPhotoInAlbum")
    fun postAddPhotoInAlbum(
        @Body albumAddRequest: AlbumAddRequest
    ): Single<MessageResponse>

    @GET("album/complete/{albumUid}")
    fun getAlbumComplete(
        @Path("albumUid") albumUid: String
    ): Single<MessageResponse>

    @DELETE("album/delete/{albumUid}")
    fun deleteAlbum(
        @Path("albumUid") albumUid: String
    ): Single<MessageResponse>
}
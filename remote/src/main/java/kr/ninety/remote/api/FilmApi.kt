package kr.ninety.remote.api

import io.reactivex.Single
import kr.ninety.remote.request.film.FilmRequest
import kr.ninety.remote.response.result.MessageResponse
import kr.ninety.remote.response.film.FilmResponse
import retrofit2.http.*

interface FilmApi {

    @POST("film/create")
    fun postFilmCreate(
        @Body filmRequest: FilmRequest
    ): Single<FilmResponse>

    @GET("film/getFilms")
    fun getFilm(): Single<List<FilmResponse>>

    @GET("film/startPrinting/{filmUid}")
    fun getFilmStartPrinting(
        @Path("filmUid") filmUid: String
    ): Single<MessageResponse>

    @DELETE("film/delete/{filmUid}")
    fun deleteFilm(
        @Path("filmUid") filmUid: String
    ): Single<MessageResponse>
}
package kr.ninety.remote

import io.reactivex.Single
import kr.ninety.data.remote.RemoteFilmDataSource
import kr.ninety.data.remote.model.Film
import kr.ninety.data.remote.model.Message
import kr.ninety.remote.api.FilmApi
import kr.ninety.remote.mapper.toData
import kr.ninety.remote.mapper.toRemote
import kr.ninety.remote.response.film.FilmResponse
import kr.ninety.remote.response.result.MessageResponse
import javax.inject.Inject

class RemoteFilmDataSourceImpl @Inject constructor(
    private val filmApi: FilmApi
) : RemoteFilmDataSource {

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
}
package kr.ninety.data.remote

import io.reactivex.Single
import kr.ninety.data.remote.model.Film
import kr.ninety.data.remote.model.Message

interface RemoteFilmDataSource {
    fun createFilm(filmMeta: Film.Meta): Single<Film.Item>
    fun getFilm(): Single<List<Film.Item>>
    fun printingFilm(filmUid: String): Single<Message>
    fun deleteFilm(filmUid: String): Single<Message>
}
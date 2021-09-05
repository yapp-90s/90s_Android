package kr.ninety.remote.mapper

import kr.ninety.data.remote.model.Album
import kr.ninety.data.remote.model.Film
import kr.ninety.data.remote.model.User
import kr.ninety.remote.request.album.AlbumAddRequest
import kr.ninety.remote.request.album.AlbumCreateRequest
import kr.ninety.remote.request.film.FilmRequest
import kr.ninety.remote.request.user.LoginRequest
import kr.ninety.remote.request.user.PhoneRequest

fun User.Info.toRemote() = LoginRequest(
    emailKakao, emailApple, emailGoogle, phoneNum
)

fun User.Phone.toRemote() = PhoneRequest(
    phoneNumber
)

fun Film.Meta.toRemote() = FilmRequest(
    filmCode, name
)

fun Album.Meta.toRemote() = AlbumCreateRequest(
    name, layoutCode, coverCode
)

fun Album.Info.toRemote() = AlbumAddRequest(
    photoUid, albumUid, paperNum, sequence
)
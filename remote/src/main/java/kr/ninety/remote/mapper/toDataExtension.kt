package kr.ninety.remote.mapper

import kr.ninety.data.remote.model.*
import kr.ninety.remote.response.result.MessageResponse
import kr.ninety.remote.response.album.AlbumCreateResponse
import kr.ninety.remote.response.album.AlbumResponse
import kr.ninety.remote.response.film.FilmResponse
import kr.ninety.remote.response.photo.PhotoResponse
import kr.ninety.remote.response.user.AuthCodeResponse
import kr.ninety.remote.response.user.JsonTokenResponse

fun JsonTokenResponse.toData() = User.JsonToken(
    jsonToken
)

fun AuthCodeResponse.toData() = User.AuthCode(
    authCode
)

fun MessageResponse.toData() = Message(
    result,
    message ?: ""
)

fun FilmResponse.toData() = Film.Item(
    createdAt,
    deleteAt ?: "",
    filmType.toData(),
    name,
    printEndAt,
    printStartAt,
    uid,
    user.toData()
)

fun FilmResponse.FilmType.toData() = Film.Type(
    code, createdAt, description, max, name, releasedAt, uid, updatedAt
)

fun FilmResponse.User.toData() = Film.User(
    accountNonExpired,
    accountNonLocked,
    authorities.map { it.toData() },
    createdAt,
    credentialsNonExpired,
    emailApple,
    emailGoogle,
    emailKakao,
    enabled,
    jwt,
    name,
    password,
    phoneNum,
    roles,
    uid,
    updatedAt,
    username
)

fun FilmResponse.User.Authority.toData() = Film.Authority(
    authority
)

fun PhotoResponse.toData() = Photo.Item(
    uid, url, film.toData(), createAt, updateAt
)

fun AlbumCreateResponse.toData() = Album.Data(
    albumCover.toData(),
    albumLayout.toData(),
    completedAt,
    createdAt,
    name,
    uid,
    updatedAt
)

fun AlbumCreateResponse.AlbumCover.toData() = Album.Data.AlbumCover(
    code, createdAt, description, name, path, releasedAt, uid
)

fun AlbumCreateResponse.AlbumLayout.toData() = Album.Data.AlbumLayout(
    code, createdAt, description, name, path, photoPerPaper, releasedAt, totPaper, uid
)

fun AlbumResponse.toData() = Album.Item(
    complete,
    count,
    cover.toData(),
    createdAt,
    endDate,
    layout,
    name,
    orderStatus.toData(),
    password,
    photoLimit,
    uid,
    updatedAt
)

fun AlbumResponse.Cover.toData() = Album.Item.Cover(
    name, path, uid
)

fun AlbumResponse.OrderStatus.toData() = Album.Item.OrderStatus(
    status, uid
)
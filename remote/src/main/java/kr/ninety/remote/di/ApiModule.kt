package kr.ninety.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ninety.remote.BuildConfig
import kr.ninety.remote.api.AlbumApi
import kr.ninety.remote.api.FilmApi
import kr.ninety.remote.api.PhotoApi
import kr.ninety.remote.api.UserApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit.Builder): UserApi =
        retrofit
            .baseUrl(BuildConfig.API_BASE_URL)
            .build()
            .create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideFilmApi(retrofit: Retrofit.Builder): FilmApi =
        retrofit
            .baseUrl(BuildConfig.API_BASE_URL)
            .build()
            .create(FilmApi::class.java)

    @Provides
    @Singleton
    fun providePhotoApi(retrofit: Retrofit.Builder): PhotoApi =
        retrofit
            .baseUrl(BuildConfig.API_BASE_URL)
            .build()
            .create(PhotoApi::class.java)

    @Provides
    @Singleton
    fun provideAlbumApi(retrofit: Retrofit.Builder): AlbumApi =
        retrofit
            .baseUrl(BuildConfig.API_BASE_URL)
            .build()
            .create(AlbumApi::class.java)
}

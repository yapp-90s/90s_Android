package kr.ninety.remote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ninety.data.remote.RemoteAlbumDataSource
import kr.ninety.data.remote.RemoteFilmDataSource
import kr.ninety.data.remote.RemotePhotoDataSource
import kr.ninety.data.remote.RemoteUserDataSource
import kr.ninety.remote.RemoteAlbumDataSourceImpl
import kr.ninety.remote.RemoteFilmDataSourceImpl
import kr.ninety.remote.RemotePhotoDataSourceImpl
import kr.ninety.remote.RemoteUserDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideRemoteUserDataSource(
        remoteUserDataSourceImpl: RemoteUserDataSourceImpl
    ): RemoteUserDataSource

    @Binds
    abstract fun provideRemoteFilmDataSource(
        remoteFilmDataSourceImpl: RemoteFilmDataSourceImpl
    ): RemoteFilmDataSource

    @Binds
    abstract fun provideRemotePhotoDataSource(
        remotePhotoDataSourceImpl: RemotePhotoDataSourceImpl
    ): RemotePhotoDataSource

    @Binds
    abstract fun provideRemoteAlbumDataSource(
        remoteAlbumDataSourceImpl: RemoteAlbumDataSourceImpl
    ): RemoteAlbumDataSource
}

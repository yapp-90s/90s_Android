package kr.ninety.local.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ninety.data.local.LocalDataSource
import kr.ninety.local.LocalDataSourceImpl

@Module(
    includes = [
        PreferencesModule::class
    ]
)
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource
}
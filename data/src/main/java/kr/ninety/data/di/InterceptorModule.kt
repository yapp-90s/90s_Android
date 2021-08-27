package kr.ninety.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ninety.data.local.LocalDataSource
import kr.ninety.data.remote.interceptor.HeaderInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InterceptorModule {

    @Provides
    @Singleton
    fun provideHeaderInterceptor(
        localDataSource: LocalDataSource
    ): HeaderInterceptor = HeaderInterceptor(localDataSource)
}
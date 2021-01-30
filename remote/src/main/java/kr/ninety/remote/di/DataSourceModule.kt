/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.remote.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        ApiModule::class,
        RetrofitModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object DataSourceModule {
}

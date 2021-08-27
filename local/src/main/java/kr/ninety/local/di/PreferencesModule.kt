package kr.ninety.local.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.ninety.local.preferences.UserPreferences
import kr.ninety.local.preferences.UserPreferencesImpl
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PreferencesModule {

    @Provides
    @Singleton
    fun provideUserPreferences(
        @Named("userSharedPreferences") preferences: SharedPreferences
    ): UserPreferences = UserPreferencesImpl(preferences)

    @Provides
    @Singleton
    @Named("userSharedPreferences")
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = context.getSharedPreferences(
        "USER", Context.MODE_PRIVATE
    )
}
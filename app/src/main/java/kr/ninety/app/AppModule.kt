package kr.ninety.app

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.ninety.domain.executor.ExecutorProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideExecutorProvider(): ExecutorProvider = object: ExecutorProvider {
        override fun io(): Scheduler = Schedulers.io()
        override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
        override fun computation(): Scheduler = Schedulers.computation()
        override fun trampoline(): Scheduler = Schedulers.trampoline()
        override fun newThread(): Scheduler = Schedulers.newThread()
    }
}

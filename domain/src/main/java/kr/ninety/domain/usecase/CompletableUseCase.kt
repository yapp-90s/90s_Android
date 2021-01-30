/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.usecase

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase(
    private val executorThread: Scheduler,
    private val postExecutionThread: Scheduler
) : NoParamsUseCase() {

    protected abstract fun buildUseCaseCompletable(): Completable

    override fun get() = buildUseCaseCompletable()

    override fun execute(): Completable =
        buildUseCaseCompletable()
            .subscribeOn(executorThread)
            .observeOn(postExecutionThread)
}

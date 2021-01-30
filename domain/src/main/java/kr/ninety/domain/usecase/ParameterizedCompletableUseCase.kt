/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.usecase

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class ParameterizedCompletableUseCase<in Params>(
    private val executorThread: Scheduler,
    private val postExecutionThread: Scheduler
) : ParameterizedUseCase<Params>() {

    protected abstract fun buildUseCaseCompletable(params: Params): Completable

    override fun get(params: Params?): Completable =
        buildUseCaseCompletable(params = requireParamsNonNull(params))

    override fun execute(params: Params?): Completable =
        get(params)
            .subscribeOn(executorThread)
            .observeOn(postExecutionThread)
}

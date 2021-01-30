/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.usecase

import io.reactivex.Flowable
import io.reactivex.Scheduler

abstract class FlowableUseCase<T>(
    private val executorThread: Scheduler,
    private val postExecutionThread: Scheduler
) : NoParamsUseCase() {

    protected abstract fun buildUseCaseFlowable(): Flowable<T>

    override fun get(): Flowable<T> = buildUseCaseFlowable()

    override fun execute(): Flowable<T> =
        buildUseCaseFlowable()
            .subscribeOn(executorThread)
            .observeOn(postExecutionThread)
}

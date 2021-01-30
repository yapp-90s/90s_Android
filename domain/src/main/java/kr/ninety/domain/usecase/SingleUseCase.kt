/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCase<T>(
    private val executorThread: Scheduler,
    private val postExecutionThread: Scheduler
) : NoParamsUseCase() {

    protected abstract fun buildUseCaseSingle(): Single<T>

    override fun get(): Single<T> = buildUseCaseSingle()

    override fun execute(): Single<T> =
        buildUseCaseSingle()
            .subscribeOn(executorThread)
            .observeOn(postExecutionThread)
}

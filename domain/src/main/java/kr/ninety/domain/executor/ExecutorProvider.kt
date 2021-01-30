/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.executor

import io.reactivex.Scheduler

interface ExecutorProvider {
    fun io(): Scheduler
    fun mainThread(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
}

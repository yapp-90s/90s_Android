/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.mock

import io.reactivex.schedulers.Schedulers
import kr.ninety.domain.executor.ExecutorProvider

class TestExecutorProvider : ExecutorProvider {
    override fun io() = Schedulers.trampoline()
    override fun mainThread() = Schedulers.trampoline()
    override fun computation() = Schedulers.trampoline()
    override fun newThread() = Schedulers.trampoline()
    override fun trampoline() = Schedulers.trampoline()
}

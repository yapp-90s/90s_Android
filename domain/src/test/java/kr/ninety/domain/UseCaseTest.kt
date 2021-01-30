/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain

import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import kr.ninety.domain.mock.TestExecutorProvider
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

abstract class UseCaseTest {

    @get: Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val expectException: ExpectedException = ExpectedException.none()

    protected lateinit var testExecutorProvider: TestExecutorProvider
    
    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        testExecutorProvider = TestExecutorProvider()
    }
}

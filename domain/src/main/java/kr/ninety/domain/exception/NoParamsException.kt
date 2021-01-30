/*
 * Created by Lee Oh Hyung on 2021/01/30.
 */
package kr.ninety.domain.exception

class NoParamsException(override val message: String = "params of usecase is never be null") : Exception(message)

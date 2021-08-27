package kr.ninety.data.remote.interceptor

import kr.ninety.data.local.LocalDataSource
import okhttp3.*
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val localDataSource: LocalDataSource
): Interceptor, Authenticator {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader(HEADER_CONTENT_TYPE, "application/json")
            .addHeader(HEADER_ACCEPT, "application/json")
            .build()
        return chain.proceed(request)
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        var request: Request? = null
        try {
            request = response.request.newBuilder()
                .addHeader(HEADER_AUTH_TOKEN, localDataSource.getUserToken())
                .build()
            return request
        } catch (ex: Exception) { }
        return request
    }

    companion object {
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val HEADER_ACCEPT = "Accept"
        private const val HEADER_AUTH_TOKEN = "X-AUTH-TOKEN"
    }
}
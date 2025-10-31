package ir.postex.pos.di

import okhttp3.FormBody
import okhttp3.Interceptor
import org.json.JSONObject

import timber.log.Timber
import javax.inject.Inject

class PrettyLogInterceptor @Inject constructor(
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()

        if (request.method == "POST" && request.body is FormBody) {
            val formBody = request.body as FormBody
            val map = mutableMapOf<String, Any?>()

            for (i in 0 until formBody.size) {
                map[formBody.name(i)] = formBody.value(i)
            }

            Timber.tag("HTTP-FORM").d("➡️ Form Body:\n" + JSONObject(map).toString(2))
        }

        return chain.proceed(request)
    }
}

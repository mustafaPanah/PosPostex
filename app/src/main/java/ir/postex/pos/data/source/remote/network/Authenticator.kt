package ir.postex.pos.data.source.remote.network

import android.app.Application
import ir.postex.pos.data.source.local.DataStoreConstants
import ir.postex.pos.data.source.local.DataStoreConstants.ACCESS_TOKEN
import ir.postex.pos.data.source.local.DataStoreConstants.REFRESH_TOKEN
import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.Services
import ir.postex.pos.domain.model.poslogin.RefreshTokenRequest
import ir.postex.pos.utils.AUTHORIZATION_HEADER_KEY
import ir.postex.pos.utils.TOKEN_PREFIX
import ir.postex.pos.utils.WITHOUT_TOKEN_ANNOTATION
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Singleton
class TokenAuthenticator @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    @Named(WITHOUT_TOKEN_ANNOTATION)
    private val service: Services
) : Authenticator {

    override fun authenticate(
        route: Route?,
        response: Response
    ): Request? {

        Timber.tag("AUTH").d("============== AUTHENTICATOR ==============")
        Timber.tag("AUTH").d("Authenticator Called")

        // جلوگیری از Loop بی‌نهایت
        if (responseCount(response) >= 2) {
            Timber.tag("AUTH").d("Response Count >= 2")
            return null
        }

        // خواندن Refresh Token
        val refreshToken = runBlocking {
            dataStoreManager.getData(REFRESH_TOKEN).firstOrNull()
        }

        Timber.tag("AUTH").d("Refresh Token : $refreshToken")

        if (refreshToken.isNullOrEmpty()) {
            Timber.tag("AUTH").d("Refresh Token Is Empty")
            return null
        }

        Timber.tag("AUTH").d("Calling Refresh Api...")

        val refreshResponse = try {
            runBlocking {
                service.refreshToken(
                    RefreshTokenRequest(
                        refreshToken = refreshToken
                    )
                )
            }
        } catch (e: Exception) {
            Timber.tag("AUTH").e(e, "Refresh Api Exception")
            return null
        }

        Timber.tag("AUTH").d("Refresh Response Code : ${refreshResponse.code()}")
        Timber.tag("AUTH").d("Refresh Is Successful : ${refreshResponse.isSuccessful}")

        if (!refreshResponse.isSuccessful) {

            Timber.tag("AUTH").d("Refresh Failed")

//            runBlocking {
//                dataStoreManager.clearDataStore()
//            }

            return null
        }

        val body = refreshResponse.body()

        Timber.tag("AUTH").d("Refresh Body : $body")

        if (body == null) {
            Timber.tag("AUTH").d("Refresh Body Is Null")
            return null
        }

        Timber.tag("AUTH").d("Access Token : ${body.accessToken}")
        Timber.tag("AUTH").d("Refresh Token : ${body.refreshToken}")

        runBlocking {

            dataStoreManager.updateData(
                ACCESS_TOKEN,
                body.accessToken
            )

            dataStoreManager.updateData(
                REFRESH_TOKEN,
                body.refreshToken
            )
        }

        Timber.tag("AUTH").d("Tokens Saved Successfully")
        Timber.tag("AUTH").d("Retrying Original Request...")

        return response.request
            .newBuilder()
            .header(
                AUTHORIZATION_HEADER_KEY,
                "$TOKEN_PREFIX ${body.accessToken}"
            )
            .build()
    }

    private fun responseCount(response: Response): Int {

        var result = 1
        var current = response.priorResponse

        while (current != null) {
            result++
            current = current.priorResponse
        }

        return result
    }
}
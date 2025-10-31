package ir.postex.pos.data.source.remote.network

import android.app.Application
import ir.postex.pos.data.source.local.DataStoreConstants
import ir.postex.pos.data.source.local.DataStoreManager
import kotlinx.coroutines.DelicateCoroutinesApi
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject


class TokenAuthenticator @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val context : Application
): Authenticator {


//    private lateinit var service: ApiHelper
//    private val appPref = AppPreferenceHelper()

    @OptIn(DelicateCoroutinesApi::class)
    override fun authenticate(route: Route?, response: Response): Request? {

//        val newToken = requestToRefresh()

//        if (newToken != null) {
//            GlobalScope.launch {
//                dataStoreManager.updateData(DataStoreManager.PreferenceKeys.ACCESS_TOKEN, newToken.response?.accessToken ?: "")
//                dataStoreManager.updateData(DataStoreManager.PreferenceKeys.REFRESH_TOKEN,newToken.response?.refreshToken ?: "")
//            appPref.setLogin(true)
//            }


//            C.accessToken = appPref.getAccessToken()!!
//            C.refreshToken = appPref.getRefreshToken()

            return response.request.newBuilder()
                .header("Accept", "application/json")
                .header("Authorization", dataStoreManager.getData(DataStoreConstants.ACCESS_TOKEN).toString())
                .build()
//        } else run {
////            appPref.setLogin(false)
//            goToLogin()
//            // refresh failed , maybe you can logout user
//            // returning null is critical here, because if you do not return null
//            // it will try to refresh token continuously like 1000 times.
//            // also you can try 2-3-4 times by depending you before logging out your user
//            return null
//        }
    }

    private fun requestToRefresh()
//    : VerifyResponse?
    {

//        service = ApiClient.getBaseClient().create(ApiHelper::class.java)
//
//        val json = JsonObject()
//        json.addProperty("refresh_token", C.refreshToken)
//        json.addProperty("client_id", BuildConfig.client_id)
//        json.addProperty("client_secret", BuildConfig.client_secret)
//
//        val tasks = service.refreshToken(json)
//
//        var newToken: VerifyResponse? = null
//        try {
//            val response = tasks.execute()
//
//            if (response.isSuccessful) {
//                newToken = Gson().fromJson(response.body()!!.toString(), VerifyResponse::class.java)
//            }
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//        return newToken
    }

    private fun goToLogin() {

//        val loginIntent = Intent()
//        loginIntent.setClass(MvvmApp.context(), LoginActivity::class.java)
//        loginIntent.action = LoginActivity::class.java.name
//        loginIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        MvvmApp.context().startActivity(loginIntent)

    }
}
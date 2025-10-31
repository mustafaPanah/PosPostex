package ir.postex.pos.data.source.remote

import com.persianswitch.smartpos.webservice.LoginResponse
import ir.postex.pos.domain.model.OTPResponse
import ir.postex.pos.domain.model.VerifyOtpResponse
import ir.postex.pos.domain.model.poslogin.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Services {

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/api/v1/auth/otp/send")
    suspend fun sendOtp(@Field("mobile") phone: String): Response<OTPResponse>

    @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/api/app/v1/auth/login")
    suspend fun login(@Field("username") username: String,@Field("password")password:String,@Field("app_name")appName:String,@Field("channel")channel:String): Response<LoginResponse>

    @POST("/api/app/v1/auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

}
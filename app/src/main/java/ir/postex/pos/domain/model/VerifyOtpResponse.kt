package ir.postex.pos.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VerifyOtpResponse(
    @Json(name = "token_type")
    val tokenType: String?,

    @Json(name = "access_token")
    val accessToken: String?,

    @Json(name = "expires_at")
    val expiresAt: String?,

    @Json(name = "user")
    val user: User?
)
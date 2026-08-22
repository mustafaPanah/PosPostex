package ir.postex.pos.domain.model.poslogin

import com.squareup.moshi.Json

data class RefreshTokenRequest(
    @Json(name = "refresh_token")
    val refreshToken: String
)

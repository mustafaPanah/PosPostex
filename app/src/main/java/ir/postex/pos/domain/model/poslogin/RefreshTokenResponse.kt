package ir.postex.pos.domain.model.poslogin

import com.squareup.moshi.Json

data class RefreshTokenResponse(

    @Json(name = "token")
    val accessToken: String,

    @Json(name = "refresh_token")
    val refreshToken: String
)

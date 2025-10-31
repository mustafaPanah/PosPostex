package ir.postex.pos.domain.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OTPResponse(
    @Json(name = "message")
    val message: String?
)
package ir.postex.pos.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthErrorResponse(
    @Json(name = "type")
    val type: String,
    @Json(name = "title")
    val title: String? ,
    @Json(name = "traceId")
    val traceId: String? ,
    @Json(name = "status")
    val status: Int?
)
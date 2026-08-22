package ir.postex.pos.domain.model.enroll

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EnrollResponse(
    @Json(name = "deviceId")
    val deviceId: Int?,
    @Json(name = "message")
    val message: String?,
)
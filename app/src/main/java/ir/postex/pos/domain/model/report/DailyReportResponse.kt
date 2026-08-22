package ir.postex.pos.domain.model.report

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyReportResponse(
    val items: List<DailyReportItem>  // آرایه رو توی یه فیلد بچین
)

@JsonClass(generateAdapter = true)
data class DailyReportItem(
    @Json(name = "key") val key: String,
    @Json(name = "title") val title: String,
    @Json(name = "value") val value: String
)

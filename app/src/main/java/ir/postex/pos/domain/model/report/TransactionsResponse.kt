package ir.postex.pos.domain.model.report

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionsResponse(
    val items: List<TransactionsItem>  // آرایه رو توی یه فیلد بچین
)

@JsonClass(generateAdapter = true)
data class TransactionsItem(
    @Json(name = "amount") val amount: Long,
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "rowId") val rowId: String,
    @Json(name = "stan") val stan: String,
    @Json(name = "referenceNo") val referenceNo: Long,
    @Json(name = "rrn") val rrn: Long,
)

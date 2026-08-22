package ir.postex.pos.domain.model.topup

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class TopUpResponse(
    @Json(name = "amount")
    val amount: Long?,

    @Json(name = "remainingBalance")
    val remainingBalance: Long?,
    @Json(name = "transactionID")
    val transactionID: String?,
    @Json(name = "referenceNo")
    val referenceNo: String?,
)



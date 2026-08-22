package ir.postex.pos.domain.model.inquiry

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@Serializable
@JsonClass(generateAdapter = true)
data class InquiryResponse(
    @Json(name = "codAmount")
    val codAmount: Long?,
    @Json(name = "shippingPayableAmount")
    val shippingPayableAmount: Long?,
    @Json(name = "otherPayableAmount")
    val otherPayableAmount: Long?,
    @Json(name = "totalPayableAmount")
    val totalPayableAmount: Long?,


    @Json(name = "trackingNo")
    val trackingNo: String?,

    @Json(name = "payer")
    val payer: String?,

    @Json(name = "paymentType")
    val paymentType: String?,

    @Json(name = "deliveryStatus")
    val deliveryStatus: String?,

    @Json(name = "calculatedAt")
    val calculatedAt: String?,

    @Json(name = "receiver")
    val receiver: InquiryReceiver?,
)
@Serializable
@JsonClass(generateAdapter = true)
data class InquiryReceiver(
    @Json(name = "name")
    val name: String?,
    @Json(name = "mobile")
    val mobile: String?,
    @Json(name = "address")
    val address: String?,
)

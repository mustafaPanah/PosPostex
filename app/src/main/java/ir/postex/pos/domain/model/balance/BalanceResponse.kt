package ir.postex.pos.domain.model.balance

import com.persianswitch.smartpos.webservice.ValueAddedRequirements
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BalanceResponse(
    @Json(name = "amount")
    val amount: Long?,
    @Json(name = "frozenAmount")
    val frozenAmount: Long?,
    @Json(name = "userId")
    val userId: String?,

    )
